package InterNet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    Socket socket = null;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 8888);
        } catch (IOException e) {
            System.out.println("程序错误···");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new Client().start();
    }

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)), true);
            String str;
            while (true) {
                str = scan.nextLine();
                pw.println(str);
                if (str.equalsIgnoreCase("exit")) {
                    System.out.println("已退出···");
                    break;
                }
            }
            scan.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("程序错误···");
            System.exit(-1);
        }
    }
}
