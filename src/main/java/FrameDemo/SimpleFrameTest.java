package FrameDemo;

import javax.swing.*;
import java.awt.*;

//继承JFame，自定义宽度、高度
public class SimpleFrameTest extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrameTest() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
