package StringBuilder;

public class ReplaceAllDemo {
    public static void main(String[] args) {
        //
        String regex = "(cnm|sb|88|jb|lbg|dsb)";
        String message = "cnm, You are jb, djb.";
        message = message.replaceAll(regex, "***");
        System.out.println(message);
    }
}
