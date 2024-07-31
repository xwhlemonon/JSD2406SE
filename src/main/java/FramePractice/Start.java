package FramePractice;

import javax.swing.*;
import java.awt.*;

public class Start {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jf = new JFrame();
            jf.setVisible(true);
            jf.setTitle("张力666");
            jf.setSize(new Dimension(300, 300));
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setResizable(false);
            jf.add(new DrawFrame());
            jf.pack();
        });
    }
}
