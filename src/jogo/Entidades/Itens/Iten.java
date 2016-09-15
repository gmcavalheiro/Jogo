package jogo.Entidades.Itens;


import jogo.Entidades.Entidade;
import jogo.Utilidades.Handler;

public abstract class Iten extends Entidade {

    public Iten(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
        saude = 3;
    }

}