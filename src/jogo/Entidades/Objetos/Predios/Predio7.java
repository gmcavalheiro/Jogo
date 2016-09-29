package jogo.Entidades.Objetos.Predios;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Entidades.EntidadeEstatica;
import jogo.Utilidades.Handler;

import java.awt.*;

public class Predio7 extends EntidadeEstatica {

    public Predio7(Handler handler, float x, float y){
        super(handler, (x-1)* Ladrilho.LAD_WIDTH, (y-1)*Ladrilho.LAD_HEIGHT, 128, 192);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 128;
        bounds.height = 192;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.predio7,
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
