package Thread;

public class Ticket1 implements Runnable {
    public static int num = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {
                if (!(num > 0)) {
                    System.out.println("已卖完···");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "还剩" + num-- + "张票");
            }
        }
    }
}
