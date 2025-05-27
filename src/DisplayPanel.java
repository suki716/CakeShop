import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DisplayPanel extends JPanel implements ActionListener {
    //dialogue options
    private JButton next;
    private JButton cancel;
    private String order;
    private String currScreen;
    //play options
    private JButton nextFrame;
    private JButton back; //in case we can do it
    private JButton clear; //trashcan
    private JButton exit;
    private JButton spin;
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
    private BufferedImage counter;

    //cookie img
    private BufferedImage ordering;

    //gameplay
    private CakeShop cakeShop;
    private int currCake;
    private Cake userCake;
    private Walking walk;
    private Timer timer;
    private int x = 10;

    public DisplayPanel(JFrame frame) {
        //logic
        cakeShop = new CakeShop();
        order = "I want a cake!";
        currScreen = "order";
        //dialogue options
        next = new JButton("Next");
        next.addActionListener(this);
        add(next);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        add(cancel);

        //play options
        nextFrame = new JButton("NextFrame");
        nextFrame.addActionListener(this);
        add(nextFrame);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        add(clear);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        add(exit);

        spin = new JButton("spin");
        spin.addActionListener(this);
        add(spin);

        //batter flavors
        vanilla = new JButton("vanilla");
        vanilla.addActionListener(this);
        add(vanilla);

        chocolate = new JButton("chocolate");
        chocolate.addActionListener(this);
        add(chocolate);

        strawberry = new JButton("strawberry");
        strawberry.addActionListener(this);
        add(strawberry);

        lemon = new JButton("lemon");
        lemon.addActionListener(this);
        add(lemon);

        matcha = new JButton("matcha");
        matcha.addActionListener(this);
        add(matcha);

        cakeLayer = new JButton("cakeLayer");
        cakeLayer.addActionListener(this);
        add(cakeLayer);

        //frosting
        vanillaFrost = new JButton("vanillaFrost");
        vanillaFrost.addActionListener(this);
        add(vanillaFrost);

        chocolateFrost = new JButton("chocolateFrost");
        chocolateFrost.addActionListener(this);
        add(chocolateFrost);

        strawberryFrost = new JButton("strawberryFrost");
        strawberryFrost.addActionListener(this);
        add(strawberryFrost);

        peppermintFrost = new JButton("peppermintFrost");
        peppermintFrost.addActionListener(this);
        add(peppermintFrost);

        peachFrost = new JButton("peachFrost");
        peachFrost.addActionListener(this);
        add(peachFrost);

        //toppings
        candles = new JButton("candles");
        candles.addActionListener(this);
        add(candles);

        strawberries = new JButton("strawberries");
        strawberries.addActionListener(this);
        add(strawberries);

        chocolateBar = new JButton("chocolateBar");
        chocolateBar.addActionListener(this);
        add(chocolateBar);

        apple = new JButton("apple");
        apple.addActionListener(this);
        add(apple);

        cinnamonStick = new JButton("cinnamonStick");
        cinnamonStick.addActionListener(this);
        add(cinnamonStick);

        leaves = new JButton("leaves");
        leaves.addActionListener(this);
        add(leaves);

        //images
        bgCounter = loadImage("bgCounter.png");
        counter = loadImage("Counter.png");
        walk = new Walking();
        ordering = loadImage("Ordering.webp");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clear();
        //background
        g.drawImage(bgCounter, 0, 0, null);
        //constant buttons
        exit.setVisible(true);
        exit.setLocation(10, 10);
        if (!currScreen.equals("order")) {
            nextFrame.setVisible(true);
            nextFrame.setLocation(675, 425);
        }
        if (currScreen.equals("order")) {
            //animation
            walk.start();
            if (walk.getX() <= 400) {
                g.drawImage(walk.getActiveFrame(), walk.getX(), 200, walk.getActiveFrame().getWidth(), walk.getActiveFrame().getHeight(), null);
            } else {
                walk.stop();
                g.drawImage(ordering, 400, 200, null);
                g.setFont(new Font("Helvetica ", Font.BOLD, 25));
                g.setColor(Color.BLACK);
                g.drawString(order, 300, 60);
                next.setVisible(true);
                next.setLocation(550, 45);
                cancel.setVisible(true);
                cancel.setLocation(550, 75);
            }
            //g.drawImage(counter, 0, 0, null);
        } else if (currScreen.equals("batter")) {
            //choose flavor
            vanilla.setVisible(true);
            vanilla.setLocation(50, 200);
            chocolate.setVisible(true);
            chocolate.setLocation(150, 200);
            strawberry.setVisible(true);
            strawberry.setLocation(250, 200);
            lemon.setVisible(true);
            lemon.setLocation(350, 200);
            matcha.setVisible(true);
            matcha.setLocation(450, 200);
        } else if (currScreen.equals("layer")) {
            //adding cake layers
            cakeLayer.setVisible(true);
            cakeLayer.setLocation(10, 425);
            clear.setVisible(true);
            clear.setLocation(575, 425);
        } else if (currScreen.equals("frosting")) {
            //adding frosting;
            vanillaFrost.setVisible(true);
            vanillaFrost.setLocation(450, 100);
            chocolateFrost.setVisible(true);
            chocolateFrost.setLocation(525, 100);
            strawberryFrost.setVisible(true);
            strawberryFrost.setLocation(600,100);
            peppermintFrost.setVisible(true);
            peppermintFrost.setLocation(525, 130);
            peachFrost.setVisible(true);
            peachFrost.setLocation(600, 130);
            clear.setVisible(true);
            clear.setLocation(575, 425);
        } else if (currScreen.equals("topping")) {
            //add toppings
            candles.setVisible(true);
            candles.setLocation(50, 100);
            strawberries.setVisible(true);
            strawberries.setLocation(200, 100);
            chocolateBar.setVisible(true);
            chocolateBar.setLocation(50, 150);
            apple.setVisible(true);
            apple.setLocation(200, 150);
            cinnamonStick.setVisible(true);
            cinnamonStick.setLocation(500, 100);
            leaves.setVisible(true);
            leaves.setLocation(600, 100);
            clear.setVisible(true);
            clear.setLocation(575, 425);
        } else if (currScreen.equals("stats")) {
            //show stats
            spin.setVisible(true);
            spin.setLocation(10, 425);
        } else if (currScreen.equals("spin")) {
            //spin screen
            spin.setVisible(true);
            spin.setLocation(200, 300);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton casted = (JButton) e.getSource();
        if (currScreen.equals("order") && casted == next) {
            currScreen = "batter";
        } else if (currScreen.equals("batter") && casted == nextFrame) {
            currScreen = "layer";
        } else if (currScreen.equals("layer") && casted == nextFrame) {
            currScreen = "frosting";
        } else if (currScreen.equals("frosting") && casted == nextFrame) {
            currScreen = "topping";
        } else if (currScreen.equals("topping") && casted == nextFrame) {
            currScreen = "stats";
        } else if (currScreen.equals("stats") && casted == nextFrame) {
            currScreen = "order";
        } else if (currScreen.equals("stats") && casted == spin) {
            currScreen = "spin";
        } else if (currScreen.equals("spin") && casted == nextFrame) {
            currScreen = "order";
        }
        repaint();
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

    private void clear() {
        //options
        next.setVisible(false);
        cancel.setVisible(false);
        nextFrame.setVisible(false);
        clear.setVisible(false);
        exit.setVisible(false);
        spin.setVisible(false);
        //batter
        vanilla.setVisible(false);
        chocolate.setVisible(false);
        strawberry.setVisible(false);
        lemon.setVisible(false);
        matcha.setVisible(false);
        cakeLayer.setVisible(false);
        //frost
        vanillaFrost.setVisible(false);
        chocolateFrost.setVisible(false);
        strawberryFrost.setVisible(false);
        peachFrost.setVisible(false);
        peppermintFrost.setVisible(false);
        //toppings
        candles.setVisible(false);
        strawberries.setVisible(false);
        chocolateBar.setVisible(false);
        apple.setVisible(false);
        cinnamonStick.setVisible(false);
        leaves.setVisible(false);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File("src\\" + path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}