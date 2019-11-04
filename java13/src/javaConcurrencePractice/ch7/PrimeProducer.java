package javaConcurrencePractice.ch7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("thread stop");
    }

    public void cancel() {
        interrupt();
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<BigInteger> primes = new LinkedBlockingQueue<>();
        PrimeProducer primeProducer = new PrimeProducer(primes);
        primeProducer.start();
        TimeUnit.SECONDS.sleep(2);
        primeProducer.cancel();
    }
}
