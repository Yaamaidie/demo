package javaConcurrencePractice.ch2;

import javaConcurrencePractice.util.IntUtil;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程安全的统计命中计数器
 */
public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    public void service(BigInteger x) {
        BigInteger[] factors = IntUtil.factor(x);
        Long y = count.incrementAndGet();
    }

    public static void main(String[] args) {
        CountingFactorizer cf = new CountingFactorizer();
        for (int i = 0; i < 10; i++) {
            cf.service(BigInteger.valueOf(743258L));
            System.out.println(cf.getCount());
        }
    }
}
