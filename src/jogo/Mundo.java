package jogo;

import java.awt.*;
import java.util.Map;

public class Mundo {

    private Jogo game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] lad;

    public Mundo(Jogo game, String caminho){
        carregador(caminho);
        this.game = game;
    }

    public void atualiza() {

    }

    public void render(Graphics g) {

        //renderiza apenas a parte que aparece na tela
        int xStart = (int) Math.max(0, game.getCamera().getxOffset() / Ladrilho.LAD_WIDTH);
        int xEnd = (int) Math.min(width, (game.getCamera().getxOffset() + game.getWidth()) / Ladrilho.LAD_WIDTH + 1);
        int yStart = (int) Math.max(0, game.getCamera().getyOffset() / Ladrilho.LAD_HEIGHT);
        int yEnd = (int) Math.min(height, (game.getCamera().getyOffset() + game.getHeight()) / Ladrilho.LAD_HEIGHT + 1);

        //TEMP
        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart ;x < xEnd; x++){
                getTile(x, y).render(g,
                        (int) (x * Ladrilho.LAD_WIDTH - game.getCamera().getxOffset()),
                        (int) (y * Ladrilho.LAD_HEIGHT - game.getCamera().getyOffset()));
            }
        }
    }

    public Ladrilho getTile(int x, int y){


        Ladrilho t = Ladrilho.titles[lad[x][y]];

        //Ladrilho t = Ladrilho.ladrilho[1];
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

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
}