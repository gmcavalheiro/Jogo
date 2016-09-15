package jogo.Assets;

import jogo.Assets.Ladrilhos.*;
import jogo.Assets.Ladrilhos.Grama.*;
import jogo.Assets.Ladrilhos.Tijolo.*;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Ladrilho {

    public static Ladrilho[] titles = new Ladrilho[256];
    //public static Ladrilho grama = new Grama(0);

    public static Ladrilho grama_cse = new Grama_cse(11);
    public static Ladrilho grama_s = new Grama_s(12);
    public static Ladrilho grama_csd = new Grama_csd(13);
    public static Ladrilho grama_e = new Grama_e(14);
    public static Ladrilho grama = new Grama(10);
    public static Ladrilho grama_d = new Grama_d(15);
    public static Ladrilho grama_cie = new Grama_cie(16);
    public static Ladrilho grama_i = new Grama_i(17);
    public static Ladrilho grama_cid = new Grama_cid(18);

    public static Ladrilho asfalto = new Asfalto(20);
    public static Ladrilho asfalto_hor = new Asfalto_hor(21);
    public static Ladrilho asfalto_ver = new Asfalto_ver(22);

    public static Ladrilho tijolo_ces = new Tijolo(51);
    public static Ladrilho tijolo_s = new Tijolo(52);
    public static Ladrilho tijolo_ced = new Tijolo(53);
    public static Ladrilho tijolo_e = new Tijolo(54);
    public static Ladrilho tijolo = new Tijolo(50);
    public static Ladrilho tijolo_d = new Tijolo(55);
    public static Ladrilho tijolo_cie = new Tijolo(56);
    public static Ladrilho tijolo_i = new Tijolo(57);
    public static Ladrilho tijolo_cid = new Tijolo(58);

    public static Ladrilho bloco_1 = new Bloco_1(30);
    public static Ladrilho bloco_2 = new Bloco_2(31);
    public static Ladrilho bloco_3 = new Bloco_3(32);



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