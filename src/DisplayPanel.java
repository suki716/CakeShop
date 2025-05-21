import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DisplayPanel extends JPanel implements ActionListener {
    private JButton next;
    private JButton cancel;
    private JButton nextFrame;
    private JButton back; //in case we can do it
    private JButton clear; //trashcan
    private JButton exit;
    private JButton recipe;
    //batter flavors
    private JButton vanilla;
    private JButton chocolate;
    private JButton strawberry;
    private JButton lemon; //locked
    private JButton matcha; //locked
    private JButton cakeLayer; //hopes and dreams
    private JButton frostingKnife; //hopes and dreams

    //frosting
    private JButton vanillaFrost;
    private JButton chocolateFrost;
    private JButton strawberryFrost;
    private JButton blueberryFrost; //locked
    private JButton grapeFrost; //locked
    //toppings
    private JButton rose; //maybe
    private JButton strawberries;
    private JButton chocolateBar;
    private JButton apple; //locked
    private JButton cinnamonStick; //locked
    private JButton leaves; //locked
    //decorating - hopes and dreams
    private JButton sprinkles;
    private JButton blackPen;
    private JButton redPen;
    private JButton bluePen;

    //images
    private BufferedImage startingScreen;
    private BufferedImage bgMaking;
    private BufferedImage bgCounter;
    private BufferedImage endScreen;
    // your cake
    public DisplayPanel(JFrame frame) {

    }

    public void paintComponent(Graphics g) {

    }

    public void actionPerformed(ActionEvent e) {
        //if vanilla pressed
        //your cake.addLayer(vanilla)
        //if done pressed
        //yourcake.compare
    }
}