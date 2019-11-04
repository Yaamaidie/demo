package javaConcurrencePractice.ch3;

import annotation.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 对数值及其因数分解结果进行缓存的不可变容器类
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }

    public static void main(String[] args) {
        BigInteger[] i = new BigInteger[3];
        for (int j = 0; j < 3; j++) {
            i[j] = BigInteger.valueOf(j);
        }
        System.out.println(Arrays.toString(i));
        BigInteger[] copy = Arrays.copyOf(i, i.length);
        copy[0] = BigInteger.valueOf(4);
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(copy));
    }
}
