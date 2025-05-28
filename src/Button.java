import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

//https://harryjoy.me/2011/08/21/different-button-shapes-in-swing/

public class Button extends JButton {

    public Button(String label, int rad) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = rad;
        size.height = rad;
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width-1, getSize().height-1);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1, getSize().height-1);
    }

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}
