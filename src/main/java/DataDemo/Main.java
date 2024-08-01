package DataDemo;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jf = new JF();
            jf.setTitle("Title");
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.setSize(WIDTH, HEIGHT);
            jf.pack();
            jf.setVisible(true);
        });
    }
}
