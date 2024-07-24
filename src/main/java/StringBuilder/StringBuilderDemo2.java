package StringBuilder;

public class StringBuilderDemo2 {
    public static void main(String[] args) {
        StringBuilder strBuild = new StringBuilder("6");
        for (int i = 0; i < 100000; i++) {
            strBuild.append(i);
        }
        String str = strBuild.toString();
        System.out.println("Ok");
    }
}
