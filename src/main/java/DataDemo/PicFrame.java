package DataDemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PicFrame extends JComponent {
    private BufferedImage bi;

    {
        try {
            bi = ImageIO.read(new File("./new/demo.png"));
        } catch (IOException e) {
            System.exit(-2);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (bi != null) {
            g.drawImage(bi, 0, 0, this);
        } else {
            System.exit(-1);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bi.getWidth(), bi.getHeight());
    }
}
