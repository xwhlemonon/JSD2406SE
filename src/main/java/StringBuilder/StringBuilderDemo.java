package StringBuilder;

public class StringBuilderDemo {
    public static void main(String[] args) {
        String ch = "hello world! i love java!";
        StringBuilder str = new StringBuilder(ch);
        str.append("No, No, No!")
        .replace(0, 11, "Yes")
        .delete(4, 6).insert(5,"i ");
        System.out.println(str);
    }
}
