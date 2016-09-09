package jogo;

import jogo.Assets.Assets;
import jogo.Utilidades.Handler;
import jogo.Utilidades.KeyManager;
import jogo.Utilidades.Musica;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Jogo implements Runnable{
    private Display display;
    private int width, height;
    public String titulo;

    private boolean executando = false;
    private Thread processo;

    private BufferStrategy bs;
    private Graphics g;

    //estados do programa
    private Estado estadoJogo; //estado de jogo
    private Estado estadoMenu; //estado de menu

    private KeyManager keyManager; //Leitor do teclado
    private Handler handler;
    private Camera camera;
    private Musica musica;


    public Jogo(String titulo, int width, int height){
        this.width = width;
        this.height = height;
        this.titulo = titulo;
        keyManager = new KeyManager();
    }

    public void init (){
        display = new Display(titulo, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        handler = new Handler(this);
        camera = new Camera(handler, 0, 0);


        musica = new Musica();
        musica.wavMusic("res/musicas/TPnTD.wav", -10.0f);


        estadoJogo = new EstadoJogo(handler);
        estadoMenu = new EstadoMenu(handler);
        Estado.setEstadoAtual(estadoJogo);

    }

    private void atualiza(){
        keyManager.atualiza();
       if(Estado.getEstadoAtual() != null){
           Estado.getEstadoAtual().atualiza();
       }
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

        if(Estado.getEstadoAtual() != null){
            Estado.getEstadoAtual().render(g);
        }

        // final desenho
        bs.show();
        g.dispose();
    }

    public void run(){
        init();


        //codigo necessario para manter a consistencia na execução do jogo,
        //assim ele roda na mesma "velocidade" independente do computador.
        int fps = 60; //quantidade de quadros por segundo
        double t_Atualizacao = 1000000000 / fps; //determina quantos milisegundos cada quadro aparece na tela
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //marca o primeiro tempo de execução do jogo


        while (executando){
            now = System.nanoTime(); //marca o tempo que o loop inicia
            delta += (now - lastTime) / t_Atualizacao; //determina quando atualizar a tela
            lastTime = now; // grava o tempo que o loop foi executado pela úlltima vez

            if(delta >=1) { //se delta for maior que 1 esta na hora de atualizar
                atualiza();
                render();
                delta--;
            }
        }

        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public Camera getCamera(){ return camera; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
