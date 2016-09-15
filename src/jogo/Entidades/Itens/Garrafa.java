package jogo.Entidades.Itens;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Entidades.EntidadeEstatica;
import jogo.Utilidades.Handler;

import java.awt.*;

public class Garrafa extends Iten {

    public Garrafa(Handler handler, float x, float y){
        super(handler, x* Ladrilho.LAD_WIDTH, y*Ladrilho.LAD_HEIGHT, Ladrilho.LAD_WIDTH, Ladrilho.LAD_HEIGHT);

        bounds.x = 23;
        bounds.y = 49;
        bounds.width = 21;
        bounds.height = 16;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.garrafa,
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
