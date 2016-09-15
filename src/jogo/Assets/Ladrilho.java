package jogo.Assets;

import jogo.Assets.Ladrilhos.*;
import jogo.Assets.Ladrilhos.Agua.*;
import jogo.Assets.Ladrilhos.Grama.*;
import jogo.Assets.Ladrilhos.Terra.*;
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

    public static Ladrilho bloco_1 = new Bloco_1(30);
    public static Ladrilho bloco_2 = new Bloco_2(31);
    public static Ladrilho bloco_3 = new Bloco_3(32);

    public static Ladrilho terra_ces = new Terra_cse(41);
    public static Ladrilho terra_s = new Terra_s(42);
    public static Ladrilho terra_ced = new Terra_csd(43);
    public static Ladrilho terra_e = new Terra_e(44);
    public static Ladrilho terra = new Terra(40);
    public static Ladrilho terra_d = new Terra_d(45);
    public static Ladrilho terra_cie = new Terra_cie(46);
    public static Ladrilho terra_i = new Terra_i(47);
    public static Ladrilho terra_cid = new Terra_cid(48);
    
    public static Ladrilho tijolo_ces = new Tijolo_cse(51);
    public static Ladrilho tijolo_s = new Tijolo_s(52);
    public static Ladrilho tijolo_ced = new Tijolo_csd(53);
    public static Ladrilho tijolo_e = new Tijolo_e(54);
    public static Ladrilho tijolo = new Tijolo(50);
    public static Ladrilho tijolo_d = new Tijolo_d(55);
    public static Ladrilho tijolo_cie = new Tijolo_cie(56);
    public static Ladrilho tijolo_i = new Tijolo_i(57);
    public static Ladrilho tijolo_cid = new Tijolo_cid(58);

    public static Ladrilho agua_ces = new Agua_cse(61);
    public static Ladrilho agua_s = new Agua_s(62);
    public static Ladrilho agua_ced = new Agua_csd(63);
    public static Ladrilho agua_e = new Agua_e(64);
    public static Ladrilho agua = new Agua(60);
    public static Ladrilho agua_d = new Agua_d(65);
    public static Ladrilho agua_cie = new Agua_cie(66);
    public static Ladrilho agua_i = new Agua_i(67);
    public static Ladrilho agua_cid = new Agua_cid(68);

    



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