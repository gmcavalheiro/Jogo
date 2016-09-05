package jogo;

import java.awt.*;

public abstract class Estado {

    private static Estado estadoAtual = null;

    public static void setEstadoAtual(Estado estado){
        estadoAtual = estado;
    }

    public static Estado getEstadoAtual(){
        return estadoAtual;
    }

    protected Jogo game;

    public Estado(Jogo game){
        this.game = game;
    }

    //Class
    public abstract void atualiza();

    public abstract void render(Graphics g);
}
