package HomeWork.Day01;

import java.util.Scanner;

/**
 * {@code formJudgment}方法判断用户名合法性
 *
 * @author xwh
 * @since jdk1.8
 */
public class Test02 {
    public static void main(String[] args) {
        System.out.println("请输入用户名：");
        Scanner scan = new Scanner(System.in);
        if (!(formJudgment(scan.nextLine()))) {
            System.out.println("用户名不合法");
        }
    }

    /**
     * @param userName 获取用户名
     * @return 合法为true，不合法为false
     */
    public static boolean formJudgment(String userName) {
        return ((!userName.isEmpty()) && (userName.length() <= 20));
    }
}
