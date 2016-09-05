package jogo;

import java.awt.*;

public class EstadoJogo extends Estado {

    private Jogador player;
    private Mundo mundo;

    public EstadoJogo(Jogo game){
        super(game);
        mundo = new Mundo(game, "res/mundos/mundo1.txt");
        player = new Jogador(game,mundo.getSpawnX(),mundo.getSpawnY());
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
