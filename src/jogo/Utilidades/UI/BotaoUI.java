package jogo.Utilidades.UI;

import jogo.Utilidades.ClickListener;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BotaoUI extends ObjetoUI {

    private BufferedImage[] img;
    private ClickListener click;

    public BotaoUI(float x, float y, int width, int height, BufferedImage[] img, ClickListener click) {
        super(x, y, width, height);
        this.img = img;
        this.click = click;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        if(sobre){
            g.drawImage(img[1], (int) x, (int) y, width, height, null);
        }else{
            g.drawImage(img[0], (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        click.onClick();
    }
}
