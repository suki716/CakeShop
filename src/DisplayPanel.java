import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

public class DisplayPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    //dialogue options
    private JButton next;
    private JButton cancel;
    private String order1;
    private String order2;
    private String order3;
    private String order4;
    private String currScreen;
    //play options
    private JButton start;
    private JButton nextFrame;
    private JButton back; //in case we can do it
    private JButton clear; //trashcan
    private JButton exit;
    private JButton finish;
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
    private JButton candles;
    private JButton strawberries;
    private JButton chocolateBar;
    private JButton cinnamonStick; //locked
    private JButton leaves; //locked

    //images
    private BufferedImage startingScreen;
    private BufferedImage bgMaking;
    private BufferedImage bgCounter;
    private BufferedImage endScreen;
    private BufferedImage counter;
    private BufferedImage textBubble;
    private BufferedImage bgBatter;
    private BufferedImage bgFrosting;
    private BufferedImage bgTopping;

    //dollop image
    private BufferedImage vanillaFrostImg;
    private BufferedImage chocolateFrostImg;
    private BufferedImage strawberryFrostImg;
    private BufferedImage peppermintFrostImg;
    private BufferedImage peachFrostImg;

    //cookie img
    private BufferedImage ordering;

    //gameplay
    private CakeShop cakeShop;
    private Day currDay;
    private Cake currCake;
    private Cake userCake;
    private WalkingAnimation walk;
    private Timer timer;
    private int x = 10;

    //layers
    private int layers = 1;
    private BufferedImage cakeChoice;
    private boolean drawLayer = false;
    private FrostingAnimation frostingAnimation;
    private boolean frost = false;
    private boolean nextLayer = false;

    //custom cursor
    private Cursor defaultCursor;
    private Cursor customCursor;
    private boolean isCustomCursor = false;
    private String currCustom;

    private BufferedImage customCursorImage;
    private Point cursorPosition = new Point(0, 0);
    private boolean showCustomCursor = false;
    private String currentCursorType;
    private int cursorOffsetX = 0;
    private int cursorOffsetY = 0;

    //frosting
    private ArrayList<Dallop> dallops = new ArrayList<>();
    private String frostingFlavor;

    //topping
    private ArrayList<Topping> toppings = new ArrayList<>();
    private String toppingChoice;

    //user decisions
    private String batter;
    private String frosting;
    private String topping;

    //spinning
    private BufferedImage bgSpin = loadImage("Spinning/Spinning-00.png");
    private SpinningAnimation spinningAnimation = new SpinningAnimation();
    private boolean spun = false;
    private int numSpins = 0;

    //limiting placement of toppings
    private BufferedImage cakeMask;

    public DisplayPanel(JFrame frame) {
        //logic
        cakeShop = new CakeShop();
        currDay = new Day();
        currCake = currDay.newCustomer();
        userCake = new Cake();
        order1 = "Hello! I want a " + currCake.getCorrectLayer() + "-layered ";
        order2 = currCake.getCorrectBat() + " cake with " + currCake.getCorrectFrostAmt();
        order3 = currCake.getCorrectFrost() + " frosting dollops.";
        order4 = "Oh, and please add " + currCake.getCorrectTopAmt() + " " + currCake.getCorrectTop() + "!";
        currScreen = "spin";
        addMouseListener(this);
        //dialogue options
        next = new JButton("Next");
        next.addActionListener(this);
        add(next);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        add(cancel);

        //play options
        start = new JButton("Start");
        start.addActionListener(this);
        add(start);

        nextFrame = new CircleButton("NextFrame",  50);
        nextFrame.addActionListener(this);
        add(nextFrame);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        add(clear);

        exit = new CircleButton("Exit", 50);
        exit.addActionListener(this);
        add(exit);

        spin = new CircleButton("spin", 45);
        spin.addActionListener(this);
        add(spin);

        //batter flavors
        vanilla = new CircleButton("vanilla", 170);
        vanilla.addActionListener(this);
        add(vanilla);

        chocolate = new CircleButton("chocolate", 170);
        chocolate.addActionListener(this);
        add(chocolate);

        strawberry = new CircleButton("strawberry", 170);
        strawberry.addActionListener(this);
        add(strawberry);

        lemon = new JButton("lemon");
        lemon.addActionListener(this);
        add(lemon);

        matcha = new JButton("matcha");
        matcha.addActionListener(this);
        add(matcha);

        cakeLayer = new CircleButton("cakeLayer", 190);
        cakeLayer.addActionListener(this);
        add(cakeLayer);

        frostingKnife = new JButton("frostingKnife");
        frostingKnife.addActionListener(this);
        add(frostingKnife);

        //frosting
        vanillaFrost = new TriangleButton("vanillaFrost",75, 185);
        vanillaFrost.addActionListener(this);
        add(vanillaFrost);

        chocolateFrost = new TriangleButton("chocolateFrost",75,185);
        chocolateFrost.addActionListener(this);
        add(chocolateFrost);

        strawberryFrost = new TriangleButton("strawberryFrost",75,185);
        strawberryFrost.addActionListener(this);
        add(strawberryFrost);

        peppermintFrost = new TriangleButton("peppermintFrost",75,185);
        //peppermintFrost.addActionListener(this);
        //add(peppermintFrost);

        peachFrost = new TriangleButton("peachFrost", 75,185);
        //peachFrost.addActionListener(this);
        //add(peachFrost);

        //toppings
        candles = new CircleButton("candles",100);
        candles.addActionListener(this);
        add(candles);

        strawberries = new CircleButton("strawberries",100);
        strawberries.addActionListener(this);
        add(strawberries);

        chocolateBar = new CircleButton("chocolateBar",100);
        chocolateBar.addActionListener(this);
        add(chocolateBar);

        cinnamonStick = new JButton("cinnamonStick");
        cinnamonStick.addActionListener(this);
//        add(cinnamonStick);

        leaves = new JButton("leaves");
        leaves.addActionListener(this);
//        add(leaves);

        //images
        bgCounter = loadImage("Imgs/bgCounter.png");
        counter = loadImage("Imgs/Counter.png");
        walk = new WalkingAnimation();
        ordering = loadImage("Imgs/Ordering.png");
        textBubble = loadImage("Imgs/TextBubble.png");
        bgBatter = loadImage("Imgs/bgBatter.png");
        bgFrosting = loadImage("Imgs/bgFrosting.png");
        bgTopping = loadImage("Imgs/bgTopping.png");

        //animation
        timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currScreen.equals("order") && walk.getX() <= 400) {
                    repaint();
                }
            }
        });
        timer.start();

        //custom cursor
        defaultCursor = this.getCursor();
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clear();
        changeImg();
        //constant buttons
        exit.setVisible(true);
        exit.setLocation(10, 10);
        if (!currScreen.equals("order") && !currScreen.equals("start") && !currScreen.equals("batter")) {
            nextFrame.setVisible(true);
            nextFrame.setLocation(900, 480);
        }
        //individual stations
        if (currScreen.equals("start")) {
            g.drawImage(bgCounter, 0, 0, null);
            start.setVisible(true);
            start.setLocation(400, 200);
        } else if (currScreen.equals("order")) {
            //background
            g.drawImage(bgCounter, 0, 0, null);
            //animation
            if (walk.getX() < 400) {
                g.drawImage(walk.getActiveFrame(), walk.getX(), 200, walk.getActiveFrame().getWidth(), walk.getActiveFrame().getHeight(), null);
            } else {
                walk.stop();
                g.drawImage(ordering, 300, 100, null);
                g.drawImage(textBubble, 0, 0, null);
                g.setFont(new Font("Helvetica ", Font.BOLD, 20));
                g.setColor(Color.BLACK);
                g.drawString(order1, 275, 75);
                g.drawString(order2, 275, 95);
                g.drawString(order3, 275, 115);
                g.drawString(order4, 275, 135);
                g.drawString("Thank You!", 275, 155);
                next.setVisible(true);
                next.setLocation(550, 45);
                cancel.setVisible(true);
                cancel.setLocation(550, 75);
            }
            g.drawImage(counter, 0, 0, null);
        } else if (currScreen.equals("batter")) {
            //background
            g.drawImage(bgBatter, 0, 0, null);
            //choose flavor
            vanilla.setVisible(true);
            vanilla.setLocation(120, 172);
            chocolate.setVisible(true);
            chocolate.setLocation(390, 172);
            strawberry.setVisible(true);
            strawberry.setLocation(665, 172);
//            lemon.setVisible(true);
//            lemon.setLocation(350, 200);
//            matcha.setVisible(true);
//            matcha.setLocation(450, 200);
        } else if (currScreen.equals("layer")) {
            //different backgrounds depending on batter option
            if (batter != null) {
                cakeChoice = loadImage("/" + batter + "Batter/bg" + batter + ".png");
            }
            g.drawImage(cakeChoice, 0, 0, null);
            //adding cake layers
            frostingKnife.setVisible(true);
            Dimension size = getPreferredSize();
            size.width = 70;
            size.height = 280;
            frostingKnife.setPreferredSize(size);
            frostingKnife.setLocation(830, 190);
            cakeLayer.setVisible(true);
            cakeLayer.setLocation(62, 250);
            if (frost && !nextLayer) {
                cakeChoice = loadImage("/" + batter + "Batter/" + batter + "Frosted.png");
            }
            if (frost && nextLayer) {
                cakeChoice = loadImage("/" + batter + "Batter/" + batter + "2Layer.png");
            }
            g.drawImage(cakeChoice, 0, 0, null);
        } else if (currScreen.equals("frosting") && drawLayer) {
            g.drawImage(cakeChoice, 0, 0, null);
            g.drawImage(frostingAnimation.getActiveFrame(), 0, 0, null);
        } else if (currScreen.equals("frosting")) {
            //adding frosting;
            g.drawImage(bgFrosting, 0, 0, null);
            g.drawImage(frostingAnimation.getActiveFrame(), 0, 0, null);
            vanillaFrost.setVisible(true);
            vanillaFrost.setLocation(200, 270);
            chocolateFrost.setVisible(true);
            chocolateFrost.setLocation(108, 270);
            strawberryFrost.setVisible(true);
            strawberryFrost.setLocation(682, 270);
            //Image image = toolkit.getImage("src/Frosting/VanillaPiping.png");
            //Cursor customCursor = toolkit.createCustomCursor(image , new Point(0, 8), "img");
            //this.setCursor(customCursor);
        } else if (currScreen.equals("topping")) {
            //add toppings
            g.drawImage(bgTopping, 0,0,null);
            g.drawImage(frostingAnimation.getActiveFrame(), 0, 0, null);
            candles.setVisible(true);
            candles.setLocation(172, 200);
            strawberries.setVisible(true);
            strawberries.setLocation(690, 200);
            chocolateBar.setVisible(true);
            chocolateBar.setLocation(172, 340);
//            cinnamonStick.setVisible(true);
//            cinnamonStick.setLocation(500, 100);
//            leaves.setVisible(true);
//            leaves.setLocation(600, 100);
        } else if (currScreen.equals("stats")) {
            //show stats
            spin.setVisible(true);
            spin.setLocation(10, 425);
        } else if (currScreen.equals("spin")) {
            //spin screen
            g.drawImage(bgSpin, 0, 0, null);
            spin.setVisible(true);
            spin.setLocation(815, 95);
            if (spun) {
                g.drawImage(spinningAnimation.getActiveFrame(), 0, 0, null);
                if (spinningAnimation.getEnd()) {
                    spun = false;
                    bgSpin = loadImage("Spinning/" + cakeShop.spinWheel().getName() +".png");
                    spinningAnimation = new SpinningAnimation();
                }
            }
        }

        //drawing dallops
        if (!dallops.isEmpty()) {
            for (Dallop dallop : dallops) {
                g.drawImage(dallop.getImage(), dallop.getxCoord(), dallop.getyCoord(), null);
            }
        }

        //drawing toppings
        if(!toppings.isEmpty()){
            for(Topping topping : toppings){
                g.drawImage(topping.getImage(), topping.getxCoord(), topping.getyCoord(), null);
            }
        }

        //drawing cursor
        if (showCustomCursor && customCursorImage != null) {
            int x = cursorPosition.x - cursorOffsetX;
            int y = cursorPosition.y - cursorOffsetY;
            g.drawImage(customCursorImage, x, y, customCursorImage.getWidth(), customCursorImage.getHeight(), null);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton casted = (JButton) e.getSource();
        if (currScreen.equals("start") && casted == start) {
            currScreen = "order";
            walk.start();
        } else if (currScreen.equals("order") && casted == next) {
            currScreen = "batter";
        } else if (currScreen.equals("batter")) {
            if (casted == vanilla) {
                userCake.chooseBatter("vanilla");
                batter = "Vanilla";
            } else if (casted == strawberry) {
                userCake.chooseBatter("strawberry");
                batter = "Strawberry";
            } else if (casted == chocolate) {
                userCake.chooseBatter("chocolate");
                batter = "Chocolate";
            }
            if (batter != null) {
                currScreen = "layer";
            }
        } else if (currScreen.equals("layer")) {
            if (casted == nextFrame) {
                if (frostingAnimation == null) {
                    frostingAnimation = new FrostingAnimation(batter, "");
                    cakeMask = loadImage("Imgs/cakeMask1.png");
                }
                drawLayer = true;
                frostingAnimation.start();
                currScreen = "frosting";
            } else if (casted == frostingKnife) {
                frost = true;
            } else if (casted == cakeLayer && frost) {
                nextLayer = true;
                frostingAnimation = new FrostingAnimation(batter, "2");
                cakeMask = loadImage("Imgs/cakeMask2.png");
            }
        } else if (currScreen.equals("frosting") && casted == nextFrame && drawLayer) {
            drawLayer = false;
        } else if (currScreen.equals("frosting")){
            if (casted == vanillaFrost) {
                userCake.chooseFrosting("vanilla");
                frostingFlavor = "Vanilla";
            } else if (casted == strawberryFrost) {
                userCake.chooseFrosting("strawberry");
                frostingFlavor = "Strawberry";
            } else if (casted == chocolateFrost) {
                userCake.chooseFrosting("chocolate");
                frostingFlavor = "Chocolate";
            }
            if (casted != nextFrame) {
                toggleCursor(frostingFlavor);
                currentCursorType = frostingFlavor;
                loadCustomCursor("Frosting/" + frostingFlavor + "Piping.png", 5, 205);
            }
            if (casted == nextFrame && !showCustomCursor) {
                currScreen = "topping";
            }
        } else if (currScreen.equals("topping")) {
            frostingFlavor = null;
            if (casted == candles) {
                userCake.chooseTopping("candles");
                toppingChoice = "Candle";
            } else if (casted == strawberries) {
                userCake.chooseTopping("strawberries");
                toppingChoice = "Strawberries";
            } else if (casted == chocolateBar) {
                userCake.chooseFrosting("chocolate");
                toppingChoice = "ChocolateBar";
            }
            if (casted != nextFrame) {
                toggleCursor(toppingChoice);
                currentCursorType = toppingChoice;
                loadCustomCursor("Toppings/" + toppingChoice + "Topping.png", 470, 265);
            }
            if (casted == nextFrame && !showCustomCursor) {
                currScreen = "stats";
                resetCake();
            }
        } else if (currScreen.equals("stats") && casted == nextFrame) {
            currScreen = "order";
            walk.start(true);
        } else if (currScreen.equals("stats") && casted == spin) {
            currScreen = "spin";
        } else if (currScreen.equals("spin")) {
            if (casted == nextFrame) {
                currScreen = "order";
                walk.start(true);
            }
            if (casted == spin && numSpins <= 5) {
                spinningAnimation.start();
                spun = true;
                numSpins++;
            }
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && showCustomCursor && currentCursorType != null) {
            Point clickPoint = new Point(cursorPosition.x, cursorPosition.y);
            if (isPointInValidArea(clickPoint.x, clickPoint.y)) {
                if (currentCursorType.equals("Vanilla") || currentCursorType.equals("Strawberry") || currentCursorType.equals("Chocolate")) {
                    Dallop dallop = new Dallop(clickPoint.x, clickPoint.y, currentCursorType);
                    dallops.add(dallop);
                } else if (currentCursorType.equals("Candle") || currentCursorType.equals("ChocolateBar") || currentCursorType.equals("Strawberries")) {
                    Topping topping = new Topping(clickPoint.x, clickPoint.y, currentCursorType);
                    toppings.add(topping);
                }
                repaint();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorPosition = e.getPoint();
        repaint();
    }

    private void clear() {
        //options
        start.setVisible(false);
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
        frostingKnife.setVisible(false);
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
        cinnamonStick.setVisible(false);
        leaves.setVisible(false);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File("src/" + path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void loadCustomCursor(String path, int x, int y) {
        try {
            customCursorImage = ImageIO.read(new File("src/" + path));
            cursorOffsetX = x;
            cursorOffsetY = y;
        } catch (IOException e) {
            showCustomCursor = false;
            setCursor(defaultCursor);
        }
    }

    private boolean isPointInValidArea(int x, int y) {
        //check if point is within image bounds
        if (x < 0 || y < 0 || x >= cakeMask.getWidth() || y >= cakeMask.getHeight()) {
            return false;
        }
        //check if pixel at (x,y) is not transparent
        int pixel = cakeMask.getRGB(x, y);
        return (pixel >> 24) != 0x00;
    }

    private void resetCake() {
        toppings = new ArrayList<>();
        dallops = new ArrayList<>();
        frostingAnimation = null;
        frost = false;
        nextLayer = false;
        cakeChoice = null;
    }

    private void toggleCursor(String str) {
        if (showCustomCursor && currentCursorType.equals(str)) {
            showCustomCursor = false;
        } else {
            showCustomCursor = true;
        }
    }

    private void changeImg() {
        //diff batter bgs
        if (CakeHelper.batters.size() == 5) {
            bgBatter = loadImage("Imgs/bgBatter2.png");
        } else if (CakeHelper.batters.size() == 4) {
            bgBatter = loadImage("Imgs/bgBatter1.png");
        } else {
            bgBatter = loadImage("Imgs/bgBatter.png");
        }
        //diff frosting bgs
        if (CakeHelper.frosting.size() == 5) {
            bgFrosting = loadImage("Imgs/bgFrosting2.png");
        } else if (CakeHelper.frosting.size() == 4) {
            bgFrosting = loadImage("Imgs/bgFrosting1.png");
        } else {
            bgFrosting = loadImage("Imgs/bgFrosting.png");
        }
        //diff frosting bgs
        if (CakeHelper.toppings.size() == 5) {
            bgTopping = loadImage("Imgs/bgTopping2.png");
        } else if (CakeHelper.toppings.size() == 4) {
            bgTopping = loadImage("Imgs/bgTopping1.png");
        } else {
            bgTopping = loadImage("Imgs/bgTopping.png");
        }
    }
}
