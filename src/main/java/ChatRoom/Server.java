package ChatRoom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private ConcurrentHashMap<String, Socket> sockets;
    private Socket socket;
    private ServerSocket ss;

    {
        try {
            ss = new ServerSocket(8888);
            sockets = new ConcurrentHashMap<>();
        } catch (IOException e) {
            System.out.println("接口错误···");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new Server().serverStart();
    }

    public void serverStart() {
        try {
            while (true) {
                System.out.println("正在等待连接···");
                socket = ss.accept();
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream()), StandardCharsets.UTF_8));
                String str;
                pw.println("请输入一个用户名");
                do {
                    str = br.readLine();
                } while (str.isEmpty());
                str = str.trim();
                sockets.put(str, socket);
                ServerForward sf = new ServerForward(sockets, socket);
                Thread t = new Thread(sf, str);
                t.start();
                pw.close();
                br.close();
            }
        } catch (IOException e) {
            System.out.println("连接错误···");
            System.exit(-1);
        }
    }
}
