package FramePractice;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

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

    static class ChessBoard extends JComponent {
        private static final int WIDTH = 300;
        private static final int HEIGHT = 300;

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            Line2D x1 = new Line2D.Double((double) WIDTH / 3, 0, (double) WIDTH / 3, HEIGHT);
            Line2D x2 = new Line2D.Double((double) WIDTH / 3 * 2, 0, (double) WIDTH / 3 * 2, HEIGHT);
            Line2D y1 = new Line2D.Double(0, (double) HEIGHT / 3, WIDTH, (double) HEIGHT / 3);
            Line2D y2 = new Line2D.Double(0, (double) HEIGHT / 3 * 2, WIDTH, (double) HEIGHT / 3 * 2);

            g2.draw(x1);
            g2.draw(x2);
            g2.draw(y1);
            g2.draw(y2);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }
    }

}
