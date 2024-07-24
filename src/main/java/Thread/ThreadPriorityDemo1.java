package Thread;

import java.util.Scanner;

public class ThreadPriorityDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入等待时间：");
        int t = scan.nextInt();
        new Thread(() -> {
            try {
                for (int i = t; i > 0; i--) {
                    System.out.println("还剩" + i + "秒");
                    Thread.sleep(1000);
                }
                System.out.println("时间到");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "窗口1").start();
    }
}
