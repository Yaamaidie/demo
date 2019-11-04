package javaConcurrencePractice.ch5.resultCache;

import javaConcurrencePractice.util.ThrowableUtil;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Memoizer的最终实现，利用ConcurrentMap中的原子方法putIfAbset，避免Memoizer3的漏洞。
 * 当缓存是Future而不是值时，将导致缓存污染问题：如果某个计算被取消或者失败，那么以后再取这个结果时将失踪拿到失败的结果。为了避免这种情况，
 * 如果计算取消，那么就将Future从缓存中移除。如果监测到RuntimeException，那么也移除Future，这样将来的计算才能成功。
 */
public class Memoizer<A, V> implements Computable<A, V>{
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        //取消任务后，重新计算
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
                ft.run();//在这里调用c.compute
            }

            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);//取消任务后，重新计算
            } catch (ExecutionException e) {
                throw ThrowableUtil.launderThrowable(e);
            }
        }
    }
}
