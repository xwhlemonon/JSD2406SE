package ChatRoomV2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    private final HashMap<String, Socket> users = new HashMap<>();

    public static void main(String[] args) {
        new Server().serverOpen();
    }

    public void serverOpen() {
        System.out.println("等待连接中···");
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3));
            for (int i = 1; ; i++) {
                Socket socket = serverSocket.accept();
                users.put("" + i, socket);
                ServerInputOutput sio = new ServerInputOutput(users, socket, "" + i);
                threadPoolExecutor.execute(sio);
            }
        } catch (IOException e) {
            System.out.println("连接错误···");
            System.exit(-1);
        }
    }
}
