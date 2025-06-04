import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WalkingAnimation implements ActionListener {
    private ArrayList<BufferedImage> frames;
    private Timer timer;
    private int currentFrame;
    private BufferedImage img;
    private int x = 10;

    public WalkingAnimation() {
        try {
            img = ImageIO.read(new File("src/Walking/frame_00_delay-0.02s.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i <= 59; i++) {
            String idx = "" + i;
            if (idx.length() == 1) {
                idx = "0" + idx;
            }
            String filename = "src/Walking/frame_" + idx + "_delay-0.02s.png";
            try {
                images.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        this.frames = images;
        currentFrame = 0;
        timer = new Timer(10, this);
    }

    public BufferedImage getActiveFrame() {
        return frames.get(currentFrame);
    }

    public int getX() {
        return x;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            currentFrame = (currentFrame + 1) % frames.size();
            x += 3;
        }
    }

    public void start() {
        timer.start();
    }

    public void start(boolean val) {
        if (val) {
            x = 10;
        }
        start();
    }

    public void stop() {
        timer.stop();
    }
}
