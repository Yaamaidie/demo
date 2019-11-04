package javaConcurrencePractice.ch5.resultCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Memoizer1的改进版，Memoizer2可以被多线程并发的使用，使用ConcurrentHashMap代替HashMap来获得更好的并发性能。
 * 但是作为缓存仍然存在一些不足——当有两个线程同时调用compute时存在一个漏洞，可能会导致计算得到相同的值。对于只提供单次初始化的对象缓存来说，
 * 这个漏洞就会带来安全风险（初始化了两次）。
 */
public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
