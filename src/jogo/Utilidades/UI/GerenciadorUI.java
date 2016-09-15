package jogo.Utilidades.UI;

import jogo.Utilidades.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GerenciadorUI {

    private Handler handler;
    private ArrayList<ObjetoUI> objetos;

    public GerenciadorUI(Handler handler){
        this.handler = handler;
        objetos = new ArrayList<ObjetoUI>();
    }


    public void atualiza() {
        for(ObjetoUI o: objetos){
            o.atualiza();
        }
    }

    public void render(Graphics g) {
        for(ObjetoUI o: objetos){
            o.render(g);
        }
    }

    public void onMouseMove(MouseEvent e){
        for(ObjetoUI o: objetos){
            o.onMouseMove(e);

        }
    }

    public void onMouseRelease(MouseEvent e){
        for(ObjetoUI o: objetos){
            o.onMouseRelease(e);
        }
    }

    public void addObjeto(ObjetoUI o){
        objetos.add(o);
    }

    public void removeObjeto(ObjetoUI o){
        objetos.remove(0);
    }
}


