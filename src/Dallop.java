import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dallop {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;

    public Dallop(int x, int y, String flavor) {
        xCoord = x - 475;
        yCoord = y - 260;
        try {
            image = ImageIO.read(new File("src/Frosting/" + flavor + "Frost.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public BufferedImage getImage() {
        return image;
    }
}