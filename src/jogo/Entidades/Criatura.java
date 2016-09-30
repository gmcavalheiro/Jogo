package jogo.Entidades;

import jogo.Assets.*;
import jogo.Utilidades.Handler;

public abstract class Criatura extends Entidade {

    int tamanho = 64;

    public static final float velocidade_padrao = 3.0f;
    public static final int CP_WIDTH = 64,
                            CP_HEIGHT = 64;


    protected float velocidade;
    protected float xMove, yMove;



    public Criatura(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        saude = saude_padrao;
        velocidade = velocidade_padrao;
        xMove = 0;
        yMove = 0;
    }

    public void movimento(){
        if(!colisaoEntidade(xMove, 0f)){
            movX();

        }
        if(!colisaoEntidade(0f, yMove)){
            movY();

        }

        //System.out.println("C: " + x + ", " + y);
    }

    public void movX(){//Movimenta e Colisão horizontal

        if(xMove > 0){//Direita
            int tx = (int) (x + xMove + bounds.x + bounds.width)/ Ladrilho.LAD_WIDTH;
            if(!colisao(tx,(int) (y + bounds.y)/ Ladrilho.LAD_HEIGHT) &&
                    !colisao(tx, (int) (y + bounds.y + bounds.height)/ Ladrilho.LAD_HEIGHT)){
                x += xMove;
            }else{
                x = tx * Ladrilho.LAD_WIDTH - bounds.x - bounds.width -1;
            }

        }else  if(xMove < 0){//Esquerda
            int tx = (int) (x + xMove + bounds.x)/ Ladrilho.LAD_WIDTH;
            if(!colisao(tx,(int) (y + bounds.y)/ Ladrilho.LAD_HEIGHT) &&
                    !colisao(tx, (int) (y + bounds.y + bounds.height)/ Ladrilho.LAD_HEIGHT)){
                x += xMove;
            }else{
                x = tx * Ladrilho.LAD_WIDTH + Ladrilho.LAD_WIDTH - bounds.x;
            }

        }
    }

    public void movY(){//Movimenta e Colisão vertical
        if(yMove < 0){//Cima
            int ty = (int) (y + yMove + bounds.y)/ Ladrilho.LAD_HEIGHT;
            if(!colisao((int)(x + bounds.x)/ Ladrilho.LAD_WIDTH, ty) &&
                    !colisao((int)(x + bounds.x + bounds.width)/ Ladrilho.LAD_WIDTH, ty)){
                y += yMove;
            }else{
                y = ty * Ladrilho.LAD_HEIGHT + Ladrilho.LAD_HEIGHT - bounds.y;
            }

        }else if(yMove > 0){//Baixo
            int ty = (int) (y + yMove + bounds.y + bounds.height)/ Ladrilho.LAD_HEIGHT;
            if(!colisao((int)(x + bounds.x)/ Ladrilho.LAD_WIDTH, ty) &&
                    !colisao((int)(x + bounds.x + bounds.width)/ Ladrilho.LAD_WIDTH, ty)){
                y += yMove;
            }else{
                y = ty * Ladrilho.LAD_HEIGHT - bounds.y - bounds.height -1;
            }

        }
    }

    protected boolean colisao(int x, int y){
        return handler.getMundo().getTile(x,y).solido();

    }


    //Getters & Setters
    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
