package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class xiaoshuo {
    public final static Pattern NEXT_PAGE = Pattern.compile("var next_page = \".*?\";");

    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://www.biquge18.com/book/158068/1249.html";
        for (int i = 0; i < 3 * 20; i++) {
            Thread.sleep(2000);
            String result = handleText(sendGet(url));
            System.out.println(result);
            Matcher matcher = NEXT_PAGE.matcher(result);
            if (matcher.find()) {
                String str = matcher.group(0);
                url = "https://www.biquge18.com" + str.substring("var next_page = \"".length(),
                        str.length() - "\";".length());
                System.out.println(url);
            }
        }

    }

    public static String handleText(String text) {
        return text.replaceAll("<p class=\"anti-transform\" style=\"margin:0\">转码页面功能异常，本站不支持转码阅读，点击页面底部\\[查看原网页\\]可正常浏览，或通过浏览器访问本页地址:", "")
                .replaceAll("<br>\\s*http://www.biquge18.com/</p><br>\\s*", "\n\n").replaceAll("<br>", "\n")
                .replaceAll("<div id=\"content\">", "\n");
    }

    public static String sendGet(String url) throws IOException {
        String result = "";
        URL realUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Host", "www.biquge18.com");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");
        connection.connect();
        int code = connection.getResponseCode();
        if (code == 200) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
            } catch (Exception e) {
                System.out.println("发送GET请求出现异常！" + e);
                e.printStackTrace();
            }
        }
        return result;
    }
}
