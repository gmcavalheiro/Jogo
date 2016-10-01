package jogo.Utilidades.UI;



import jogo.Assets.SpriteSheet;
import jogo.Utilidades.Handler;
import jogo.Utilidades.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Info {

    protected Handler handler;
    protected int height, width, y;
    protected int saudeMax, saude;
    protected float tempo;
    protected float life;

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
        saude = handler.getMundo().getGerenciadorDeEntidades().getPlayer().getSaude();
        saudeMax = handler.getMundo().getGerenciadorDeEntidades().getPlayer().saudeMax;

        //converte a saude para porcentagem
        life = (((float)saude/(float)saudeMax) * 100);

//        System.out.println(life + ", " + saude + ", " + saudeMax);

        //g.setColor(new Color(186, 175, 115));
        g.drawImage(infoBar,0,y,width,30, null);
       // g.fillRect(0,y,width,30);
        g.setColor(Color.BLACK);
        g.drawString("Saude: ", 10, y + 20);
        g.drawRect(50,y + 11,201,10);

        //determina a cor da barra de saude
        if(life < 30.0){
            g.setColor(new Color(190, 39, 30));
        }else if(life < 50.0){
            g.setColor(new Color(200, 128, 57));
        }else if(life < 70.0){
            g.setColor(new Color(200, 186, 70));
        }else {
            g.setColor(new Color(80, 200, 80));
        }
        g.fillRect(51,y+12,(int)life*2,9);

        g.setColor(Color.black);
        g.drawString("Level: " + handler.getMundo().getGerenciadorDeEntidades().getPlayer().getLevel(), 260, y+20);
        g.drawString("Pontos: " + handler.getGame().getPontos(), 320, y+20);
        g.drawString("Kills: " + handler.getGame().getKills(), 400, y+20);
        //g.drawString("Restantes: " + handler.getMundo().restantes(), 390, y+20);


        g.drawString("Restantes: " + handler.getMundo().getGerenciadorDeEntidades().entidadesRestantes() + " | " + handler.getMundo().getGerenciadorDeItens().itensRestantes(), 450, y+20);


        g.drawString("Tempo: "+ (String.format("%.1f", tempo )), 700, y+20);
    }

}
