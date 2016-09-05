package jogo;

public abstract class Criatura extends Entidade {

    int tamanho = 64;
    public static final int saude_padrao = 10;
    public static final float velocidade_padrao = 3.0f;
    public static final int CP_WIDTH = 64,
                            CP_HEIGHT = 64;

    protected int saude;
    protected float velocidade;
    protected float xMove, yMove;



    public Criatura(Jogo game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        saude = saude_padrao;
        velocidade = velocidade_padrao;
        xMove = 0;
        yMove = 0;
    }

    public void movimento(){
        x += xMove;
        y += yMove;
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
