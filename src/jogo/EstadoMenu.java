package jogo;

import jogo.Utilidades.Handler;

import java.awt.*;

public class EstadoMenu extends Estado {

    public EstadoMenu(Handler handler){
        super(handler);

    }

    @Override
    public void atualiza() {
        if(handler.getMouseManager().isMouseDireito() && handler.getMouseManager().isMouseEsquerdo()){
            Estado.setEstadoAtual(handler.getGame().estadoJogo);
        }
    }

    @Override
    public void render(Graphics g) {
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 50, 50 );
    }
}
