package StringBuilder;

import java.util.Arrays;
import java.util.Scanner;

public class MatchesDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mail = "\\.";
        String str = scan.nextLine();
        String[] strArr = str.split(mail);
        System.out.println(Arrays.toString(strArr));
        // ^[a-zA-Z_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+$
    }
}
