package FlyDemo;

import javax.swing.*;
import java.io.IOException;

public class World extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 700;
    public static final String IMG = "./src/main/java/FlyDemo/img";


    public World() throws IOException {
        Hero hero = new Hero();
    }

    public static void main(String[] args) {
        try {
            World world = new World();
            JFrame jf = new JFrame();
            jf.add(world);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(WIDTH, HEIGHT);
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        } catch (IOException e) {
            System.out.println("流错误···");
            System.exit(-1);
        }
    }
}
