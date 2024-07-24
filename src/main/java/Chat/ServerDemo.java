package Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerDemo {
    public final List<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) {
        new ServerDemo().interRunTh();
    }

    public void interRunTh() {
        try (ServerSocket ss = new ServerSocket(8888)) {
            for (int i = 1; ; i++) {
                System.out.println("等待连接中···");
                Socket s = ss.accept();
                synchronized (sockets) {
                    sockets.add(s);
                }
                System.out.println("用户" + i + "连接成功···");
                ServerInputDemo sid = new ServerInputDemo(s, sockets);
                Thread t = new Thread(sid, "用户" + i);
                t.start();
            }
        } catch (IOException e) {
            System.out.println("连接错误···");
            System.exit(-1);
        }
    }
}
