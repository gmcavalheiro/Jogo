package jogo;

import java.awt.*;

public abstract class Entidade {

    protected float x, y;

    public Entidade(float x, float y){
        this.x = x;
        this.y = y;
    }

    public abstract void atualiza();

    public abstract void render(Graphics g);

}
