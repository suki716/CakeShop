import javax.swing.*;

public class Frame {
    public Frame() {
        JFrame frame = new JFrame("Cake Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 540);
        JPanel panel = new DisplayPanel(frame);
        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}