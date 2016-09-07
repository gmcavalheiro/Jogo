package jogo;

import java.awt.*;

public class EstadoJogo extends Estado {

    private Jogador player;
    private Mundo mundo;

    public EstadoJogo(Handler handler){
        super(handler);
        mundo = new Mundo(handler, "res/mundos/mundo1.txt");
        handler.setMundo(mundo);
        player = new Jogador(handler,mundo.getSpawnX(),mundo.getSpawnY());

    }

    @Override
    public void atualiza() {
        mundo.atualiza();
        player.atualiza();

    }

    @Override
    public void render(Graphics g) {
        mundo.render(g);
        player.render(g);
    }
}
