package srting;

public class ArrDelete {
    public static int[] delete(int[] arr, int num) {
        if ((num >= 1) && (num <= arr.length)) {
            int[] flag = new int[arr.length - 1];
            System.arraycopy(arr, 0, flag, 0, num - 1);
            System.arraycopy(arr, num, flag, num - 1, arr.length - num);
            return flag;
        } else {
            System.out.println("ERROR_SYSTEM_WINDOWS");
            return arr;
        }
    }
}
