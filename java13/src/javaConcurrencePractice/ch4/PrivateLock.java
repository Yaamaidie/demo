package javaConcurrencePractice.ch4;

import annotation.GuardedBy;
import javaConcurrencePractice.ch2.Widget;

/**
 * 通过一个私有锁来保护状态
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    Widget widget;

    void someMethod() {
        synchronized (myLock) {
            //访问或修改Widget的状态
        }
    }
}
