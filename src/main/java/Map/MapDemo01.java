package Map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo01 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("语文", "50");
        map.put("英语", "50");
        map.put("数学", "90");
        System.out.println(map);
        map.put("数学", "50");
        System.out.println(map);
        System.out.println(map.get("数学"));
    }
}
