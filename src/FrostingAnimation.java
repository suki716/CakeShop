import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FrostingAnimation implements ActionListener {
    private ArrayList<BufferedImage> frames;
    private Timer timer;
    private int currentFrame;
    private BufferedImage img;

    public FrostingAnimation(String batter, String str) {
        try {
            img = ImageIO.read(new File("src/" + batter + "Batter/" + batter + str + "-00.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i <= 12; i++) {
            String idx = "" + i;
            if (idx.length() == 1) {
                idx = "0" + idx;
            }
            String filename = "src/" + batter + "Batter/" + batter + str + "-" + idx + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        this.frames = images;
        currentFrame = 0;
        timer = new Timer(100, this);
    }

    public BufferedImage getActiveFrame() {
        return frames.get(currentFrame);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            currentFrame = (currentFrame + 1) % frames.size();
            if (currentFrame == 12) {
                timer.stop();
            }
        }
    }

    public void start() {
        timer.start();
    }
}
