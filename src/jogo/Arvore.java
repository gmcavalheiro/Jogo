package jogo;

import java.awt.*;

public class Arvore extends EntidadeEstatica{

    public Arvore(Handler handler, float x, float y){
        super(handler, x, y, Ladrilho.LAD_WIDTH, Ladrilho.LAD_HEIGHT);

        bounds.x = 30;
        bounds.y = 40;
        bounds.width = 10;
        bounds.height = 24;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.arvore,
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
