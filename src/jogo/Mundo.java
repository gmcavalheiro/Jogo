package jogo;

import jogo.Assets.*;
import jogo.Entidades.Objetos.Arvore;
import jogo.Entidades.Objetos.ArvoreGrande;
import jogo.Entidades.*;
import jogo.Entidades.Itens.Papel;
import jogo.Utilidades.*;
import jogo.Utilidades.UI.Info;

import java.awt.*;

public class Mundo {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] lad;
    private long startTimer, stopTimer;
    private float tempoReal;
    private long duracao = 10;
    private Info info;

    //Entidades
    private GerenciadorDeEntidades gerenciadorDeEntidades;

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    public Mundo(Handler handler, String caminho){
        carregador(caminho);

        info = new Info(handler);
        this.handler = handler;



        criaEntidades();




        start();
    }

    public void atualiza() {
        gerenciadorDeEntidades.atualiza();
        info.atualiza();

        if(getTempoReal() > duracao && duracao != 0){
            gerenciadorDeEntidades.getPlayer().fim("Acabou o Tempo!");
        }

        if(gerenciadorDeEntidades.entidadesRestantes() == 0){
            gerenciadorDeEntidades.getPlayer().fim("Fim de Jogo!");
        }

        //indicador de pouco tempo





    }

    public void render(Graphics g) {

        //renderiza apenas a parte que aparece na tela
        int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Ladrilho.LAD_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Ladrilho.LAD_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Ladrilho.LAD_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Ladrilho.LAD_HEIGHT + 1);

        //TEMP
        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart ;x < xEnd; x++){
                getTile(x, y).render(g,
                        (int) (x * Ladrilho.LAD_WIDTH - handler.getCamera().getxOffset()),
                        (int) (y * Ladrilho.LAD_HEIGHT - handler.getCamera().getyOffset()));
            }
        }

        //Entidades
        gerenciadorDeEntidades.render(g);

        //Barra de informações
        info.render(g);

    }

    public Ladrilho getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Ladrilho.grama;
        }

        Ladrilho t = Ladrilho.titles[lad[x][y]];
        if (t == null){
            return Ladrilho.grama;
        }
            return t;

    }


    //Carrega o Mapa
    private void carregador(String caminho){
        String arquivo = Utilidades.loadFile(caminho);
        String[] tokens = arquivo.split("\\s+");
        width = Utilidades.parseInt(tokens[0]); //Tamanho
        height = Utilidades.parseInt(tokens[1]);
        spawnX = Utilidades.parseInt(tokens[2]); //Spawn Jogador
        spawnY = Utilidades.parseInt(tokens[3]);

        lad = new int[width][height];
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                lad[x][y] = Utilidades.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GerenciadorDeEntidades getGerenciadorDeEntidades() {
        return gerenciadorDeEntidades;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void start(){
        startTimer = System.currentTimeMillis();
    }

    public void stop(){
        stopTimer = System.currentTimeMillis();
    }

    public float getTempo(){
        return (stopTimer - startTimer)/1000.0f;
    }

    public float getTempoReal(){
        tempoReal = (System.currentTimeMillis() - startTimer)/1000.0f;
        return  tempoReal;
    }

    public float getTempoRestante(){
        return duracao - getTempoReal();
    }

    public void setComeco(){
        tempoReal = 0;
        startTimer = System.currentTimeMillis();
    }

    public void reset(){
        gerenciadorDeEntidades.limpaArrayEntidades();
        criaEntidades();

    }

    public void criaEntidades(){
        //Jogador
        gerenciadorDeEntidades = new GerenciadorDeEntidades(handler, new Jogador(handler,100,100));
        gerenciadorDeEntidades.getPlayer().setX(spawnX * Ladrilho.LAD_WIDTH);
        gerenciadorDeEntidades.getPlayer().setY(spawnY * Ladrilho.LAD_HEIGHT);

        objetos();

        inimigos();

    }


    public void inimigos(){
        //Instância os inimigos
        gerenciadorDeEntidades.adicionaEntidade(new Inimigo(handler, 9, 11));
        gerenciadorDeEntidades.adicionaEntidade(new Inimigo(handler, 12, 16));

    }

    public void objetos(){
        //Instância entidades e objetos
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 2, 2));
        gerenciadorDeEntidades.adicionaEntidade(new ArvoreGrande(handler, 5, 10));
        gerenciadorDeEntidades.adicionaEntidade(new Papel(handler, 3, 8));
    }

}
