package javaConcurrencePractice.ch5.resultCache;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //模拟在经过长时间的计算后
        Thread.sleep(2000);
        return new BigInteger(arg);
    }
}
