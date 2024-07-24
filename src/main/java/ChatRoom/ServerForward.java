package ChatRoom;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

public class ServerForward implements Runnable {
    private final ConcurrentHashMap<String, Socket> sockets;
    private final Socket socket;
    private boolean onOff = true;

    public ServerForward(ConcurrentHashMap<String, Socket> sockets, Socket socket) {
        this.sockets = sockets;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream()), StandardCharsets.UTF_8))) {
            String msg;
            while (true) {
                msg = br.readLine();
                if (msg.equalsIgnoreCase("exit")) {
                    sockets.remove(Thread.currentThread().getName());
                    onOff = false;
                    return;
                }
                output(msg);
            }
        } catch (IOException e) {
            System.out.println("流错误···");
            System.exit(-1);
        }
    }

    public void output(String msg) {
        try {
            if (sockets.size() != 1) {
                PrintWriter pw;
                for (Socket s : sockets.values()) {
                    if (!s.getRemoteSocketAddress().equals(socket.getRemoteSocketAddress())) {
                        pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true);
                        if (onOff) {
                            pw.println(Thread.currentThread().getName() + "：" + msg);
                        } else {
                            pw.println(Thread.currentThread().getName() + "已退出");
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
