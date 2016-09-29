package jogo.Entidades.Objetos.Predios;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Entidades.EntidadeEstatica;
import jogo.Utilidades.Handler;

import java.awt.*;

public class Predio5 extends EntidadeEstatica {

    public Predio5(Handler handler, float x, float y){
        super(handler, (x-1)* Ladrilho.LAD_WIDTH, (y-1)*Ladrilho.LAD_HEIGHT, 320, 192);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 320;
        bounds.height = 192;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.predio5,
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
