package jogo.Assets;

import jogo.Assets.Ladrilhos.*;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Ladrilho {

    public static Ladrilho[] titles = new Ladrilho[256];
    public static Ladrilho grama = new Grama(0);
    public static Ladrilho asfalto = new Asfalto(1);
    public static Ladrilho tijolo = new Tijolo(2);
    public static Ladrilho asfalto2 = new Asfalto2(3);
    public static Ladrilho cobblestone = new Cobblestone(4);
    public static Ladrilho telhado = new Telhado(5);


    public static final int LAD_WIDTH = 64, LAD_HEIGHT = 64;

    protected BufferedImage textura;
    protected final int id;

    public Ladrilho(BufferedImage textura, int id){
        this.textura = textura;
        this.id = id;

        titles[id] = this;

    }

    public void atualiza() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(textura, x, y, LAD_WIDTH, LAD_HEIGHT, null);
    }

    public boolean solido(){
        return false;
    }


    public int getId(){
        return id;
    }
}
