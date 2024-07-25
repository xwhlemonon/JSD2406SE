package FrameDemo;

import FrameDemo.Frame.Sans;

import javax.swing.*;
import java.awt.*;

class DrawFrame extends JFrame {
    public DrawFrame() throws HeadlessException {
        add(new Sans());
        pack();//使组件适应窗体大小
    }
}
