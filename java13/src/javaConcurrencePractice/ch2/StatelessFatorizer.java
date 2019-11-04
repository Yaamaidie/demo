package javaConcurrencePractice.ch2;

import javaConcurrencePractice.util.IntUtil;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 无状态因数分解
 */
public class StatelessFatorizer {
    public void service(BigInteger x) {
        BigInteger[] factors = IntUtil.factor(x);
        System.out.println(Arrays.toString(factors));
    }

    public static void main(String[] args) {
        StatelessFatorizer sf = new StatelessFatorizer();
        sf.service(BigInteger.valueOf(34567L));
    }
}
