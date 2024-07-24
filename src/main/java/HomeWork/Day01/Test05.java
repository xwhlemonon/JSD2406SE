package HomeWork.Day01;

import java.util.Scanner;

/**
 * 判断网站是百度还是达内还是其他
 *
 * @author xwh
 * @since jdk1.8
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个网址：");
        String url = scan.nextLine();
        if (urlJudgment(url).equals("baidu")) {
            System.out.println("这是百度");
        } else if (urlJudgment(url).equals("tedu")) {
            System.out.println("这是达内");
        } else {
            System.out.println("这是其他网站");
        }
    }

    /**
     * @param url 待处理网址
     * @return 输出网址中间信息
     */
    public static String urlJudgment(String url) {
        return url.substring(url.indexOf(".") + 1, url.indexOf(".", url.indexOf(".") + 1));
    }
}
