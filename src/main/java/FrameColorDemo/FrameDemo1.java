package FrameColorDemo;

import javax.swing.*;
import java.awt.*;


public class FrameDemo1 extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public FrameDemo1() {
        JPanel jPanel = new JPanel();
        Button yellow = new Button("Yellow");
        Button red = new Button("Red");
        Button blue = new Button("Blue");
        jPanel.add(yellow);
        jPanel.add(red);
        jPanel.add(blue);
        add(jPanel);
        yellow.addActionListener(event -> {
            jPanel.setBackground(Color.YELLOW);
        });
        red.addActionListener(event -> {
            jPanel.setBackground(Color.RED);
        });
        blue.addActionListener(event -> {
            jPanel.setBackground(Color.BLUE);
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jf = new FrameDemo1();
            jf.setTitle("改变颜色");
            jf.setSize(WIDTH, HEIGHT);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}