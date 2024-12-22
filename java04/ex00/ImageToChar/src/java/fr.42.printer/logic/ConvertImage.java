package logic;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class ConvertImage {
    private Integer width = 0;
    
    public  List<Integer> convertImageToArray(String imagePath) {
        List<Integer> imageArray = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            this.width = image.getWidth();
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int pixel = image.getRGB(x, y);
                    imageArray.add(pixel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageArray;
    }
    public Integer getWidth() {
        return this.width;
    }
}
