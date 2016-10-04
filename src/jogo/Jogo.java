package jogo;

import jogo.Assets.Assets;
import jogo.Utilidades.*;
import jogo.Utilidades.Score.Score;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Jogo implements Runnable{
    private Display display;
    private int width, height;
    public String titulo;
    private int frameW, frameH;

    private int kills = 0, pontos = 0;
    private String nome, texto;

    private boolean executando = false;
    private Thread processo;

    private BufferStrategy bs;
    private Graphics g;

    //estados do programa
    public Estado estadoJogo; //estado de jogo
    public Estado estadoMenu; //estado de menu
    public Estado estadoCreditos;
    public boolean mouseAtivo = true;



    private KeyManager keyManager; //Leitor do teclado
    private MouseManager mouseManager; //Leitor do mouse
    private JoystickManager joystickManager; //Leitor do Joystick
    private Handler handler;
    private Camera camera;
    private Musica musica;
    private Score score;



    public Jogo(String titulo, int width, int height){
        this.width = width;
        this.height = height;
        this.titulo = titulo;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        joystickManager = new JoystickManager();
        score = new Score(handler);
    }

    public void init (){
        display = new Display(titulo, width, height);
        display.getFrame().addKeyListener(keyManager);

        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        frameW = display.getFrame().getContentPane().getWidth();
        frameH = display.getFrame().getContentPane().getHeight();

        Assets.init();
        handler = new Handler(this);
        camera = new Camera(handler, 0, 0);

        //Musica
        musica = new Musica();
        musica.MusicaMenu(); //mudar também em EstadoCredito.java


        estadoJogo = new EstadoJogo(handler);
        estadoMenu = new EstadoMenu(handler);
        estadoCreditos = new EstadoCreditos(handler);
        Estado.setEstadoAtual(estadoMenu);



    }

    private void atualiza(){

        joystickManager.atualiza();
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

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public JoystickManager getJoystickManager(){ return joystickManager; }

    public Camera getCamera(){ return camera; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Score getScore() {
        return score;
    }

    public int getKills() {
        return kills;
    }

    public int getPontos() {
        return pontos;
    }

    public void addPonto(){ pontos++; }

    public void addPonto(int pt){
        pontos += pt;
    }

    public void addKill(){ kills++; }

    public Musica getMusica(){ return musica; }

    public void setMouseAtivo(boolean mouseAtivo) {
        this.mouseAtivo = mouseAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getFrameW() {
        return frameW;
    }

    public int getFrameH() {
        return frameH;
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

    public void zerarPontos(){
        pontos = 0;
        kills = 0;
    }
}
