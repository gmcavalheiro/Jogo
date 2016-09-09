package jogo;

import jogo.Entidades.Entidade;
import jogo.Entidades.Jogador;
import jogo.Utilidades.Handler;

import java.awt.*;
import java.util.ArrayList;

//player = new Jogador(handler,mundo.getSpawnX(),mundo.getSpawnY());

public class GerenciadorDeEntidades {

    private Handler handler;
    private Jogador player;
    private ArrayList<Entidade> entidades;

    public GerenciadorDeEntidades(Handler handler, Jogador player){
        this.handler = handler;
        this.player = player;
        entidades = new ArrayList<Entidade>();
        adicionaEntidade(player);
    }


    public void atualiza() {
        for(int i = 0; i < entidades.size(); i++){
            Entidade e = entidades.get(i);
            e.atualiza();
        }
    }

    public void render(Graphics g) {
        for(Entidade e: entidades){
            e.render(g);
        }
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
