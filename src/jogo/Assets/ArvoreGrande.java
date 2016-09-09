package jogo.Assets;

import jogo.Entidades.EntidadeEstatica;
import jogo.Utilidades.Handler;

import java.awt.*;

public class ArvoreGrande extends EntidadeEstatica {

    public ArvoreGrande(Handler handler, float x, float y){
        super(handler, x* Ladrilho.LAD_WIDTH, y*Ladrilho.LAD_HEIGHT, Ladrilho.LAD_WIDTH*2, Ladrilho.LAD_HEIGHT*2);

        bounds.x = 55;
        bounds.y = 83;
        bounds.width = 20;
        bounds.height = 30;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.arvore_grande,
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
}
