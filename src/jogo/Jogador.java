package jogo;

import java.awt.*;

public class Jogador extends Criatura {

    private Jogo game;

    public Jogador(Jogo game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void atualiza() {
        if(game.getKeyManager().cima) y -= 3;
        if(game.getKeyManager().baixo) y+= 3;
        if(game.getKeyManager().direita) x-=3;
        if(game.getKeyManager().esquerda)x+=3;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.jogador_f, (int) x, (int) y, null);
    }
}
