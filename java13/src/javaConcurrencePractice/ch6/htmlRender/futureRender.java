package javaConcurrencePractice.ch6.htmlRender;

import javaConcurrencePractice.bean.ImageInfo;
import javaConcurrencePractice.util.ThrowableUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用Future等待图像下载
 */
public class futureRender {
    private static final int NTHREADS = 1;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task = () -> {
            List<ImageData> result = new ArrayList<>();
            for (ImageInfo imageInfo : imageInfos) {
                result.add(imageInfo.downloadImage());
            }
            return result;
        };
        Future<List<ImageData>> future = exec.submit(task);
        renderText(source);

        List<ImageData> imageData = null;
        try {
            imageData = future.get();
            for (ImageData data : imageData) {
                renderImage(data);
            }
        } catch (InterruptedException e) {
            //重新设置线程中断状态
            Thread.currentThread().interrupt();
            //由于不需要结果，因此取消任务
            future.cancel(true);
        } catch (ExecutionException e) {
            throw ThrowableUtil.launderThrowable(e.getCause());
        }

    }

    void renderText(CharSequence source) {
    }

    List<ImageInfo> scanForImageInfo(CharSequence source) {
        return new ArrayList<>();
    }

    void renderImage(ImageData data) {
    }
}
