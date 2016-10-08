package jogo.Entidades.Itens;

import jogo.Utilidades.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public class GerenciadorDeItens {

    private Handler handler;
    private ArrayList<Item> itens;

    public GerenciadorDeItens(Handler handler){
        this.handler = handler;
        itens = new ArrayList<Item>();
    }

    public void atualiza() {
        Iterator<Item> it = itens.iterator();
        while (it.hasNext()){
            Item i = it.next();
            i.atualiza();

            //if(handler.getMundo().getGerenciadorDeEntidades().entidadesRestantes() == 0) System.out.println(i.getPosicao() + " " + i.getNome());

            if(i.isPegado()){
                it.remove();
            }
        }
    }

    public void render(Graphics g){
        for(Item i: itens){
            i.render(g);
        }
    }

    public void adicionaItenm(Item i){
        if(itens.size() < 900) {
            i.setHandler(handler);
            itens.add(i);
        }else{
            return;
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void limpaArrayItens(){
        itens.clear();
    }

    public int itensRestantes(){
        int r = 0;
        for(Item i : itens){
            r++;
        }
        return r;
    }
}
