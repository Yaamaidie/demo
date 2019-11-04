package javaConcurrencePractice.ch2;

import javaConcurrencePractice.util.IntUtil;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 不安全的统计命中计数器
 */
public class UnsafeCountingFactorizer {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void service(BigInteger x) {
        BigInteger[] factors = IntUtil.factor(x);
        count++;
        System.out.println(Arrays.toString(factors));
    }
}
