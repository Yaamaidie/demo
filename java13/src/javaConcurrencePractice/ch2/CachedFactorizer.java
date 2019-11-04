package javaConcurrencePractice.ch2;

import annotation.GuardedBy;
import javaConcurrencePractice.util.IntUtil;

import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

/**
 * 线程安全的带缓存的因数分解
 */
public class CachedFactorizer {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheRatio() {
        return (double) cacheHits / (double) hits;
    }

    public void service(BigInteger x) {
        BigInteger[] factors = null;
        synchronized (this) {
            hits++;
            if (x.equals(lastNumber)) {
                cacheHits++;
                factors = lastFactors;
            }
        }
        if (factors == null) {
            //最耗时间的不同步
            factors = IntUtil.factor(x);

            synchronized (this) {
                lastNumber = x;
                lastFactors = factors;
            }
        }

        System.out.println(lastNumber);
        System.out.println(Arrays.toString(lastFactors));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int x = r.nextInt(10000000);
            CachedFactorizer cf = new CachedFactorizer();
            cf.service(BigInteger.valueOf(x));
            if (i == 0) {
                cf.service(BigInteger.valueOf(x));
            }
        }
    }
}
