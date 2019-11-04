import javaConcurrencePractice.bean.Person;
import javaConcurrencePractice.bean.Point;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class Demo {

    private final static String SUBACCOUNT_FILENAME = "subAccount.txt";
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {

//        File f = new File("F:\\software");
//        /*先序遍历打印目录*/
//        listAll(f);
        /*后序遍历打印目录大小*/
//        size(f);
//        sslCheck();
        File f2 = new File("C:\\Users\\李俊\\AppData\\Local\\Temp\\tomcat.3139537471474061894.8089\\work\\Tomcat\\localhost\\ROOT");
//        File f2 = new File("F:\\upload_temp\\1561945563295");
        boolean flag = f2.mkdirs();
        System.out.println(flag);

/*        System.out.println(System.currentTimeMillis());
        System.out.println(getExpires(TimeUnit.MILLISECONDS, 1));
        System.out.println(getExpires(TimeUnit.SECONDS, 1));
        System.out.println(getExpires(TimeUnit.MINUTES, 1));
        System.out.println(getExpires(TimeUnit.HOURS, 1));

        System.out.println(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());*/

//        System.out.println(TimeUnit.MINUTES.toMillis(5) == 5 * 60 * 1000);

/*        String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        String xml = "<root>\n" +
                "\t<head>\n" +
                "\t\t<TransCode> ZW001</ TransCode>\n" +
                "\t\t<TransSeqNO>123124</ TransSeqNO>\n" +
                "   </head>\n" +
                "<body>\n" +
                "\t< BidSectionCode >1234567890</ BidSectionCode>\n" +
                "\t\t< RegionCode >510600</ RegionCode>\n" +
                "\t\t< ProjectType >1</ ProjectType>\n" +
                "< SectionClassifyCode >1234567</ SectionClassifyCode>\n" +
                "< IndustriesType >234</ IndustriesType>\n" +
                "< PurchaserMode ></ PurchaserMode>\n" +
                "\t\t< TcCreditCode >12511000080726070f</ TcCreditCode>\n" +
                "\t\t< BankNO >6214980080100010245</ BankNO>\n" +
                "< CloseTime >20191225161230</ CloseTime>\n" +
                "\t\t< BidOpenTime >20191225161230</ BidOpenTime>\n" +
                "< Amount >1500.00</ Amount >\n" +
                "< Projname>测试乐山http项目一</ Projname>\n" +
                "< SectionName>标段一</ SectionName>\n" +
                "< OwenerUnique>123456</ OwenerUnique>\n" +
                "< OwnerName>黄大朗</ OwnerName>\n" +
                "< OwnerCode>1234567890</ OwnerCode>\n" +
                "< PayerUnique>654321</ PayerUnique>\n" +
                "< PayerName>朗大黄</ PayerName>\n" +
                "< PayerCode>0987654321</ PayerCode>\n" +
                "< ProjSectionCode>abcdefg</ ProjSectionCode >\n" +
                "   </body>\n" +
                "<Signature>**** </Signature>\n" +
                "</root>";
        System.out.println(head + xml.replaceAll("\n", "").replaceAll("\t", "").replaceAll("\\s*", ""));*/

//        System.out.println(LocalDate.now());

/*        String s2 = String.join(",", "a", "b");
        System.out.println(s2);
        System.out.println(String.join(".", s2, "c"));*/

/*        String s="#1232|31212";
        System.out.println(s.startsWith("#"));
        System.out.println(s.split("\\|").length);

        List<Person> people = new ArrayList<>();
        people.add(new Person("a", "男"));
        people.add(new Person("b", "女"));
        List<Person> people1 = people.stream()
                .peek(item -> item.setName("c"))
                .collect(Collectors.toList());

        System.out.println(people);*/

/*
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        Demo.class.getResourceAsStream("/" + SUBACCOUNT_FILENAME)));) {
            String line = "";
            while ((line = in.readLine()) != null) {
                if (!line.startsWith("#")) {
                    String[] info = line.split("\\|");
                    String subAccount = info[0];
                    System.out.println(subAccount);
                    String bidderUnique = info[1];
                    String bidderName = info[1];
                    String bidderCode = null;
                    String bidderPhoneNumber = null;
                    if (info.length == 4) {
                        bidderCode = info[3];
                    }
                    if (info.length == 5) {
                        bidderCode = info[3];
                        bidderPhoneNumber = info[4];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

/*        String all = "GCJSXMXX,GCJSFDZXMXX,CGXMXX,ZFCGGKZBCGXMXX,ZFCGJZXCSCGXMXX,ZFCGJZXTPCGXMXX,ZFCGXJCGXMXX,GTGPXMXX,GTPMXMXX,CXXMXX,";
        System.out.println(all.indexOf("ZFCGXJCGXMXX"));*/

/*        File f = new File("F:/tempFile.txt");
        System.out.println(f.length());
        FileInputStream fis = new FileInputStream(f);
        byte[] data = new byte[(int) f.length()];
        fis.read(data);
//        System.out.println(Arrays.toString(data));
        fis.close();

        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            String binaryStr = Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
            sb.append(binaryStr);
        }
        System.out.println(sb);*/
    }

    //返回毫秒表示的过期时间
    private static long getExpires(TimeUnit timeUnit, long duration) {
        return timeUnit.toMillis(duration) + System.currentTimeMillis();
    }

    /*start... 后序遍历打印目录大小 */
    private static long size(File file) {
        return size(file, 0);
    }

    private static long size(File file, int depth) {
        long totalSize = file.length();
        if (file.isDirectory()) {
            for (File f :
                    file.listFiles()) {
                totalSize += size(f, depth + 1);
            }
        }
        printNameAndSize(file, depth, totalSize);

        return totalSize;
    }

    private static void printNameAndSize(File file, int depth, long size) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(file.getName() + "\t" + size);
    }
    /*...start 后序遍历打印目录大小 */

    /*start... 先序遍历打印目录 */
    private static void listAll(File file) {
        listAll(file, 0);
    }

    private static void listAll(File file, int depth) {
        printName(file, depth);
        if (file.isDirectory()) {
            for (File f :
                    file.listFiles()) {
                listAll(f, depth + 1);
            }
        }
    }

    private static void printName(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(file.getName());
    }
    /*...start 先序遍历打印目录*/


    public static void cmd() {
        String cmdStr = "taskkill /f /t /im ffmpeg.exe";
        Process process = null;
        OutHandler outHandler = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec(cmdStr);// 执行本地命令获取任务主进程
            outHandler = new OutHandler(process.getInputStream());
            outHandler.start();
        } catch (IOException e) {
            stop(outHandler);
            stop(process);
        }
    }

    private static boolean stop(Process process) {
        if (process != null) {
            process.destroy();
            return true;
        }
        return false;
    }

    private static boolean stop(Thread outHandler) {
        if (outHandler != null && outHandler.isAlive()) {
            outHandler.stop();
            return true;
        }
        return false;
    }

    static class OutHandler extends Thread {

        @Override
        public void run() {
            String msg = null;
            try {
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                }

            } catch (IOException e) {
            } finally {
            }
        }

        /**
         * 读取输出流
         */
        private BufferedReader br = null;

        /**
         * 输出类型
         */
        private String type = null;

        OutHandler(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }
    }


    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static void sslCheck() throws NoSuchAlgorithmException, KeyManagementException, IOException {
        SSLContext context = SSLContext.getInstance("TLSv1.2");
        context.init(null, null, null);

        SSLSocketFactory factory = (SSLSocketFactory) context.getSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket();

        String[] protocols = socket.getSupportedProtocols();

        System.out.println("SupportedProtocols:" + protocols.length);
        for (int i = 0; i < protocols.length; i++) {
            System.out.println("" + protocols[i]);
        }

        protocols = socket.getEnabledProtocols();

        System.out.println("EnabledProtocols:" + protocols.length);
        for (int i = 0; i < protocols.length; i++) {
            System.out.println("" + protocols[i]);
        }
    }
}
