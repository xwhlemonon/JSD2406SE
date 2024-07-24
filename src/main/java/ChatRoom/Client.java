package ChatRoom;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private boolean onOff;

    public Client() {
        this.onOff = true;
    }

    public static void main(String[] args) {
        new Client().clientStart();
    }

    public void clientStart() {
        try {
            socket = new Socket("127.0.0.1", 8888);
            inputOutput();
        } catch (IOException e) {
            System.out.println("连接错误···");
            System.exit(-1);
        }
    }

    public void inputOutput() {
        Thread input = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream()), StandardCharsets.UTF_8))) {
                String msg;
                while (true) {
                    msg = br.readLine();
                    if (msg == null) {
                        onOff = false;
                        return;
                    }
                    System.out.println(msg);
                }
            } catch (IOException e) {
                System.out.println("输入流错误···");
                System.exit(-1);
            }
        }, "input");
        Thread output = new Thread(() -> {
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true); Scanner scan = new Scanner(System.in)) {
                String msg;
                while (true) {
                    msg = scan.nextLine();
                    pw.println(msg);
                    if (msg.equalsIgnoreCase("exit")) {
                        onOff = false;
                        System.out.println("正在断开连接···");
                    }
                }
            } catch (IOException e) {
                System.out.println("输出流错误···");
                System.exit(-1);
            }
        }, "output");
        input.setDaemon(true);
        output.setDaemon(true);
        input.start();
        output.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("主线程错误···");
            }
            if (!onOff) {
                System.out.println("已退出···");
                break;
            }
        }
    }
}
