package jogo;

import jogo.Utilidades.Handler;

import java.awt.*;

public abstract class Estado {

    private static Estado estadoAtual = null;

    public static void setEstadoAtual(Estado estado){
        estadoAtual = estado;
    }

    public static Estado getEstadoAtual(){
        return estadoAtual;
    }

    protected Handler handler;

    public Estado(Handler handler){
        this.handler = handler;
    }

    //Class
    public abstract void atualiza();

    public abstract void render(Graphics g);
}
