package javaConcurrencePractice.ch6.htmlRender;

import javaConcurrencePractice.bean.ImageInfo;
import javaConcurrencePractice.util.ThrowableUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 使用CompletetionService实现页面渲染，使得页面元素再下载完成后立即显示出来
 */
public class Render {
    private final ExecutorService exec;

    Render(ExecutorService exec) {
        this.exec = exec;
    }

    void renderPage(CharSequence source) {
        List<ImageInfo> infos = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(exec);
        for (final ImageInfo info : infos) {
            completionService.submit(info::downloadImage);
        }

        renderText(source);

        try {
            for (int t = 0, n = infos.size(); t < n; t++) {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw ThrowableUtil.launderThrowable(e);
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
