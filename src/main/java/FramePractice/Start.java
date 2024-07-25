package FramePractice;

import javax.swing.*;
import java.awt.*;

public class Start {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jf = new JFrame();
            jf.setTitle("张力666");
            jf.setVisible(true);
            jf.setSize(new Dimension(300, 300));
            jf.setResizable(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.add(new ChessBoard());
            jf.pack();
        });
    }
}
