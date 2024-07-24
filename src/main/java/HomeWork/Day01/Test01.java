package HomeWork.Day01;

/**
 * {@code getExtByName}方法获取文件后缀名
 *
 * @author xwh
 * @since jdk1.8
 */
public class Test01 {
    public static void main(String[] args) {
        String fileName1 = "SeTu.png";
        String fileName2 = "SeSe.js";
        System.out.println(getExtByName(fileName1));
        System.out.println(getExtByName(fileName2));
    }

    /**
     * @param fileName 待处理的文件名
     * @return 输出后缀名
     */
    public static String getExtByName(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
