package jogo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Utilidades.ClickListener;
import jogo.Utilidades.Handler;
import jogo.Utilidades.UI.BotaoUI;
import jogo.Utilidades.UI.GerenciadorUI;

import java.awt.*;

public class EstadoFim extends Estado {

    private GerenciadorUI gerenciadorUI;

    public EstadoFim(Handler handler){
        super(handler);
        gerenciadorUI = new GerenciadorUI(handler);
        handler.getMouseManager().setGerenciadorUI(gerenciadorUI);

        gerenciadorUI.addObjeto(new BotaoUI(
                200, 200, //Posição
                Ladrilho.LAD_WIDTH*2, //Largura
                Ladrilho.LAD_HEIGHT, //Comprimento
                Assets.btn_inico,  //Imagem
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getMouseManager().setGerenciadorUI(null);
                       Estado.setEstadoAtual(handler.getGame().estadoJogo);
                    }
                }));

        gerenciadorUI.addObjeto(new BotaoUI(
                200, 300,
                Ladrilho.LAD_WIDTH * 2,
                Ladrilho.LAD_HEIGHT,
                Assets.btn_sair,
                new ClickListener() {
                    @Override
                    public void onClick() {
                        System.exit(0);
                    }
                }
        ));
    }

    @Override
    public void atualiza() {
        gerenciadorUI.atualiza();
    }

    @Override
    public void render(Graphics g) {
        gerenciadorUI.render(g);
        g.drawString("Fim", 50,60);

    }
}