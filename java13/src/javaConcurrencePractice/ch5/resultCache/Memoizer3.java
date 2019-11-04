package javaConcurrencePractice.ch5.resultCache;

import javaConcurrencePractice.util.ThrowableUtil;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Memoizer3首先检查某个计算是否已经开始，如果还没有启动，那么就创建一个FutureTask，并注册到Map中，然后启动计算；如果已经启动，那么等待
 * 现有的计算结果。结果可能会很快得到，也可能还在运算过程中，但这对于Future.get的调用者来说时透明的。
 * Memoizer3的实现几乎是完美的：他表现出非常好的并发性（基本上是源自于ConcurrenthashMap高效的并发性），若结果已经计算出来，那么就立即
 * 返回。如果其他线程正在计算该结果，那么新到的线程将一直等待这个结果被计算出来。
 * 它只有一个缺陷，即仍然存在两个线程计算相同值得漏洞。这个漏洞的发生概率要远小于Memoizer2中发生的概率（Memoizer2中cache.get(arg)
 * 会计算完成才返回，这可能需要比较长的时间，在这段时间新的线程运行同样arg的就会重复执行计算）
 */
public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = () -> c.compute(arg);
            FutureTask<V> ft = new FutureTask<>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();//在这里调用c.compute
        }

        try {
            return f.get();
        } catch (ExecutionException e) {
            throw ThrowableUtil.launderThrowable(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Memoizer3<String, Integer> stringLength = new Memoizer3<>(String::length);
        stringLength.compute("abc");
        stringLength.compute("skfccd");
        stringLength.compute("mpsdigsdioegsd");
    }
}
