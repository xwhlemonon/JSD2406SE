package HomeWork.Day01;

/**
 * 判断文件是否为.png格式文件
 *
 * @author xwh
 * @since jdk1.8
 */
public class Test04 {
    public static void main(String[] args) {
        String fileName = "SeTu.PNG";
        if (checkExt(fileName)) {
            System.out.println("符合要求");
        } else {
            System.out.println("不符合要求");
        }
    }

    /**
     * @param fileName 文件名
     * @return 是.png则输出true，否则为false
     */
    public static boolean checkExt(String fileName) {
        return (fileName.substring(fileName.indexOf("."))).equalsIgnoreCase(".png");
    }
}
