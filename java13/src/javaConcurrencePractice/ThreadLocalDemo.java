package javaConcurrencePractice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示线程封闭的ThreadLocal类用法
 */
public class ThreadLocalDemo {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);

    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                System.out.println(get());
            });
            t.start();
        }
    }
}
