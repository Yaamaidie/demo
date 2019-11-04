package javaConcurrencePractice.ch5.resultCache;

import annotation.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用HashMap来保存之前计算的结果。由于HashMap不是线程安全的，因此为了确保两个线程不会同时访问HashMap，使用了非常保守的策略：给整个方法
 * 同步。这就带来一个明显的可伸缩性问题，每次只有一个线程能够执行compute。如果另一个线程正在计算结果，那么其他调用compute方法的线程可能被
 * 阻塞很长的时间。如果多个线程排队等待还未计算出来的记过，那么comput方法的计算时间可能比没有”记忆“操作的计算时间更长。显然不是我们希望通
 * 过缓存来获得性能提升的结果。
 */
public class Memoizer1<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
