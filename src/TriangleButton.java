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
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        int xPoints[] = {0, getSize().width/2, getSize().width};
        int yPoints[] = {0, getSize().height, 0};
        g.fillPolygon(xPoints, yPoints, xPoints.length);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        int xPoints[] = {0, getSize().width/2, getSize().width};
        int yPoints[] = {0, getSize().height, 0};
        g.drawPolygon(xPoints, yPoints, xPoints.length);
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
