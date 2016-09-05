package jogo;

import java.awt.*;

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

        //TEMP
        for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
                getTile(x, y).render(g, x * Ladrilho.LAD_WIDTH, y * Ladrilho.LAD_HEIGHT);

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

        System.out.println(spawnX);
        System.out.println(spawnY);


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
