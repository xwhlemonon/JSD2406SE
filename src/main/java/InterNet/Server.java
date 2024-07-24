package InterNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    ServerSocket serverSocket = null;
    Socket socket = null;

    public Server() {
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("连接中···");
            socket = serverSocket.accept();
            System.out.println("连接成功···");
            System.out.println("客户端为：\t" + socket);
        } catch (IOException e) {
            System.out.println("程序错误···");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            String str;
            while (true) {
                str = br.readLine();
                if (str.equalsIgnoreCase("exit")) {
                    System.out.println("已退出");
                    break;
                }
                System.out.println(str);
            }
            socket.close();
            serverSocket.close();
            br.close();
        } catch (IOException e) {
            System.out.println("程序错误···");
            System.exit(-1);
        }
    }
}
