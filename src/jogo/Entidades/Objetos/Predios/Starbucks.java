package jogo.Entidades.Objetos.Predios;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Entidades.Comida.Comida;
import jogo.Entidades.EntidadeEstatica;
import jogo.Utilidades.Handler;

import java.awt.*;
import java.util.Random;

public class Starbucks extends EntidadeEstatica {

    private long lastDrop, dropEspera = 5000, dropTimer = dropEspera;
    private int dX, dY;

    public Starbucks(Handler handler, float x, float y){
        super(handler, (x-1)* Ladrilho.LAD_WIDTH, (y-1)*Ladrilho.LAD_HEIGHT, 256, 192);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 256;
        bounds.height = 192;
        dY = ((int) (y-1)*64 + 192);
        dX = ((int) (x-2)*64);
    }

    @Override
    public void atualiza() {
        dropComida();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.starbucks,
                (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()),
                width, height, null);

        /*
        g.setColor(Color.RED);
        g.fillRect((int) (x + bounds.x - handler.getCamera().getxOffset()),
                (int) (y + bounds.y - handler.getCamera().getyOffset()),
                bounds.width, bounds.height);
        */
    }

    @Override
    public void morre() {

    }


    public void dropComida(){
        dropTimer += System.currentTimeMillis() - lastDrop;
        lastDrop = System.currentTimeMillis();

        if(dropTimer < dropEspera) return;
        int iID, prob, somaX, somaY, ddX, ddY;
        Random rnd = new Random();
        prob = rnd.nextInt(10);
        somaX = rnd.nextInt(bounds.width + 128);
        somaY = rnd.nextInt(50);
        ddX = dX + somaX;
        ddY = dY + somaY;
        if(prob != 0) return;

        handler.getMundo().getGerenciadorDeComidas().adicionaComida(Comida.latte.dropNovo(ddX, ddY));

        dropTimer = 0;
    }
}
