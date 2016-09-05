package jogo;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 64, height = 64;
    public static BufferedImage grama, asfalto, tijolo;
    public static BufferedImage jogador_f, jogador_c, jogador_d, jogador_e;

    public static void init(){
        SpriteSheet textura = new SpriteSheet(ImageLoader.loadImage("/texturas/texturas.png"));
        SpriteSheet jogador = new SpriteSheet(ImageLoader.loadImage("/texturas/player.png"));

        jogador_f = jogador.corta(0,0,width,height);
        jogador_c = jogador.corta(width,0,width,height);
        jogador_d = jogador.corta(width*2,0,width,height);
        jogador_e = jogador.corta(width*3,0,width,height);

        grama = textura.corta(0,0,width,height);
        asfalto = textura.corta(width,0,width,height);
        tijolo = textura.corta(width*2,0,width,height);
    }
}
