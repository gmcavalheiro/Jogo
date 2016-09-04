package jogo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage loadImage(String caminho){
        try {
            return ImageIO.read(ImageLoader.class.getResource(caminho));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
