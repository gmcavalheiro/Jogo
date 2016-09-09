package jogo;

import jogo.Utilidades.Handler;

import java.awt.*;

public class EstadoJogo extends Estado {

    private Mundo mundo;

    public EstadoJogo(Handler handler){
        super(handler);
        mundo = new Mundo(handler, "res/mundos/mundo1.txt");
        handler.setMundo(mundo);

    }

    @Override
    public void atualiza() {
        mundo.atualiza();
   }

    @Override
    public void render(Graphics g) {
        mundo.render(g);
    }
}
