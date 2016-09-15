package jogo.Utilidades.UI;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class ObjetoUI {

    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean sobre = false;

    public ObjetoUI(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    public abstract void atualiza();

    public abstract void render(Graphics g);

    public abstract void onClick();


    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(), e.getY())){
            sobre = true;

        }else{
            sobre = false;
        }
    }

    public void onMouseRelease(MouseEvent e){
        if(sobre) onClick();
    }

    //Getters & Setters
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

    public boolean isSobre() {
        return sobre;
    }

    public void setSobre(boolean sobre) {
        this.sobre = sobre;
    }
}
