package jogo.Entidades.Objetos.Predios;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Entidades.EntidadeEstatica;
import jogo.Utilidades.Handler;

import java.awt.*;

public class Predio4 extends EntidadeEstatica {

    public Predio4(Handler handler, float x, float y){
        super(handler, (x-1)* Ladrilho.LAD_WIDTH, (y-1)*Ladrilho.LAD_HEIGHT, 256, 192);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 256;
        bounds.height = 192;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.predio4,
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
