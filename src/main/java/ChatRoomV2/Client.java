package ChatRoomV2;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
    private boolean onOff = true;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;


    public static void main(String[] args) {
        new Client().openChatRoom();
    }

    public void openChatRoom() {
        try {
            socket = new Socket("127.0.0.1", 8888);
        } catch (IOException e) {
            System.out.println("连接错误···");
            System.exit(-1);
        }
        inputOutput();
    }

    public void inputOutput() {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        tpe.execute(() -> {
            try {
                br = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream()), StandardCharsets.UTF_8));
                String msg;
                while (onOff) {
                    msg = br.readLine();
                    if (msg == null) {
                        onOff = false;
                        return;
                    }
                    System.out.println(msg);
                }
            } catch (IOException e) {
                System.out.println("服务器关闭···");
                System.exit(-1);
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("关闭错误···");
                }
            }
        });
        tpe.execute(() -> {
            try (Scanner scan = new Scanner(System.in)) {
                pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true);
                String msg;
                while (onOff) {
                    msg = scan.nextLine();
                    pw.println(msg);
                    if (msg.equalsIgnoreCase("exit")) {
                        onOff = false;
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("输出流错误···");
                System.exit(-1);
            } finally {
                pw.close();
            }
        });
        while (onOff) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("等待错误···");
                System.exit(-1);
            }
        }
        System.exit(-1);
    }
}
