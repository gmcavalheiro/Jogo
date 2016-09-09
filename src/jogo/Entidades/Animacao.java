package jogo.Entidades;

import java.awt.image.BufferedImage;

public class Animacao {

    private int velocidade, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animacao(int velocidade, BufferedImage[] frames){
        this.velocidade = velocidade;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void atualiza() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > velocidade){
            index++;
            timer = 0;
            if(index >= frames.length){
                index = 0;
            }
        }
    }

    public BufferedImage getCFrame(){
        return frames[index];
    }
}
