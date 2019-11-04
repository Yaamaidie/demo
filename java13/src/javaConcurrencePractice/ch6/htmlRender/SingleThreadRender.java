package javaConcurrencePractice.ch6.htmlRender;

import javaConcurrencePractice.bean.ImageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 串行的渲染页面元素
 */
public class SingleThreadRender {
    void renderPage(CharSequence source) {
        //渲染文本
        renderText(source);
        /*扫描source将图形数据收集起来*/
        List<ImageData> imageData = new ArrayList<>();
        for (ImageInfo imageInfo : scanForImageInfo(source)) {
            imageData.add(imageInfo.downloadImage());
        }
        //分别渲染每一个图形对象
        for (ImageData data : imageData) {
            renderImage(data);
        }
    }

    void renderText(CharSequence source) {
    }

    List<ImageInfo> scanForImageInfo(CharSequence source) {
        return new ArrayList<>();
    }

    void renderImage(ImageData data) {}
}
