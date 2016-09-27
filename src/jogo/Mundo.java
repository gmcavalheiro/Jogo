package jogo;

import jogo.Assets.*;
import jogo.Entidades.Itens.GerenciadorDeItens;
import jogo.Entidades.Itens.Item;
import jogo.Entidades.*;
import jogo.Entidades.Objetos.*;
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
    private GerenciadorDeItens gerenciadorDeItens;

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
        gerenciadorDeItens.atualiza();
        info.atualiza();

        if(getTempoReal() > duracao && duracao != 0){
            gerenciadorDeEntidades.getPlayer().fim("Acabou o Tempo!");
        }

        if(restantes() == 0){
            gerenciadorDeEntidades.getPlayer().fim("Fim de Jogo!");
        }
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
        gerenciadorDeItens.render(g);
        gerenciadorDeEntidades.render(g);

        //Barra de informações
        info.render(g);

        //indicador de pouco tempo
        if(duracao != 0) {
            if (getTempoRestante() < 10 && getTempoRestante() > 5) {
                g.setColor(Color.BLACK);
                g.fillRect(10, 10, 780, 10);
                g.fillRect(10, 550, 780, 10);
                g.fillRect(10, 10, 10, 550);
                g.fillRect(780, 10, 10, 550);
            } else if (getTempoRestante() < 5 && getTempoRestante() > 3) {
                g.setColor(Color.RED);
                g.fillRect(10, 10, 780, 10);
                g.fillRect(10, 550, 780, 10);
                g.fillRect(10, 10, 10, 550);
                g.fillRect(780, 10, 10, 550);
            } else if (getTempoRestante() < 3) {
                g.setColor(Color.RED);
                g.fillRect(10, 10, 780, 20);
                g.fillRect(10, 540, 780, 20);
                g.fillRect(10, 10, 20, 550);
                g.fillRect(770, 10, 20, 550);
            }

            if (getTempoRestante() < 3) {
                g.setColor(Color.BLACK);
                g.drawString("Acabando o tempo!!", 335, 25);
            }
        }


        g.setColor(Color.BLACK);

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

    public GerenciadorDeItens getGerenciadorDeItens() {
        return gerenciadorDeItens;
    }

    public void setGerenciadorDeItens(GerenciadorDeItens gerenciadorDeItens) {
        this.gerenciadorDeItens = gerenciadorDeItens;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
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
        gerenciadorDeItens.limpaArrayItens();
        criaEntidades();
    }

    public void criaEntidades(){
        //Jogador
        gerenciadorDeEntidades = new GerenciadorDeEntidades(handler, new Jogador(handler,100,100));
        //Coloca o jogador na posição inicial
        gerenciadorDeEntidades.getPlayer().setX(spawnX * Ladrilho.LAD_WIDTH);
        gerenciadorDeEntidades.getPlayer().setY(spawnY * Ladrilho.LAD_HEIGHT);

        gerenciadorDeItens = new GerenciadorDeItens(handler);
        itens();
        objetos();
        inimigos();
    }


    public void inimigos(){
        //Instância os inimigos
        gerenciadorDeEntidades.adicionaEntidade(new Inimigo(handler, 9, 11));
        gerenciadorDeEntidades.adicionaEntidade(new Inimigo(handler, 12, 16));

    }

    public void objetos(){
        //Instância as entidades e objetos

        //Arvores
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 2 , 4 ));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 2 , 22));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 37, 5 ));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 34, 6 ));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 29, 11));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 32, 20));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 39, 21));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 37, 28));
        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 33, 10));
        gerenciadorDeEntidades.adicionaEntidade(new ArvoreGrande(handler, 2 , 11));
        gerenciadorDeEntidades.adicionaEntidade(new ArvoreGrande(handler, 29, 4 ));
        gerenciadorDeEntidades.adicionaEntidade(new ArvoreGrande(handler, 38, 8 ));
        gerenciadorDeEntidades.adicionaEntidade(new ArvoreGrande(handler, 36, 23));
        gerenciadorDeEntidades.adicionaEntidade(new ArvoreGrande(handler, 31, 26));

        //Carros
        gerenciadorDeEntidades.adicionaEntidade(new Carro_c1(handler, 6 ,2 ));
        gerenciadorDeEntidades.adicionaEntidade(new Carro_b2(handler, 24,8 ));
        gerenciadorDeEntidades.adicionaEntidade(new Carro_e1(handler, 22,13));
        gerenciadorDeEntidades.adicionaEntidade(new Carro_b1(handler, 4 ,15));
        gerenciadorDeEntidades.adicionaEntidade(new Carro_d2(handler, 17,23));
        gerenciadorDeEntidades.adicionaEntidade(new Carro_c2(handler, 26,24));
    }

    public void itens(){
        //Instancia os itens
        gerenciadorDeItens.adicionaItenm(Item.papel.criarNovo(5,10));
    }

    public int restantes(){
        return gerenciadorDeEntidades.entidadesRestantes() + gerenciadorDeItens.itensRestantes();
    }


}
