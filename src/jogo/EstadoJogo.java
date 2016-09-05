package jogo;

import java.awt.*;

public class EstadoJogo extends Estado {

    private Jogador player;

    public EstadoJogo(Jogo game){
        super(game);
        player = new Jogador(game,100,100);
    }

    @Override
    public void atualiza() {
        player.atualiza();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.asfalto,150,200,null);
        player.render(g);
    }
}
