import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.GraphicsEnvironment;

public class DisplayPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    //dialogue options
    private JButton next;
    private JButton cancel;
    private String order1;
    private String order2;
    private String order3;
    private String order4;
    private String nextStr;
    private String cancelStr1;
    private String cancelStr2;
    private boolean nextChosen;
    private boolean cancelChosen;
    private String currScreen;
    //play options
    private JButton start;
    private JButton nextFrame;
    private JButton back; //in case we can do it//trashcan
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
    private JButton cakeLayer;
    private JButton frostingKnife;

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
    private BufferedImage homeScreen;
    private BufferedImage startingScreen;
    private BufferedImage bgMaking;
    private BufferedImage bgCounter;
    private BufferedImage endScreen;
    private BufferedImage counter;
    private BufferedImage textBubble;
    private BufferedImage textBubble2;
    private BufferedImage bgBatter;
    private BufferedImage bgFrosting;
    private BufferedImage bgTopping;
    private BufferedImage stats;

    //cookie img
    private BufferedImage ordering;

    //gameplay
    private CakeShop cakeShop;
    private Day currDay;
    private Cake currCake;
    private Cake userCake;
    private WalkingAnimation walk;
    private Timer timer;
    private int rating;
    private int profit;

    //layers
    private BufferedImage cakeChoice;
    private boolean drawLayer = false;
    private FrostingAnimation frostingAnimation;
    private boolean frost = false;
    private boolean nextLayer = false;

    //custom cursor
    private Cursor defaultCursor;

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
        cakeShop.addCustomer();
        order1 = "Hello! I want a " + currCake.getCorrectLayer() + "-layered ";
        order2 = currCake.getCorrectBat() + " cake with " + currCake.getCorrectFrostAmt();
        order3 = currCake.getCorrectFrost() + " frosting dollops.";
        order4 = "Oh, and please add " + currCake.getCorrectTopAmt() + " " + currCake.getCorrectTop() + "!";
        nextStr = "Thank you so much!";
        cancelStr1 = "Nope! Not a chance!";
        cancelStr2 = "You're making my cake. Or else.";
        nextChosen = false;
        cancelChosen = false;
        userCake = new Cake();
        rating = 0;
        profit = 0;
        printCurrCakeInfo();
        currScreen = "start";
        addMouseListener(this);
        //dialogue options
        next = new JButton("          ");
        next.addActionListener(this);
        add(next);

        cancel = new JButton("          ");
        cancel.addActionListener(this);
        add(cancel);

        //play options
        start = new JButton("");
        start.addActionListener(this);
        add(start);

        nextFrame = new CircleButton("NextFrame",  50);
        nextFrame.addActionListener(this);
        add(nextFrame);

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

        lemon = new CircleButton("lemon", 170);
        lemon.addActionListener(this);
        add(lemon);

        matcha = new CircleButton("matcha", 170);
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
        peppermintFrost.addActionListener(this);
        add(peppermintFrost);

        peachFrost = new TriangleButton("peachFrost", 75,185);
        peachFrost.addActionListener(this);
        add(peachFrost);

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

        cinnamonStick = new CircleButton("cinnamonStick", 100);
        cinnamonStick.addActionListener(this);
        add(cinnamonStick);

        leaves = new CircleButton("leaves", 100);
        leaves.addActionListener(this);
        add(leaves);

        //images
        homeScreen = loadImage("Imgs/HomeScreen.png");
        bgCounter = loadImage("Imgs/bgCounter.png");
        counter = loadImage("Imgs/Counter.png");
        walk = new WalkingAnimation();
        ordering = loadImage("Imgs/Ordering.png");
        textBubble = loadImage("Imgs/TextBubble.png");
        textBubble2 = loadImage("Imgs/TextBubble2.png");
        bgBatter = loadImage("Imgs/bgBatter.png");
        bgFrosting = loadImage("Imgs/bgFrosting.png");
        bgTopping = loadImage("Imgs/bgTopping.png");
        stats = loadImage("Imgs/StatDisplay.png");

        //animation
        timer = new Timer(10, new ActionListener() {
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

        //load font
        try {
            Font indieFlower = Font.createFont(Font.TRUETYPE_FONT, new File("src/Resources/IndieFlower-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(indieFlower);
            Font indieFlower24 = indieFlower.deriveFont(24f);
        } catch (IOException | FontFormatException e) {
            Font indieFlower24 = new Font("Serif", Font.PLAIN, 24);
        }

        //music
        playMusic();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clear();
        changeImg();
        Font indieFlower = new Font("Indie Flower", Font.BOLD, 20);
        g.setFont(indieFlower);
        g.setColor(new Color(239,89,144));
        //constant buttons
        setInvisible(exit, 10, 10);
        if (!currScreen.equals("order") && !currScreen.equals("start") && !currScreen.equals("batter")) {
            setInvisible(nextFrame, 900, 480);
        }
        //individual stations
        if (currScreen.equals("start")) {
            g.drawImage(bgCounter, 0, 0, null);
            g.drawImage(homeScreen, 0, 0, null);
            Dimension size = getPreferredSize();
            size.width = 300;
            size.height = 80;
            start.setPreferredSize(size);
            setInvisible(start, 100, 320);
        } else if (currScreen.equals("order")) {
            //background
            g.drawImage(bgCounter, 0, 0, null);
            g.drawImage(stats, 0,0,null);
            g.drawString("" + cakeShop.getCustomerNum(), 270, 22);
            g.drawString("" + cakeShop.getTotalMoney(), 720, 22);
            g.drawString("" + cakeShop.getTotalStars(), 860, 22);
            //animation
            if (walk.getX() < 400) {
                g.drawImage(walk.getActiveFrame(), walk.getX(), 200, walk.getActiveFrame().getWidth(), walk.getActiveFrame().getHeight(), null);
            } else {
                walk.stop();

                g.drawImage(ordering, 300, 100, null);
                g.drawImage(textBubble, 0, 0, null);
                g.setFont(indieFlower);
                g.setColor(new Color(239,89,144));

                if (nextChosen){
                    g.drawImage(textBubble2, 0, 0, null);
                    g.drawString(nextStr, 275, 112);
                } else if (cancelChosen) {
                    g.drawImage(textBubble2, 0, 0, null);
                    g.drawString(cancelStr1, 275,100);
                    g.drawString(cancelStr2,275,125);
                } else {
                    g.drawImage(textBubble, 0, 0, null);
                    g.drawString(order1, 275, 75);
                    g.drawString(order2, 275, 100);
                    g.drawString(order3, 275, 125);
                    g.drawString(order4, 275, 150);
                    setInvisible(cancel, 546,90);
                }
                setInvisible(next,546,55);
            }
            g.drawImage(counter, 0, 0, null);
        } else if (currScreen.equals("batter")) {
            //background
            nextChosen = false;
            g.drawImage(bgBatter, 0, 0, null);
            //choose flavor
            setInvisible(vanilla, 120, 172);
            setInvisible(chocolate, 390, 172);
            setInvisible(strawberry, 665, 172);
            if (CakeHelper.batters.size() >= 4) {
                setInvisible(lemon, 255, 340);
            }
            if (CakeHelper.batters.size() == 5) {
                setInvisible(matcha, 525, 340);
            }
        } else if (currScreen.equals("layer")) {
            //different backgrounds depending on batter option
            if (batter != null) {
                cakeChoice = loadImage("/" + batter + "Batter/bg" + batter + ".png");
            }
            g.drawImage(cakeChoice, 0, 0, null);
            //adding cake layers
            Dimension size = getPreferredSize();
            size.width = 70;
            size.height = 280;
            frostingKnife.setPreferredSize(size);
            setInvisible(frostingKnife, 830, 190);
            setInvisible(cakeLayer, 62, 250);
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
            setInvisible(vanillaFrost, 200, 270);
            setInvisible(chocolateFrost, 108, 270);
            setInvisible(strawberryFrost, 682, 270);
            if (CakeHelper.frosting.size() >= 4) {
                setInvisible(peppermintFrost, 790, 270);
            }
            if (CakeHelper.frosting.size() == 5) {
                setInvisible(peachFrost, 18, 270);
            }
        } else if (currScreen.equals("topping")) {
            //add toppings
            g.drawImage(bgTopping, 0,0,null);
            g.drawImage(frostingAnimation.getActiveFrame(), 0, 0, null);
            setInvisible(candles, 170, 198);
            setInvisible(strawberries, 690, 200);
            setInvisible(chocolateBar, 170, 337);
            if (CakeHelper.toppings.size() >= 4) {
                setInvisible(cinnamonStick, 690, 337);
            }
            if (CakeHelper.toppings.size() >= 4) {
                setInvisible(leaves, 42, 268);
            }
        } else if (currScreen.equals("stats")) {
            //show stats
            BufferedImage stats = loadImage( "StatsScreen/StatsScreen0" + rating + ".png");
            g.drawImage(stats,0,0,null);
            g.drawImage(frostingAnimation.getActiveFrame(), 0, 0, null);
            g.setColor(new Color(239,89,144));
            g.setFont(indieFlower);

            g.drawString("Batter: " + currCake.getCorrectBat(), 55,270);
            g.drawString("Layers: " + currCake.getCorrectLayer(), 55, 310);
            g.drawString("Frosting: " + currCake.getCorrectFrost(), 55, 350);
            g.drawString("Frosting Amount: " + currCake.getCorrectFrostAmt(),55, 390);
            g.drawString("Topping: " + currCake.getCorrectTop(),55, 430);
            g.drawString("Topping Amount: " + currCake.getCorrectTopAmt(),55, 470);

            g.drawString("Batter: " + userCake.getBatter(), 690,270);
            g.drawString("Layers: " + userCake.getCorrectLayer(), 690, 310);
            g.drawString("Frosting: " + userCake.getCorrectFrost(), 690, 350);
            g.drawString("Frosting Amount: " + userCake.getCorrectFrostAmt(),690, 390);
            g.drawString("Topping: " + userCake.getCorrectTop(),690, 430);
            g.drawString("Topping Amount: " + userCake.getCorrectTopAmt(),690, 470);

            g.setColor(Color.black);
            g.drawString("$"+ profit,486,515);

            spin.setVisible(true);
            spin.setLocation(10, 425);
        } else if (currScreen.equals("spin")) {
            //spin screen
            g.drawImage(bgSpin, 0, 0, null);
            setInvisible(spin, 815, 95);
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
        if (casted == exit) {
            System.exit(0); //closes window
        }
        if (currScreen.equals("start") && casted == start) {
            currScreen = "order";
            walk.start();
        } else if (currScreen.equals("order") && casted == cancel){
            cancelChosen = true;
        } else if (currScreen.equals("order") && casted == next && nextChosen) {
            currScreen = "batter";
            nextChosen = false;
            cancelChosen = false;
        } else if (currScreen.equals("order") && casted == next){
            nextChosen = true;
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
            } else if (casted == lemon) {
                userCake.chooseBatter("lemon");
                batter = "Lemon";
            } else if (casted == matcha) {
                userCake.chooseBatter("matcha");
                batter = "Matcha";
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
                userCake.addLayer();
                frostingAnimation = new FrostingAnimation(batter, "2");
                cakeMask = loadImage("Imgs/cakeMask2.png");
            }
        } else if (currScreen.equals("frosting") && casted == nextFrame && drawLayer) {
            drawLayer = false;
        } else if (currScreen.equals("frosting")){
            if (casted == vanillaFrost) {
                frostingFlavor = "Vanilla";
            } else if (casted == strawberryFrost) {
                frostingFlavor = "Strawberry";
            } else if (casted == chocolateFrost) {
                frostingFlavor = "Chocolate";
            } else if (casted == peppermintFrost) {
                frostingFlavor = "Peppermint";
            } else if (casted == peachFrost) {
                frostingFlavor = "Peach";
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
                userCake.chooseTopping("chocolate bars");
                toppingChoice = "ChocolateBar";
            } else if (casted == cinnamonStick) {
                userCake.chooseTopping("cinnamon");
                toppingChoice = "Cinnamon";
            } else if (casted == leaves) {
                userCake.chooseTopping("leaves");
                toppingChoice = "Leaf";
            }
            if (casted != nextFrame) {
                toggleCursor(toppingChoice);
                currentCursorType = toppingChoice;
                if (toppingChoice.equals("Cinnamon")) {
                    loadCustomCursor("Toppings/" + toppingChoice + "Topping.png", 487, 265);
                } else if (toppingChoice.equals("Leaf")) {
                    loadCustomCursor("Toppings/" + toppingChoice + "Topping.png", 470, 300);
                } else {
                    loadCustomCursor("Toppings/" + toppingChoice + "Topping.png", 470, 265);
                }
            }
            if (casted == nextFrame && !showCustomCursor) {
                currScreen = "stats";
                rating = userCake.calculateRating();
                profit = userCake.calculateProfit();
                cakeShop.addMoney(profit);
                cakeShop.addStars(rating);

                System.out.println(cakeShop.getTotalMoney());
                System.out.println(cakeShop.getTotalStars());
            }
        } else if (currScreen.equals("stats") && casted == nextFrame) {
            currScreen = "order";
            walk.start(true);
            resetCake();
        } else if (currScreen.equals("stats") && casted == spin) {
            currScreen = "spin";
            resetCake();
        } else if (currScreen.equals("spin")) {
            if (casted == nextFrame) {
                currScreen = "order";
                walk.start(true);
            }
            if (casted == spin && numSpins <= 5) {
                if (cakeShop.getTotalMoney() >= 100) {
                    cakeShop.spin();
                    spinningAnimation.start();
                    spun = true;
                    numSpins++;
                }
            }
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && showCustomCursor && currentCursorType != null) {
            Point clickPoint = new Point(cursorPosition.x, cursorPosition.y);
            if (isPointInValidArea(clickPoint.x, clickPoint.y)) {
                if (currentCursorType.equals("Vanilla") || currentCursorType.equals("Strawberry") || currentCursorType.equals("Chocolate") || currentCursorType.equals("Peppermint") || currentCursorType.equals("Peach")) {
                    Dallop dallop = new Dallop(clickPoint.x, clickPoint.y, currentCursorType);
                    dallops.add(dallop);
                    userCake.chooseFrosting(currentCursorType.toLowerCase());
                    userCake.addFrosting();
                } else if (currentCursorType.equals("Candle") || currentCursorType.equals("ChocolateBar") || currentCursorType.equals("Strawberries") || currentCursorType.equals("Cinnamon") || currentCursorType.equals("Leaf")) {
                    Topping topping = new Topping(clickPoint.x, clickPoint.y, currentCursorType);
                    toppings.add(topping);
                    userCake.addTopping();
                    userCake.chooseTopping(currentCursorType.toLowerCase());
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
        currCake = currDay.newCustomer();
        order1 = "Hello! I want a " + currCake.getCorrectLayer() + "-layered ";
        order2 = currCake.getCorrectBat() + " cake with " + currCake.getCorrectFrostAmt();
        order3 = currCake.getCorrectFrost() + " frosting dollops.";
        order4 = "Oh, and please add " + currCake.getCorrectTopAmt() + " " + currCake.getCorrectTop() + "!";
        userCake = new Cake();
        rating = 0;
        profit = 0;
        cakeShop.addCustomer();
        //toggle this during demo
        printCurrCakeInfo();
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

    private void printCurrCakeInfo(){
        System.out.println("Layer: " + currCake.getCorrectLayer());
        System.out.println("Batter: " + currCake.getCorrectBat());
        System.out.println("Frosting: " + currCake.getCorrectFrost());
        System.out.println("Frost Amt: " + currCake.getCorrectFrostAmt());
        System.out.println("Topping: " + currCake.getCorrectTop());
        System.out.println("Topping Amt: " + currCake.getCorrectTopAmt());
    }

    private void setInvisible(JButton button, int x, int y) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(new Color(0, 0, 0, 0));
        button.setVisible(true);
        button.setLocation(x, y);
    }

    private void playMusic() {
        File audioFile = new File("src/music.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // repeats song
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
