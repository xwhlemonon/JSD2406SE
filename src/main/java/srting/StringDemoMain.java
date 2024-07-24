package srting;

public class StringDemoMain {
    public static void main(String[] args) {
        String str = "https://www.google.com";
        String string = "thinking in java";
        int index1 = str.indexOf(".");
        int index2 = str.lastIndexOf(".");
        int index3 = string.indexOf("in", 2);
        int index4 = string.indexOf("in", 3);
        int index5 = string.indexOf("IN");
        int index6 = string.lastIndexOf("in");

//        System.out.println(index1 + " and " + index2);
//        System.out.println(index3 + " and " + index4);
//        System.out.println(index5 + " and " + index6);
    }
}
