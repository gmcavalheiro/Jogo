package jogo.Entidades;

import jogo.Utilidades.Handler;

import java.awt.*;

public abstract class Entidade {

    public static final int saude_padrao = 10;

    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected int saude;
    protected boolean ativo = true;
    protected Rectangle bounds;

    public Entidade(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(0,0,width,height);
        saude = saude_padrao;
    }

    public abstract void atualiza();

    public abstract void render(Graphics g);

    public boolean colisaoEntidade(float xOffset, float yOffset){
        for(Entidade e: handler.getMundo().getGerenciadorDeEntidades().getEntidades()){
            if(e.equals(this)) continue;

            if(e.getCBounds(0f,0f).intersects(getCBounds(xOffset,yOffset))){
                return true;
            }
        }
        return false;
    }

    public abstract void morre();

    public void dano(int q){
        saude -= q;
        if(saude <= 0){
            ativo = false;
            morre();
        }
    }

    public Rectangle getCBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x + bounds.x + xOffset),
                (int)(y + bounds.y + yOffset),
                bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
