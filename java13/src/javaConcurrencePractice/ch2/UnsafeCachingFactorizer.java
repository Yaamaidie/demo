package javaConcurrencePractice.ch2;

import javaConcurrencePractice.ch2.UnsafeCountingFactorizer;
import javaConcurrencePractice.util.IntUtil;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 不安全的因数分解缓存
 */
public class UnsafeCachingFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    public void service(BigInteger x) {
        if (x.equals(lastNumber.get())) {
            System.out.println(Arrays.toString(lastFactors.get()));
        } else {
            BigInteger[] y = IntUtil.factor(x);
            lastNumber.set(x);
            lastFactors.set(y);
        }
    }

    public static void main(String[] args) {
        UnsafeCountingFactorizer ucf = new UnsafeCountingFactorizer();
    }
}
