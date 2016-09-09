package jogo.Assets;

import jogo.Utilidades.ImageLoader;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 64, height = 64;
    public static BufferedImage player;
    public static BufferedImage grama, asfalto, tijolo, asfalto2, cobblestone, telhado;
    public static BufferedImage arvore, arvore_grande, arbusto, arbusto_grande;
    public static BufferedImage casa;
    public static BufferedImage[] jogador_baixo, jogador_cima, jogador_dir, jogador_esq;

    public static void init(){
        SpriteSheet textura = new SpriteSheet(ImageLoader.loadImage("/texturas/texturas.png"));
        SpriteSheet jogador = new SpriteSheet(ImageLoader.loadImage("/texturas/player.png"));
        SpriteSheet folhas = new SpriteSheet(ImageLoader.loadImage("/texturas/arvores.png"));
        SpriteSheet predio = new SpriteSheet(ImageLoader.loadImage("/texturas/predios.png"));

        jogador_baixo = new BufferedImage[2];
        jogador_cima = new BufferedImage[2];
        jogador_dir = new BufferedImage[2];
        jogador_esq = new BufferedImage[2];
        player = jogador.corta(0,0,width,height);

        //baixo
        jogador_baixo[0] = jogador.corta(0,height,width,height);
        jogador_baixo[1] = jogador.corta(0,height*2,width,height);
        //cima
        jogador_cima[0] = jogador.corta(width,height,width,height);
        jogador_cima[1] = jogador.corta(width,height*2,width,height);
        //esquerda
        jogador_esq[0] = jogador.corta(width*2,height,width,height);
        jogador_esq[1] = jogador.corta(width*2,height*2,width,height);
        //direita
        jogador_dir[0] = jogador.corta(width*3,height,width,height);
        jogador_dir[1] = jogador.corta(width*3,height*2,width,height);

        //texturas
        grama = textura.corta(0,0,width,height);
        asfalto = textura.corta(width,0,width,height);
        tijolo = textura.corta(width*2,0,width,height);
        asfalto2 = textura.corta(width,height,width,height);
        cobblestone = textura.corta(0,height,width,height);
        telhado = textura.corta(width*3,0,width,height);

        //arvores
        arvore = folhas.corta(0,height,width,height);
        arbusto = folhas.corta(0,0,width,height);
        arbusto_grande = folhas.corta(width,0,width,height);
        arvore_grande = folhas.corta(width*2,0,width*2,height*2);

        //predios
        casa = predio.corta(0,0,width,height);
    }
}
