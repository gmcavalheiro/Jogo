package jogo.Entidades;

import jogo.Utilidades.Handler;

public abstract class EntidadeEstatica extends Entidade{

    public EntidadeEstatica(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
        atacavel = false;
    }

}
