package javaConcurrencePractice.ch7;

import annotation.GuardedBy;
import annotation.ThreadSafe;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 使用volatile类型的域来保存取消状态
 */
@ThreadSafe
public class PrimeGenerator implements Runnable{
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator pg = new PrimeGenerator();
        new Thread(pg).start();
        SECONDS.sleep(1);
        System.out.println(pg.get().size());
        SECONDS.sleep(1);
        System.out.println(pg.get().size());
        pg.cancel();
        System.out.println(pg.get().size());
        System.out.println(pg.get().size());
        System.out.println(pg.get().size());
    }
}
