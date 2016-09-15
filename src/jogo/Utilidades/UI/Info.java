package jogo.Utilidades.UI;



import jogo.Utilidades.Handler;

import java.awt.*;

public class Info {

    protected Handler handler;
    protected int height, width, y;


    public Info(Handler handler){
        this.handler = handler;
        width = handler.getWidth();
        height = 30;
        y = handler.getHeight() - height;
    }

    public void atualiza() {

    }

    public void render(Graphics g) {
        g.setColor(new Color(186, 175, 115));
        g.fillRect(0,y,width,30);
        g.setColor(Color.BLACK);
        g.drawString("Saude: " + handler.getMundo().getGerenciadorDeEntidades().getPlayer().getSaude(), 20, y + 20);
        g.drawString("Pontos: " + handler.getGame().getPontos(), 100, y+20);
        g.drawString("Tempo: "+ (String.format("%.1f", handler.getMundo().getTempoRestante())), 700, y+20);
    }

}
