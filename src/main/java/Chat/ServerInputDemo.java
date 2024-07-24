package Chat;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ServerInputDemo implements Runnable {
    private final Socket s;
    private final List<Socket> sockets;

    public ServerInputDemo(Socket s, List<Socket> sockets) {
        this.s = s;
        this.sockets = sockets;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(s.getInputStream())))) {
            String str;
            while (true) {
                str = br.readLine();
                PrintWriter pw;
                if (str.equalsIgnoreCase("exit")) {
                    System.out.println(Thread.currentThread().getName() + "已退出");
                    sockets.remove(s);
                    return;
                }
                synchronized (sockets) {
                    for (Socket socket : sockets) {
                        if (!s.getRemoteSocketAddress().equals(socket.getRemoteSocketAddress())) {
                            pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true);
                            pw.println(Thread.currentThread().getName() + "：" + str);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("输出流错误···");
            System.exit(-1);
        }
    }
}
