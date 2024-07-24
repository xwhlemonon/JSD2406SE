package Handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 implements Runnable {
    public ServerSocket ss= new ServerSocket(8888);
    public Socket socketIn;

    public Server2() throws IOException {
    }

    public static void main(String[] args) {
        try {
            new Server2().started();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void started() {
        System.out.println("聊天室已启动···");
        try {
            for (int i = 1; ; i++) {
                if (i == 1) {
                    Thread t = new Thread(new Server2());
                    t.start();
                }
                socketIn = ss.accept();
                Thread t = new Thread(new InputDemo(socketIn), "用户" + i);
                t.start();
            }
        } catch (IOException e) {
            System.out.println("程序错误2···");
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        try {
            Socket socketOut = new Socket("127.0.0.1", 8887);
            Thread t = new Thread(new OutputDemo(socketOut));
            t.start();
        } catch (IOException e) {
            System.out.println("程序错误3···");
            System.exit(-1);
        }
    }
}
