package javaConcurrencePractice.util;

public final class ThrowableUtil {
    private ThrowableUtil() {

    }

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw  (Error) t;
        } else {
            throw new IllegalStateException("Not unchecked", t);
        }
    }
}
