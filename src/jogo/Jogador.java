package jogo;

import java.awt.*;

public class Jogador extends Criatura {



    public Jogador(Jogo game, float x, float y) {
        super(game, x * Criatura.CP_WIDTH, y * Criatura.CP_HEIGHT, Criatura.CP_WIDTH, Criatura.CP_HEIGHT);
    }

    @Override
    public void atualiza() {
        entrada();
        movimento();
    }

    private void entrada(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().cima) yMove = -velocidade;
        if(game.getKeyManager().baixo) yMove = velocidade;
        if(game.getKeyManager().direita) xMove = -velocidade;
        if(game.getKeyManager().esquerda) xMove = velocidade;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.jogador_f, (int) x, (int) y, width, height, null);
    }
}
