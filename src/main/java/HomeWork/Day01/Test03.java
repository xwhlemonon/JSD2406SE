package HomeWork.Day01;

/**
 * 将一串字符串遍历输出
 *
 * @author xwh
 * @since jdk1.8
 */
public class Test03 {
    public static void main(String[] args) {
        String str = "hello world! i love java!";
        for (char i : str.toCharArray()) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
    }
}
