package javaConcurrencePractice;

import javaConcurrencePractice.ch2.Widget;

public class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println("LoggingWidget");
        super.doSomething();
    }

    public static void main(String[] args) {
        LoggingWidget lw = new LoggingWidget();
        lw.doSomething();
    }
}
