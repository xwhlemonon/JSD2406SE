package Chat;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserDemo {
    public static Socket s;

    public static void main(String[] args) {
        new UserDemo().interRun();
    }

    public void interRun() {
        try {
            Thread.sleep(1000);
            s = new Socket("127.0.0.1", 8888);
            System.out.println("连接成功···");
            new UserDemo().inputOutput();
        } catch (InterruptedException | IOException e) {
            System.out.println("连接错误···");
            System.exit(-1);
        }
    }

    public void inputOutput() {
        Thread tInput = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(s.getInputStream()), StandardCharsets.UTF_8))) {
                String str;
                while (true) {
                    str = br.readLine();
                    if (str.equalsIgnoreCase("exit")){
                        return;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.out.println("输入流错误···");
                System.exit(-1);
            }
        });
        Thread tOutput = new Thread(() -> {
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(s.getOutputStream()), StandardCharsets.UTF_8), true); Scanner scan = new Scanner(System.in)) {
                String str;
                while (true) {
                    str = scan.nextLine();
                    pw.println(str);
                    if (str.equalsIgnoreCase("exit")) {
                        System.out.println("已退出···");
                        pw.close();
                        s.close();
                        System.exit(-1);
                    }
                }
            } catch (IOException e) {
                System.out.println("输出流错误···");
                System.exit(-1);
            }
        });
        tInput.start();
        tOutput.start();
    }
}
