package jogo.Entidades;

import jogo.Utilidades.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//player = new Jogador(handler,mundo.getSpawnX(),mundo.getSpawnY());

public class GerenciadorDeEntidades {

    private Handler handler;
    private Jogador player;
    private ArrayList<Entidade> entidades;
    private Comparator<Entidade> orderRender = new Comparator<Entidade>() {
        @Override
        public int compare(Entidade a, Entidade b) {
            //Comparador de entidades, verifica o que tem que ser exibido primeiro
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    public GerenciadorDeEntidades(Handler handler, Jogador player){
        this.handler = handler;
        this.player = player;
        entidades = new ArrayList<Entidade>();
        adicionaEntidade(player);
    }


    public void atualiza() {
        Iterator<Entidade> it = entidades.iterator();
        while (it.hasNext()){
            Entidade e = it.next();
            e.atualiza();
            if(!e.ativo){
                it.remove();
            }
        }
        //ordena o ArrayList de acordo com a coordenada Y de baixo.
        entidades.sort(orderRender);
    }

    public void render(Graphics g) {
        for(Entidade e: entidades){
            e.render(g);
        }
    }

    public int entidadesRestantes(){
        int r = 0;
        for(Entidade e: entidades){
            if(e.npc){
                r++;
            }
        }
        return r;
    }

    public void adicionaEntidade(Entidade e){
        entidades.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Jogador getPlayer() {
        return player;
    }

    public void setPlayer(Jogador player) {
        this.player = player;
    }

    public ArrayList<Entidade> getEntidades() {
        return entidades;
    }

    public void setEntidades(ArrayList<Entidade> entidades) {
        this.entidades = entidades;
    }
}
