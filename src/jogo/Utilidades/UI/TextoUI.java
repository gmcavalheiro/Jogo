package jogo.Utilidades.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextoUI extends ObjetoUI {

    private BufferedImage img;

    public TextoUI(float x, float y, int width, int height, BufferedImage img) {
        super(x, y, width, height);
        this.img = img;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img ,(int)x ,(int)y ,width ,height ,null);
    }

    @Override
    public void onClick() {

    }
}
