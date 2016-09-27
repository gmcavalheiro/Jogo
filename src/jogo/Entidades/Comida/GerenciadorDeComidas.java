package jogo.Entidades.Comida;

import jogo.Entidades.Itens.Item;
import jogo.Utilidades.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public class GerenciadorDeComidas {

    private Handler handler;
    private ArrayList<Comida> comidas;

    public GerenciadorDeComidas(Handler handler){
        this.handler = handler;
        comidas = new ArrayList<Comida>();
    }

    public void atualiza() {
        Iterator<Comida> it = comidas.iterator();
        while (it.hasNext()){
            Comida c = it.next();
            c.atualiza();
            if(c.isPegado()){
                it.remove();
            }
        }
    }

    public void render(Graphics g){
        for(Comida c: comidas){
            c.render(g);
        }
    }

    public void adicionaComida(Comida c){
        c.setHandler(handler);
        comidas.add(c);
    }

    public Handler getHandler() {
        return handler;
    }

    public void limpaArrayComidas(){
        comidas.clear();
    }

    public int comidasRestantes(){
        int r = 0;
        for(Comida i : comidas){
            r++;
        }
        return r;
    }
}
