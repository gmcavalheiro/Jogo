package jogo.Entidades;

import jogo.Assets.Assets;
import jogo.Utilidades.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Jogador extends Criatura {

    //Animação
    private Animacao animBaixo, animCima, animEsquerda, animDireita;
    int animVel = 300;

    public Jogador(Handler handler, float x, float y) {
        super(handler, x * CP_WIDTH, y * CP_HEIGHT, CP_WIDTH, CP_HEIGHT);

        //define o tamanho do bounding box, para colisão
        bounds.x = 24;
        bounds.y = 32;
        bounds.width = 16;
        bounds.height = 30;

        //Animação
        animBaixo = new Animacao(animVel, Assets.jogador_baixo);
        animCima = new Animacao(animVel, Assets.jogador_cima);
        animDireita = new Animacao(animVel, Assets.jogador_dir);
        animEsquerda = new Animacao(animVel, Assets.jogador_esq);
    }

    @Override
    public void atualiza() {
        //animação
        animBaixo.atualiza();
        animCima.atualiza();
        animDireita.atualiza();
        animEsquerda.atualiza();

        //movimento
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
        g.drawImage(getCAFrame(),
                (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()),
                width, height, null);
    }

    private BufferedImage getCAFrame(){
        if(xMove < 0){
            return animEsquerda.getCFrame();
        }else if(xMove > 0){
            return animDireita.getCFrame();
        }else if(yMove < 0){
            return animCima.getCFrame();
        }else if(yMove > 0){
            return animBaixo.getCFrame();
        }else{
            return Assets.player;
        }
    }
}
