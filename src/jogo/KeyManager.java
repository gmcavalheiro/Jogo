package jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

    private boolean[] teclas;
    public boolean cima, baixo, direita, esquerda;

    public KeyManager(){
        teclas = new boolean[256];
    }

    public void atualiza(){
        cima = teclas[KeyEvent.VK_W];
        baixo = teclas[KeyEvent.VK_S];
        direita = teclas[KeyEvent.VK_A];
        esquerda = teclas[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }
}
