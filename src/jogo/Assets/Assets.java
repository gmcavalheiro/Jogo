package jogo.Assets;

import jogo.Utilidades.ImageLoader;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 64, height = 64;
    private static final int tam = 64;
    public static BufferedImage player;
    public static BufferedImage inimigo_parado;
    //Ladrilhos
    public static BufferedImage terra_cse, terra_s, terra_csd, terra_e, terra, terra_d, terra_cie, terra_i, terra_cid;
    public static BufferedImage grama_cse, grama_s, grama_csd, grama_e, grama, grama_d, grama_cie, grama_i, grama_cid;
    public static BufferedImage agua_cse, agua_s, agua_csd, agua_e, agua, agua_d, agua_cie, agua_i, agua_cid;
    public static BufferedImage tijolo_cse, tijolo_s, tijolo_csd, tijolo_e, tijolo, tijolo_d, tijolo_cie, tijolo_i, tijolo_cid;
    public static BufferedImage asfalto, asfalto_ver, asfalto_hor;
    public static BufferedImage bloco_1, bloco_2, bloco_3;

    //Entidades
    public static BufferedImage arvore, arvore_grande, arbusto, arbusto_grande;
    public static BufferedImage casa;

    //objetos
    public static BufferedImage papel, pizza, garrafa;

    //Personagens
    public static BufferedImage[] jogador_baixo, jogador_cima, jogador_dir, jogador_esq;
    public static BufferedImage[] inimigo_baixo, inimigo_cima, inimigo_dir, inimigo_esq;

    //UI
    public static BufferedImage[] btn_inico, btn_sair;

    public static void init(){
        //Sprites
        SpriteSheet textura = new SpriteSheet(ImageLoader.loadImage("/texturas/texturas.png"));
        SpriteSheet jogador = new SpriteSheet(ImageLoader.loadImage("/texturas/player.png"));
        SpriteSheet folhas = new SpriteSheet(ImageLoader.loadImage("/texturas/arvores.png"));
        SpriteSheet predio = new SpriteSheet(ImageLoader.loadImage("/texturas/predios.png"));
        SpriteSheet botoes = new SpriteSheet(ImageLoader.loadImage("/texturas/botoes.png"));
        SpriteSheet inimigo = new SpriteSheet(ImageLoader.loadImage("/texturas/inimigo.png"));
        SpriteSheet objetos = new SpriteSheet(ImageLoader.loadImage("/texturas/objetos.png"));


        /*  ------ Personagens ------*/
        //Jogador
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

        //Inimigo
        inimigo_baixo = new BufferedImage[2];
        inimigo_cima = new BufferedImage[2];
        inimigo_dir = new BufferedImage[2];
        inimigo_esq = new BufferedImage[2];
        inimigo_parado = inimigo.corta(0,0,width,height);

        //baixo
        inimigo_baixo[0] = inimigo.corta(0,height,width,height);
        inimigo_baixo[1] = inimigo.corta(0,height*2,width,height);
        //cima
        inimigo_cima[0] = inimigo.corta(width,height,width,height);
        inimigo_cima[1] = inimigo.corta(width,height*2,width,height);
        //esquerda
        inimigo_esq[0] = inimigo.corta(width*2,height,width,height);
        inimigo_esq[1] = inimigo.corta(width*2,height*2,width,height);
        //direita
        inimigo_dir[0] = inimigo.corta(width*3,height,width,height);
        inimigo_dir[1] = inimigo.corta(width*3,height*2,width,height);


        /*  ------ texturas ------*/
        grama_cse = textura.corta(0,0,tam,tam);
        grama_s = textura.corta(tam,0,tam,tam);
        grama_csd = textura.corta(tam*2,0,tam,tam);
        grama_e = textura.corta(0,tam,tam,tam);
        grama = textura.corta(tam,tam,tam,tam);
        grama_d = textura.corta(tam*2,tam,tam,tam);
        grama_cie = textura.corta(0,tam*2,tam,tam);
        grama_i = textura.corta(tam,tam*2,tam,tam);
        grama_cid = textura.corta(tam*2,tam*2,tam,tam);

        terra_cse = textura.corta(tam*3,0,tam,tam);
        terra_s = textura.corta(tam*4,0,tam,tam);
        terra_csd = textura.corta(tam*5,0,tam,tam);
        terra_e = textura.corta(tam*3,tam,tam,tam);
        terra = textura.corta(tam*4,tam,tam,tam);
        terra_d = textura.corta(tam*5,tam,tam,tam);
        terra_cie = textura.corta(tam*3,tam*2,tam,tam);
        terra_i = textura.corta(tam*4,tam*2,tam,tam);
        terra_cid = textura.corta(tam*5,tam*2,tam,tam);

        agua_cse = textura.corta(0,tam*3,tam,tam);
        agua_s = textura.corta(tam,tam*3,tam,tam);
        agua_csd = textura.corta(tam*2,tam*3,tam,tam);
        agua_e = textura.corta(0,tam*4,tam,tam);
        agua = textura.corta(tam,tam*4,tam,tam);
        agua_d = textura.corta(tam*2,tam*4,tam,tam);
        agua_cie = textura.corta(0,tam*5,tam,tam);
        agua_i = textura.corta(tam,tam*5,tam,tam);
        agua_cid = textura.corta(tam*5,tam*2,tam,tam);

        tijolo_cse = textura.corta(tam*3,tam*3,tam,tam);
        tijolo_s = textura.corta(tam*4,tam*3,tam,tam);
        tijolo_csd = textura.corta(tam*5,tam*3,tam,tam);
        tijolo_e = textura.corta(tam*3,tam*4,tam,tam);
        tijolo = textura.corta(tam*4,tam*4,tam,tam);
        tijolo_d = textura.corta(tam*5,tam*4,tam,tam);
        tijolo_cie = textura.corta(tam*3,tam*5,tam,tam);
        tijolo_i = textura.corta(tam*4,tam*5,tam,tam);
        tijolo_cid = textura.corta(tam*5,tam*2,tam,tam);

        asfalto = textura.corta(0,tam*6,tam,tam);
        asfalto_hor = textura.corta(tam,tam*6,tam,tam);
        asfalto_ver = textura.corta(tam*2,tam*6,tam,tam);

        bloco_1 = textura.corta(tam*3,tam*6,tam,tam);
        bloco_2 = textura.corta(tam*4,tam*6,tam,tam);
        bloco_3 = textura.corta(tam*5,tam*6,tam,tam);


        /*  ------ Objetos ------*/
        //arvores
        arvore = folhas.corta(0,height,width,height);
        arbusto = folhas.corta(0,0,width,height);
        arbusto_grande = folhas.corta(width,0,width,height);
        arvore_grande = folhas.corta(width*2,0,width*2,height*2);

        //predios
        casa = predio.corta(0,0,width,height);

        //lixo
        papel = objetos.corta(0,0,width,height);
        pizza = objetos.corta(width,0,width,height);
        garrafa = objetos.corta(width*2,0,width,height);


        /*  ------ UI ------*/
        //Botões
        btn_inico = new BufferedImage[2];
        btn_sair = new BufferedImage[2];

        btn_inico[0] = botoes.corta(0,0, width*2, height);
        btn_inico[1] = botoes.corta(width*2, 0, width*2, height);

        btn_sair[0] = botoes.corta(0,height,width*2,height);
        btn_sair[1] = botoes.corta(width*2, height, width*2, height);
    }
}
