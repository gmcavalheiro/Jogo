package jogo.Entidades.Objetos.Predios;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Entidades.EntidadeEstatica;
import jogo.Utilidades.Handler;

import java.awt.*;

public class Predio1 extends EntidadeEstatica {

    public Predio1(Handler handler, float x, float y){
        super(handler, (x-1)* Ladrilho.LAD_WIDTH, (y-1)*Ladrilho.LAD_HEIGHT, 960, 128);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 960;
        bounds.height = 128;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.predio1,
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
