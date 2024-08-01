package DataDemo;

import javax.swing.*;

public class JF extends JFrame {
    public JF() {
        JPanel jp = new JPanel();
        add(jp);
        jp.add(new PicFrame());
    }
}
