package StreamKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyRead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key;
        do {
            key = br.readLine();
            System.out.println(key);
        } while (!key.equals("q"));
    }
}
