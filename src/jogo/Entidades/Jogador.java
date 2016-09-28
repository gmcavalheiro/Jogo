package jogo.Entidades;

import jogo.Assets.Assets;
import jogo.Estado;
import jogo.Utilidades.Handler;
import jogo.Utilidades.Musica;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Jogador extends Criatura {

    public Estado estadoCreditos;
    //Animação
    private Animacao animBaixo, animCima, animEsquerda, animDireita;
    int animVel = 300;
    private int dano = 1, danoCount = 0;

    private Musica musica = new Musica();

    //Ataque
    private long lastAttk, attkEspera = 500, attkTimer = attkEspera;

    public Jogador(Handler handler, float x, float y) {
        super(handler, x * CP_WIDTH, y * CP_HEIGHT, CP_WIDTH, CP_HEIGHT);

        //define o tamanho do bounding box, para colisão
        bounds.x = 24;
        bounds.y = 32;
        bounds.width = 16;
        bounds.height = 30;

        //Animação
        animBaixo = new Animacao(animVel, Assets.jogador_baixo);
        animCima = new Animacao(animVel, Assets.jogador_cima);
        animDireita = new Animacao(animVel, Assets.jogador_dir);
        animEsquerda = new Animacao(animVel, Assets.jogador_esq);
    }

    @Override
    public void atualiza() {
        //animação
        animBaixo.atualiza();
        animCima.atualiza();
        animDireita.atualiza();
        animEsquerda.atualiza();

        //movimento
        entrada();
        movimento();
        handler.getCamera().centralizar(this);

        //Ataques
        ataques();

        if(saude > 10) {
            saude = 10;
        }

        if(danoCount > 10){
            danoCount = 0;
            dano++;
            musica.wavMusic("/musicas/Birl.wav", -5f, false);
        }


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

        if(handler.getKeyManager().attk || handler.getJoystickManager().attk) {
            if (xMove < 0) { //Esquerda
                ra.x = cb.x - raTamanho;
                ra.y = cb.y  + cb.height /2 - raTamanho/2;
            } else if (xMove > 0) { //Direita
                ra.x = cb.x + cb.width;;
                ra.y = cb.y  + cb.height /2 - raTamanho/2;
            } else if (yMove < 0) { //Cima
                ra.x = cb.x + cb.width/2 - raTamanho/2;
                ra.y = cb.y - raTamanho;
            } else if (yMove > 0) { //Baixo
                ra.x = cb.x + cb.width/2 - raTamanho/2;
                ra.y = cb.y + cb.height;
            }
        }else {
            return;
        }

        attkTimer = 0;

        for(Entidade e: handler.getMundo().getGerenciadorDeEntidades().getEntidades()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCBounds(0,0).intersects(ra) && e.atacavel){
                e.dano(dano);
                musica.wavMusic("/musicas/Soco.wav", -5f, false);
                return;
            }
        }
    }

    private void entrada(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().cima || handler.getJoystickManager().cima) yMove = -velocidade;
        if(handler.getKeyManager().baixo || handler.getJoystickManager().baixo) yMove = velocidade;
        if(handler.getKeyManager().direita || handler.getJoystickManager().direita) xMove = -velocidade;
        if(handler.getKeyManager().esquerda || handler.getJoystickManager().esquerda) xMove = velocidade;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCAFrame(),
                (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()),
                width, height, null);
    }

    @Override
    public void morre() { //Quando o personagem morre
        chamaCreditos("Fim");

    }

    public void fim(String texto) { //Quando acaba o tempo
        chamaCreditos(texto);
    }
    public void chamaCreditos(String texto){
        handler.getMundo().stop();
        handler.getGame().getMusica().paraMusica();
        handler.getGame().getMusica().wavMusic("/musicas/Out.wav", -20.0f, false);


        //JOptionPane.showMessageDialog(null, texto, "APS", JOptionPane.DEFAULT_OPTION);
        //String nome = JOptionPane.showInputDialog(null, "Jogador?", "APS", JOptionPane.DEFAULT_OPTION);
        //handler.getGame().setNome(nome);
        handler.getGame().getMusica().wavMusic("/musicas/creditos1.wav", -20.0f, false);
        handler.getEstado().setEstadoAtual(handler.getGame().estadoCreditos);
    }



    private BufferedImage getCAFrame(){
        if(xMove < 0){
            return animEsquerda.getCFrame();
        }else if(xMove > 0){
            return animDireita.getCFrame();
        }else if(yMove < 0){
            return animCima.getCFrame();
        }else if(yMove > 0){
            return animBaixo.getCFrame();
        }else{
            return Assets.player;
        }
    }

    public void addSaude(int amt){
        saude += amt;
    }

    public void addDanoCount(){
        danoCount++;
    }
}
