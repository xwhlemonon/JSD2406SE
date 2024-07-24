package Handler;

import java.io.IOException;
import java.net.Socket;

public class OutInter implements Runnable {
    @Override
    public void run() {
        try {
            Socket socketOut = new Socket("127.0.0.1", 8888);
            Thread t = new Thread(new OutputDemo(socketOut));
            t.start();
        } catch (IOException e) {
            System.out.println("程序错误···");
            System.exit(-1);
        }
    }
}
