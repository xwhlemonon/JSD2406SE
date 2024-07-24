package Handler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class InputDemo implements Runnable {
    private final Socket socket;

    public InputDemo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream()), StandardCharsets.UTF_8));
            while (true) {
                String str = br.readLine();
                if (str.equalsIgnoreCase("exit")) {
                    System.out.println(Thread.currentThread().getName() + "已退出");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " : " + str);
            }
        } catch (IOException e) {
            System.out.println("程序错误4···");
            System.exit(-1);
        }
    }
}
