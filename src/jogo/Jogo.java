package jogo;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Jogo implements Runnable{
    private Display display;
    public int width, height;
    public String titulo;

    private boolean executando = false;
    private Thread processo;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testeI;


    public Jogo(String titulo, int width, int height){
        this.width = width;
        this.height = height;
        this.titulo = titulo;
    }

    public void init (){
        display = new Display(titulo, width, height);
        testeI = ImageLoader.loadImage("/texturas/teste.png");
    }

    private void atualiza(){

    }

    private void render(){
       bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0,width,height); //limpa a tela
        // começo desenho

        g.drawImage(testeI,50,80,null);

        // final desenho
        bs.show();
        g.dispose();
    }

    public void run(){
        init();
        while (executando){
            atualiza();
            render();
        }
        stop();
    }

    public synchronized void start(){
        if(executando){
            return;
        }
        executando = true;
        processo = new Thread(this);
        processo.start();
    }

    public synchronized void stop(){
        if(!executando){
            return;
        }
        executando = false;
        try {
            processo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
