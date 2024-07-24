package srting;

import java.util.Scanner;

public class EqualsDemo {
    public static final String FLAG = "qIE2i4";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(name.equals(FLAG));
        while (!(name.equalsIgnoreCase(scanner.nextLine()))) {
            System.out.println(false);
        }
    }
}
