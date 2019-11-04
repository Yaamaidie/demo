package javaConcurrencePractice.ch5.resultCache;

import javaConcurrencePractice.util.IntUtil;

import java.math.BigInteger;

/**
 * 利用结果缓存来重新实现带缓存的因式分解
 */
public class Factorizer {
    private final Computable<BigInteger, BigInteger[]> c = IntUtil::factor;
    private final Computable<BigInteger, BigInteger[]> cache = new Memoizer<>(c);

    public BigInteger[] service(BigInteger x) throws InterruptedException {
        return cache.compute(x);
    }

    public static void main(String[] args) throws InterruptedException {
        Factorizer f = new Factorizer();
        long start = System.nanoTime();
        f.service(BigInteger.valueOf(12345678));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        f.service(BigInteger.valueOf(12345678));
        System.out.println(System.nanoTime() - start);
    }
}
