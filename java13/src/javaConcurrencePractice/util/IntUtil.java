package javaConcurrencePractice.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class IntUtil {
    private IntUtil() {
    }

    /**
     * 因数分解
     * @param x 参数
     * @return 因数
     */
    public static BigInteger[] factor(BigInteger x) {
        List<BigInteger> result = new ArrayList<>();
        long num = x.longValue();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                result.add((BigInteger.valueOf(i)));
                num /= i;
                i--;
            }
        }
        result.add(BigInteger.valueOf(num));
        return result.toArray(new BigInteger[0]);
    }
}
