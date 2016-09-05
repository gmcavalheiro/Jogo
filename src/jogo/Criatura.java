package jogo;

public abstract class Criatura extends Entidade {

    protected int saude;

    public Criatura(float x, float y) {
        super(x, y);
        saude = 10;
    }
}
