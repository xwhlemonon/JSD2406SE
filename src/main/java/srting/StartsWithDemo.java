package srting;

import java.util.Scanner;

public class StartsWithDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if ((line.startsWith("www", 8)) || (line.startsWith("www", 7))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
