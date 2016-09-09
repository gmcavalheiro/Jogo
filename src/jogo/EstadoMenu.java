package jogo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Utilidades.ClickListener;
import jogo.Utilidades.Handler;
import jogo.Utilidades.UI.BotaoUI;
import jogo.Utilidades.UI.GerenciadorUI;

import java.awt.*;

public class EstadoMenu extends Estado {

    private GerenciadorUI gerenciadorUI;

    public EstadoMenu(Handler handler){
        super(handler);
        gerenciadorUI = new GerenciadorUI(handler);
        handler.getMouseManager().setGerenciadorUI(gerenciadorUI);

        gerenciadorUI.addObjeto(new BotaoUI(200,200, Ladrilho.LAD_WIDTH*2, Ladrilho.LAD_HEIGHT, Assets.btn_inico,
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getMouseManager().setGerenciadorUI(null);
                       Estado.setEstadoAtual(handler.getGame().estadoJogo);
                    }
                }));
    }

    @Override
    public void atualiza() {
        gerenciadorUI.atualiza();
    }

    @Override
    public void render(Graphics g) {
        gerenciadorUI.render(g);
    }
}
