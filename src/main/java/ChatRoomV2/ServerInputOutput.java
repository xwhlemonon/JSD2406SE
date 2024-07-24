package ChatRoomV2;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ServerInputOutput implements Runnable {
    private HashMap<String, Socket> users;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    private String userName;

    public ServerInputOutput() {
    }

    public ServerInputOutput(HashMap<String, Socket> users, Socket socket, String userName) {
        this.users = users;
        this.socket = socket;
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true);
            br = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream()), StandardCharsets.UTF_8));
            String newUserName;
            pw.println("请输入一个昵称用于聊天：");
            newUserName = br.readLine();
            users.put(newUserName, users.remove(userName));
            userName = newUserName;
            System.out.println(userName + "已连接");
            output(userName + "已上线");
            input();
        } catch (IOException e) {
            System.out.println("服务器关闭···");
            System.exit(-1);
        } finally {
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("服务器关闭···");
                System.exit(-1);
            }
        }
    }

    public void input() {
        try {
            br = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream()), StandardCharsets.UTF_8));
            String msg;
            while (true) {
                msg = br.readLine();
                if (msg.equalsIgnoreCase("exit")) {
                    System.out.println(userName + "已断开");
                    output(userName + "已退出");
                    users.remove(userName);
                    break;
                }
                output(msg);
            }
        } catch (IOException e) {
            System.out.println("客户端关闭···");
            System.out.println(userName + "已断开");
            output(userName + "已退出");
            users.remove(userName);
            System.exit(-1);
        }
    }

    public void output(String msg) {
        try {
            pw = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()), StandardCharsets.UTF_8), true);
        } catch (IOException e) {
            System.out.println("服务器关闭···");
            System.exit(-1);
        }
        try {
            PrintWriter pwNew;
            for (Map.Entry<String, Socket> entry : users.entrySet()) {
                if (!entry.getValue().getRemoteSocketAddress().equals(socket.getRemoteSocketAddress())) {
                    pwNew = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(entry.getValue().getOutputStream()), StandardCharsets.UTF_8), true);
                    pwNew.println(userName + "：" + msg);
                }
            }
        } catch (IOException e) {
            System.out.println("输出流错误···");
            System.exit(-1);
        }
    }
}
