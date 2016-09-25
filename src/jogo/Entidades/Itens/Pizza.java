package jogo.Entidades.Itens;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Utilidades.Handler;

import java.awt.*;

public class Pizza extends Iten {

    public Pizza(Handler handler, float x, float y){
        super(handler, x* Ladrilho.LAD_WIDTH, y*Ladrilho.LAD_HEIGHT, Ladrilho.LAD_WIDTH, Ladrilho.LAD_HEIGHT);

        bounds.x = 20;
        bounds.y = 38;
        bounds.width = 24;
        bounds.height = 26;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.pizza,
                (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()),
                width, height, null);

        /*
        g.setColor(Color.RED);
        g.fillRect((int) (x + bounds.x - handler.getCamera().getxOffset()),
                (int) (y + bounds.y - handler.getCamera().getyOffset()),
                bounds.width, bounds.height);
        */
    }

    @Override
    public void morre() {

    }
}
