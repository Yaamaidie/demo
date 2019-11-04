package javaConcurrencePractice.ch5;

import javaConcurrencePractice.exception.DataLoadException;
import javaConcurrencePractice.util.ThrowableUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask来提前加载稍后需要的数据
 */
public class Preloader {
    private final FutureTask<ProductInfo> future = new FutureTask<>(this::loadProductInfo);
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                throw (DataLoadException) cause;
            } else {
                throw ThrowableUtil.launderThrowable(cause);
            }
        }
    }


    private ProductInfo loadProductInfo() {
        return new ProductInfo();
    }
    private class ProductInfo {}
}
