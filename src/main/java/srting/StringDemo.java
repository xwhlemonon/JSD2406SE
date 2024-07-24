package srting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[random.nextInt(6) + 5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int[] arr2 = ArrDelete.delete(arr, random.nextInt(arr.length) + 1);
        System.out.println(Arrays.toString(arr2));
    }
}
