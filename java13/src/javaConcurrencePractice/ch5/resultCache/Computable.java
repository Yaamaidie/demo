package javaConcurrencePractice.ch5.resultCache;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
