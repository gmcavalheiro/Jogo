package jogo;

import java.awt.*;

public class Jogador extends Criatura {



    public Jogador(Handler handler, float x, float y) {
        super(handler, x * Criatura.CP_WIDTH, y * Criatura.CP_HEIGHT, Criatura.CP_WIDTH, Criatura.CP_HEIGHT);

        //define o tamanho do bounding box, para colisão
        bounds.x = 24;
        bounds.y = 32;
        bounds.width = 16;
        bounds.height = 30;
    }

    @Override
    public void atualiza() {
        entrada();
        movimento();
        handler.getCamera().centralizar(this);
    }

    private void entrada(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().cima) yMove = -velocidade;
        if(handler.getKeyManager().baixo) yMove = velocidade;
        if(handler.getKeyManager().direita) xMove = -velocidade;
        if(handler.getKeyManager().esquerda) xMove = velocidade;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.jogador_f,
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
