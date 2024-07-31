package DataDemo;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        int x = 0, y = 0;
        do {
            if (x % 3 == 0) {
                x++;
                continue;
            }
            x++;
            y += x;
        } while (x < 4);
        System.out.println(y);
    }
}
