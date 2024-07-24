package doc;

/**
 * 这里是文档注释很好<p>这里也是一个注释
 *
 * @author Xiong Wenhao
 * @version 1.0
 * @see java.lang.String
 * @since jdk1.8
 */
public class DocApiDemo {
    public static final String PEOPLE_1 = "张力";
    public static final String INFO = "你好：";

    public static void main(String[] args) {
        System.out.println(sayHello(PEOPLE_1));
    }

    /**
     * @param name 问候语的用户名
     * @return 问候语字符串，如："你好：张三"
     */
    public static String sayHello(String name) {
        return INFO + name;
    }
}
