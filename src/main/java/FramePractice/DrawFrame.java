package FramePractice;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawFrame extends JComponent {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.RED);
        Line2D x1 = new Line2D.Double((double) WIDTH / 3, 0, (double) WIDTH / 3, HEIGHT);
        Line2D x2 = new Line2D.Double((double) WIDTH / 3 * 2, 0, (double) WIDTH / 3 * 2, HEIGHT);
        Line2D y1 = new Line2D.Double(0, (double) HEIGHT / 3, WIDTH, (double) HEIGHT / 3);
        Line2D y2 = new Line2D.Double(0, (double) HEIGHT / 3 * 2, WIDTH, (double) HEIGHT / 3 * 2);
        g2.draw(x1);
        g2.draw(x2);
        g2.draw(y1);
        g2.draw(y2);
        Font font = new Font("SansSerif", Font.BOLD, 20);
        g2.setFont(font);
        String str = "Hello World";
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(str, context);
        g2.drawString(str, (float) ((double) WIDTH / 2 - bounds.getWidth() / 2), 150);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}