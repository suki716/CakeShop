import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Topping {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;

    public Topping(int x, int y, String topping) {
        xCoord = x - 473;
        yCoord = y - 255;
        if (topping.equals("Leaf")) {
            yCoord -= 48;
        }
        if (topping.equals("Cinnamon")) {
            yCoord -= 5;
            xCoord -= 15;
        }
        try {
            image = ImageIO.read(new File("src/Toppings/" + topping + "Topping.png"));
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
