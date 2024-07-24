package Handler;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OutputDemo implements Runnable {
    private final Socket socket;
    Scanner scan;
    PrintWriter pw;

    public OutputDemo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            scan = new Scanner(System.in);
            pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true);
            String str;
            while (true) {
                str = scan.nextLine();
                pw.println(str);
                if (str.equalsIgnoreCase("exit")) {
                    System.out.println("已退出···");
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("程序错误5···");
            System.exit(-1);
        }finally {
            scan.close();
            pw.close();
        }
    }
}
