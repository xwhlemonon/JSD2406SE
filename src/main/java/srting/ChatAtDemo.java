package srting;

public class ChatAtDemo {
    public static void main(String[] args) {
        String str = "https://17roco.qq.com";
        System.out.println(str.charAt(7));
        String str1 = "上海自自海上";
        System.out.println(anagram(str1));
    }

    public static boolean anagram(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            if ((str.charAt(i)) != (str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
