import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpinningAnimation implements ActionListener {
    private ArrayList<BufferedImage> frames;
    private Timer timer;
    private int currentFrame;
    private BufferedImage img;
    private boolean ended;

    public SpinningAnimation() {
        try {
            img = ImageIO.read(new File("src/Spinning/Spinning-00.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            String idx = "0" + i;
            String filename = "src/Spinning/Spinning-" + idx + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        this.frames = images;
        currentFrame = 0;
        //used to be 200 - changed fro tetsing
        timer = new Timer(5, this);
        ended = false;
    }

    public BufferedImage getActiveFrame() {
        return frames.get(currentFrame);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            currentFrame = (currentFrame + 1) % frames.size();
            if (currentFrame == 5) {
                timer.stop();
                ended = true;
            }
        }
    }

    public void start() {
        timer.start();
    }

    public boolean getEnd() {
        return ended;
    }
}
