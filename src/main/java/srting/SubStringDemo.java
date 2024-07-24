package srting;

import java.util.Scanner;

/**
 * @author xwh
 * @version 1.2
 * @see doc.StringApiDemo
 * @since jdk1.8
 */
public class SubStringDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getHostName(str));
    }

    /**
     * @param line 待截取的网址
     * @return 输出域名内容
     */
    public static String getHostName(String line) {
        return line.substring(line.indexOf(".") + 1, line.indexOf(".", line.indexOf(".") + 1));
    }
}
