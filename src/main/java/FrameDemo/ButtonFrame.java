package FrameDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class ButtonFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private final JPanel buttonPanel;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //创建按钮
        JButton Button = new JButton("Color");
        //将按钮加入面板
        buttonPanel = new JPanel();
        buttonPanel.add(Button);
        //将面板加入窗体
        add(buttonPanel);
        //创建事件监听器
        ColorAction Action = new ColorAction();
        //监听
        Button.addActionListener(Action);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    class ColorAction implements ActionListener {
        private final List<Color> colors = new LinkedList<>();

        public ColorAction() {
            colors.add(Color.RED);
            colors.add(Color.YELLOW);
            colors.add(Color.BLUE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                while (true) {
                    for (Color color : colors) {
                        Thread.sleep(300);
                        buttonPanel.setBackground(color);
                    }
                }
            } catch (InterruptedException ex) {
                System.exit(-1);
            }
        }
    }
}
