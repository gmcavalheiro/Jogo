package jogo.Entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import jogo.Assets.Assets;
import jogo.Utilidades.Handler;
import jogo.Utilidades.Musica;


public class Inimigo extends Criatura{
    private Animacao animBaixo, animCima, animEsquerda, animDireita;
    int animVel = 100;
    private Musica musica = new Musica();
    private long lastAttk, attkEspera = 10, attkTimer = attkEspera;
    private long lastMov, movEspera = 200, movTimer = movEspera;
    private long lastEnt, entEspera = 200, entTimer = entEspera;
    private int mov = 0;

    public Inimigo(Handler handler, float x, float y) {
        super(handler, x * CP_WIDTH, y * CP_HEIGHT, CP_WIDTH, CP_HEIGHT);
        velocidade = 20.0f;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 64;
        bounds.height = 64;

        //Animação
        animBaixo = new Animacao(animVel, Assets.inimigo_baixo);
        animCima = new Animacao(animVel, Assets.inimigo_cima);
        animDireita = new Animacao(animVel, Assets.inimigo_dir);
        animEsquerda = new Animacao(animVel, Assets.inimigo_esq);
    }

    private void ataques() {
        attkTimer += System.currentTimeMillis() - lastAttk;
        lastAttk = System.currentTimeMillis();

        if(attkTimer < attkEspera) return;

        Rectangle cb = getCBounds(0,0);
        Rectangle ra = new Rectangle();
        int raTamanho = 20;
        ra.width = raTamanho;
        ra.height = raTamanho;

        if (xMove < 0) { //Esquerda.
            ra.x = cb.x - raTamanho;
            ra.y = cb.y  + cb.height /2 - raTamanho/2;
        } else if (xMove > 0) { //Direita.
            ra.x = cb.x + cb.width;;
            ra.y = cb.y  + cb.height /2 - raTamanho/2;
        } else if (yMove < 0) { //Cima.
            ra.x = cb.x + cb.width/2 - raTamanho/2;
            ra.y = cb.y - raTamanho;
        } else if (yMove > 0) { //Baixo.
            ra.x = cb.x + cb.width/2 - raTamanho/2;
            ra.y = cb.y + cb.height;
        }


        attkTimer = 0;

        for(Entidade e: handler.getMundo().getGerenciadorDeEntidades().getEntidades()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCBounds(0,0).intersects(ra) && e.atacavel){
                e.dano(1);
                musica.wavMusic("res/musicas/Punch.wav", -5f, false);
                return;
            }
        }
    }

    private void entrada(){
        xMove = 0;
        yMove = 0;
        int rnd = rndMovimento();
        int passos = 0;

        movTimer += System.currentTimeMillis() - lastMov;
        lastMov = System.currentTimeMillis();

        if(movTimer < movEspera) return;

        while (passos < 4) {
            switch (rnd) {
                case 0:
                    //System.out.println("Baixo");
                    yMove = velocidade; //baixo
                    mov = 1;
                    break;
                case 1:
                    //System.out.println("cima");
                    yMove = -velocidade; //cima
                    mov = 2;
                    break;
                case 2:
                    //System.out.println("esq.");
                    xMove = velocidade; //esquerda
                    mov = 3;
                    break;
                case 3:
                    //System.out.println("dir.");
                    xMove = -velocidade; //direita
                    mov = 4;
                    break;
            }
            passos++;
        }

        movTimer = 0;

    }

    private int rndMovimento(){
        Random r = new Random();
        return r.nextInt(4);
    }


    @Override
    public void atualiza() {
        //animação
        animBaixo.atualiza();
        animCima.atualiza();
        animDireita.atualiza();
        animEsquerda.atualiza();

        entrada();
        movimento();
        ataques();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCAFrame(),
                (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()),
                width, height, null);
        g.drawString("Vida: " + saude,
                (int) (x - handler.getCamera().getxOffset() + 10),
                (int) (y - handler.getCamera().getyOffset()));

    }

    @Override
    public void morre() {
            handler.getGame().addKill();
    }

    private BufferedImage getCAFrame(){

        switch (mov){
            case 1:
                return animBaixo.getCFrame();
                //break;
            case 2:
                return animCima.getCFrame();
                //break;
            case 4:
                return animEsquerda.getCFrame();
                //break;
            case 3:
                return animDireita.getCFrame();
                //break;
            default:
                return Assets.inimigo_parado;
               // break;
        }

        /*
        if(xMove < 0){
            return animEsquerda.getCFrame();
        }else if(xMove > 0){
            return animDireita.getCFrame();
        }else if(yMove < 0){
            return animCima.getCFrame();
        }else if(yMove > 0){
            return animBaixo.getCFrame();
        }else{
            return Assets.inimigo_parado;
        }
        */
    }


}
