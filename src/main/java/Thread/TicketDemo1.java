package Thread;

public class TicketDemo1 {
    public static void main(String[] args) {
        Ticket1 t1 = new Ticket1();
        Thread f1 = new Thread(t1, "窗口1");
        Thread f2 = new Thread(t1, "窗口2");
        Thread f3 = new Thread(t1, "窗口3");
        f1.start();
        f2.start();
        f3.start();
    }
}
