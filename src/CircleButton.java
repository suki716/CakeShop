import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

//https://harryjoy.me/2011/08/21/different-button-shapes-in-swing/

public class CircleButton extends JButton {

    public CircleButton(String label, int rad) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = rad;
        size.height = rad;
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

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}
