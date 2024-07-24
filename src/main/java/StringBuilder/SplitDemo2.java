package StringBuilder;

import java.net.URI;
import java.util.Arrays;

public class SplitDemo2 {
    public static void main(String[] args) {
        String url = "https://www.baidu.com";
        URI uri;
        try {
            uri = new URI(url);
        } catch (Exception e) {
            System.out.println("Invalid URL: " + url);
            return;
        }
        String[] parts = uri.getHost().split("\\.", -1);
        System.out.println(Arrays.toString(parts));
    }
}
