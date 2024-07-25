package FlyDemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 角色
 */
public class Hero extends FlyingObject {
    private final File pic;
    private final BufferedImage bi;
    private int life;// 生命
    private int fire;// 火力值

    public Hero() throws IOException {
        pic = new File(World.IMG, "hero.jpg");
        if (!pic.exists()) {
            System.out.println("资源丢失···");
            System.exit(-1);
        }
        bi = ImageIO.read(pic);
        width = (short) bi.getWidth();
        height = (short) bi.getHeight();
        x = (short) (World.WIDTH / 2 - width / 2);
        y = (short) (World.HEIGHT / 2 - height / 2);
        life = 3;
        fire = 1;
    }
}
