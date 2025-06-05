import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TriangleButton extends JButton{

    public TriangleButton(String label, int width, int height) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = width;
        size.height = height;
        setPreferredSize(size);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(new Color(0, 0, 0, 0));
    }

    protected void paintComponent(Graphics g) {
        if (!isVisible()) {
            return;
        }
        super.paintComponent(g);
    }

    Polygon polygon;
    public boolean contains(int x, int y) {
        if (polygon == null || !polygon.getBounds().equals(getBounds())) {
            int xPoints[] = {0, getSize().width/2, getSize().width};
            int yPoints[] = {0, getSize().height, 0};
            polygon = new Polygon(xPoints,yPoints, xPoints.length);
        }
        return polygon.contains(x, y);
    }
}
