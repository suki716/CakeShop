import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DisplayPanel extends JPanel implements ActionListener {
    //dialogue options
    private JButton next;
    private JButton cancel;
    //play options
    private JButton nextFrame;
    private JButton back; //in case we can do it
    private JButton clear; //trashcan
    private JButton exit;
    //private JButton recipe;

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
    private JButton peppermintFrost; //locked
    private JButton peachFrost; //locked
    //toppings
    private JButton candles; //maybe
    private JButton strawberries;
    private JButton chocolateBar;
    private JButton apple; //locked
    private JButton cinnamonStick; //locked
    private JButton leaves; //locked
    private JButton sprinkles;
    private JButton birthday;

    //images
    private BufferedImage startingScreen;
    private BufferedImage bgMaking;
    private BufferedImage bgCounter;
    private BufferedImage endScreen;

    //gameplay
    private CakeShop cakeShop;
    private int currCake;
    private Cake userCake;

    public DisplayPanel(JFrame frame) {
        cakeShop = new CakeShop();
        //dialogue options
        next = new JButton("Next");
        next.addActionListener(this);
        add(next);
        next.setVisible(false);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        add(cancel);
        cancel.setVisible(false);

        //play options
        nextFrame = new JButton("NextFrame");
        nextFrame.addActionListener(this);
        add(nextFrame);
        nextFrame.setVisible(false);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        add(clear);
        clear.setVisible(false);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        add(exit);
        exit.setVisible(false);

        //batter flavors
        vanilla = new JButton("vanilla");
        vanilla.addActionListener(this);
        add(vanilla);
        vanilla.setVisible(false);

        chocolate = new JButton("chocolate");
        chocolate.addActionListener(this);
        add(chocolate);
        chocolate.setVisible(false);

        strawberry = new JButton("strawberry");
        strawberry.addActionListener(this);
        add(strawberry);
        strawberry.setVisible(false);

        lemon = new JButton("lemon");
        lemon.addActionListener(this);
        add(lemon);
        lemon.setVisible(false);

        matcha = new JButton("matcha");
        matcha.addActionListener(this);
        add(matcha);
        matcha.setVisible(false);

        //frosting
        vanillaFrost = new JButton("vanillaFrost");
        vanillaFrost.addActionListener(this);
        add(vanillaFrost);
        vanillaFrost.setVisible(false);

        chocolateFrost = new JButton("chocolateFrost");
        chocolateFrost.addActionListener(this);
        add(chocolateFrost);
        chocolateFrost.setVisible(false);

        strawberryFrost = new JButton("strawberryFrost");
        strawberryFrost.addActionListener(this);
        add(strawberryFrost);
        strawberryFrost.setVisible(false);

        peppermintFrost = new JButton("peppermintFrost");
        peppermintFrost.addActionListener(this);
        add(peppermintFrost);
        peppermintFrost.setVisible(false);

        peachFrost = new JButton("peachFrost");
        peachFrost.addActionListener(this);
        add(peachFrost);
        peachFrost.setVisible(false);

        //toppings
        candles = new JButton("candles");
        candles.addActionListener(this);
        add(candles);
        candles.setVisible(false);

        strawberries = new JButton("strawberries");
        strawberries.addActionListener(this);
        add(strawberries);
        strawberries.setVisible(false);

        chocolateBar = new JButton("chocolateBar");
        chocolateBar.addActionListener(this);
        add(chocolateBar);
        chocolateBar.setVisible(false);

        apple = new JButton("apple");
        apple.addActionListener(this);
        add(apple);
        apple.setVisible(false);

        cinnamonStick = new JButton("cinnamonStick");
        cinnamonStick.addActionListener(this);
        add(cinnamonStick);
        cinnamonStick.setVisible(false);

        leaves = new JButton("leaves");
        leaves.addActionListener(this);
        add(leaves);
        leaves.setVisible(false);
    }

    public void paintComponent(Graphics g) {
        next.setLocation(400, 50);
        cancel.setLocation(400, 100);
        nextFrame.setLocation(750, 450);
        exit.setLocation(50, 50);
    }

    public void actionPerformed(ActionEvent e) {
        JButton casted = (JButton) e.getSource();
        if (casted == next) {
        }
//
//
//        //if press start: start the day
//        userCake = cakeShop.startDay();
//        currCake++;
//        //buttons + graphics + determining cake accuracy
//
//        //after cake is done
//        int rating = cakeShop.getDay().cakeDone();
//        //diff animations depending on cake stars;

    }

    private void Clear() {
        //options
        next.setVisible(false);
        cancel.setVisible(false);
        nextFrame.setVisible(false);
        clear.setVisible(false);
        exit.setVisible(false);
        //batter
        vanilla.setVisible(false);
        chocolate.setVisible(false);
        strawberry.setVisible(false);
        lemon.setVisible(false);
        matcha.setVisible(false);
        //frost
        vanillaFrost.setVisible(false);
        chocolateFrost.setVisible(false);
        strawberryFrost.setVisible(false);
        peppermintFrost.setVisible(false);
        peppermintFrost.setVisible(false);
        //toppings
        candles.setVisible(false);
        strawberries.setVisible(false);
        chocolateBar.setVisible(false);
        apple.setVisible(false);
        cinnamonStick.setVisible(false);
        leaves.setVisible(false);
    }
}