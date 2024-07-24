package HomeWork.Day01;

import java.util.Random;
import java.util.Scanner;

/**
 * 验证码系统
 *
 * @author xwh
 * @since jdk1.8
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String verificationCode = verificationCodeGeneration();
        System.out.println("请输入验证码：" + verificationCode);
        if (scan.nextLine().equalsIgnoreCase(verificationCode)) {
            System.out.println("验证码正确");
        } else {
            System.out.println("验证码错误");
        }
    }

    /**
     * @return 四位数的数字、大小写字母验证码
     */
    public static String verificationCodeGeneration() {
        Random ran = new Random();
        char[] ch = new char[4];
        for (int i = 0; i < 4; i++) {
            switch (ran.nextInt(3)) {
                case 0:
                    ch[i] = (char) (ran.nextInt(10) + 48);
                    break;
                case 1:
                    ch[i] = (char) (ran.nextInt(26) + 65);
                    break;
                case 2:
                    ch[i] = (char) (ran.nextInt(26) + 97);
                    break;
            }
        }
        return new String(ch);
    }
}
