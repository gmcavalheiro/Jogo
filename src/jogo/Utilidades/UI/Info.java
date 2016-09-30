package jogo.Utilidades.UI;



import jogo.Assets.SpriteSheet;
import jogo.Utilidades.Handler;
import jogo.Utilidades.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Info {

    protected Handler handler;
    protected int height, width, y;
    protected int life;
    protected float tempo;

    SpriteSheet infoBarSprite = new SpriteSheet(ImageLoader.loadImage("/texturas/InfoBar.png"));
    private BufferedImage infoBar;


    public Info(Handler handler){
        this.handler = handler;
        width = handler.getWidth();
        height = 30;
        y = handler.getHeight() - height;
        infoBar = infoBarSprite.corta(0,0,800,30);
    }

    public void atualiza() {
        tempo = handler.getMundo().getTempoRestante();

        if(tempo < 0) tempo = tempo * -1;

    }

    public void render(Graphics g) {
        life = handler.getMundo().getGerenciadorDeEntidades().getPlayer().getSaude();
        //g.setColor(new Color(186, 175, 115));
        g.drawImage(infoBar,0,y,width,30, null);
       // g.fillRect(0,y,width,30);
        g.setColor(Color.BLACK);
        g.drawString("Saude: ", 10, y + 20);
        g.drawRect(50,y + 11,201,10);

        if(life < 3){
            g.setColor(new Color(190, 39, 30));
        }else if(life < 5){
            g.setColor(new Color(200, 128, 57));
        }else if(life < 7){
            g.setColor(new Color(200, 186, 70));
        }else {
            g.setColor(new Color(80, 200, 80));
        }
        g.fillRect(51,y+12,life*20,9);

        g.setColor(Color.black);
        g.drawString("Pontos: " + handler.getGame().getPontos(), 260, y+20);
        g.drawString("Kills: " + handler.getGame().getKills(), 340, y+20);
        //g.drawString("Restantes: " + handler.getMundo().restantes(), 390, y+20);


        g.drawString("Restantes: " + handler.getMundo().getGerenciadorDeEntidades().entidadesRestantes() + " | " + handler.getMundo().getGerenciadorDeItens().itensRestantes(), 390, y+20);


        g.drawString("Tempo: "+ (String.format("%.1f", tempo )), 700, y+20);
    }

}
