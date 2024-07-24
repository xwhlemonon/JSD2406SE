package doc;

import java.util.Arrays;

/**
 * 这里是注释<p>6<p>这里是注释
 *
 * @author xwh
 * @version 1.1
 * @see doc.DocApiDemo
 * @since jdk1.8
 */
public class StringApiDemo {
    public static void main(String[] args) {
        String note = "https://www.google.com";
        char[] no = note.toCharArray();
        System.out.println(note.length());
        System.out.println(Arrays.toString(no));
        for (char i : no) {
            System.out.print(i);
        }
        System.out.println();
        char[] no1 = Arrays.copyOf(no, no.length - 4);
        char[] no2 = new char[no1.length - 12];
        System.arraycopy(no1, 12, no2, 0, 6);
        for (char i : no2) {
            System.out.print(i);
        }
        System.out.println();
    }
}
