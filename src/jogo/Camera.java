package jogo;

import jogo.Assets.*;
import jogo.Entidades.Entidade;
import jogo.Utilidades.Handler;

public class Camera {

    private float xOffset, yOffset;
    private Handler handler;

    public Camera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    //Elimina os espaços brancos fora do mapa
    public void espacoBranco(){
        if(xOffset < 0){
            xOffset = 0;
        }else if( xOffset > handler.getMundo().getWidth() * Ladrilho.LAD_WIDTH - handler.getWidth()){
            xOffset = handler.getMundo().getWidth() * Ladrilho.LAD_WIDTH - handler.getWidth();
        }

        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > handler.getMundo().getHeight()* Ladrilho.LAD_HEIGHT - handler.getHeight()){
            yOffset = handler.getMundo().getHeight()* Ladrilho.LAD_HEIGHT - handler.getHeight();
        }
    }

    //Centraliza o jogo no personagem
    public void centralizar(Entidade e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
        espacoBranco();
    }

    public void movimento(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        espacoBranco();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
