package jogo.Entidades.Itens;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Utilidades.Handler;


import java.awt.*;

public class Papel extends Iten {

    public Papel(Handler handler, float x, float y){
        super(handler, x* Ladrilho.LAD_WIDTH, y*Ladrilho.LAD_HEIGHT, Ladrilho.LAD_WIDTH, Ladrilho.LAD_HEIGHT);

        bounds.x = 24;
        bounds.y = 49;
        bounds.width = 15;
        bounds.height = 15;
    }

    @Override
    public void atualiza() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.papel,
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
        try {
            handler.getGame().addPonto();
            //handler.getMundo().getGerenciadorDeEntidades().getPlayer().setSaude(10);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
