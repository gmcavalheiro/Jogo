package jogo;

import jogo.Assets.*;
import jogo.Assets.Objetos.Arvore;
import jogo.Assets.Objetos.ArvoreGrande;
import jogo.Entidades.*;
import jogo.Utilidades.*;

import java.awt.*;

public class Mundo {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] lad;

    //Entidades
    private GerenciadorDeEntidades gerenciadorDeEntidades;

    public Mundo(Handler handler, String caminho){
        carregador(caminho);
        gerenciadorDeEntidades = new GerenciadorDeEntidades(handler, new Jogador(handler,100,100));

        this.handler = handler;

        gerenciadorDeEntidades.getPlayer().setX(spawnX * Ladrilho.LAD_WIDTH);
        gerenciadorDeEntidades.getPlayer().setY(spawnY * Ladrilho.LAD_HEIGHT);

        gerenciadorDeEntidades.adicionaEntidade(new Arvore(handler, 2, 2));
        gerenciadorDeEntidades.adicionaEntidade(new ArvoreGrande(handler, 5, 6));

    }

    public void atualiza() {
        gerenciadorDeEntidades.atualiza();
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
    }

    public Ladrilho getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Ladrilho.grama;
        }

        Ladrilho t = Ladrilho.titles[lad[x][y]];
        if (t == null){
            return Ladrilho.asfalto;
        }
            return t;

    }

    private void carregador(String caminho){
        String arquivo = Utilidades.loadFile(caminho);
        String[] tokens = arquivo.split("\\s+");
        width = Utilidades.parseInt(tokens[0]);
        height = Utilidades.parseInt(tokens[1]);
        spawnX = Utilidades.parseInt(tokens[2]);
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
}
