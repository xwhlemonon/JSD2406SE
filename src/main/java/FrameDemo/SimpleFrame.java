package FrameDemo;

import javax.swing.*;
import java.awt.*;

public class SimpleFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
            frame.setTitle("NoteHello");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
