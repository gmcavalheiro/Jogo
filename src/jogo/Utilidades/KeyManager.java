package jogo.Utilidades;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

    private boolean[] teclas, apertado, nao;
    public boolean cima, baixo, direita, esquerda;
    public boolean attk, exit, espaco;

    public KeyManager(){
        teclas = new boolean[256];
        apertado = new boolean[teclas.length];
        nao = new boolean[teclas.length];
    }

    public void atualiza(){
        for(int i = 0; i < teclas.length; i++){
            if(nao[i] && !teclas[i]){
                nao[i] = false;
            }else if(apertado[i]){
                nao[i] = true;
                apertado[i] = false;
            }
            if(!nao[i] && teclas[i]){
                apertado[i] = true;
            }
        }

        if(keyJustPressed(KeyEvent.VK_D)) System.out.println("AE");

        cima = teclas[KeyEvent.VK_W];
        baixo = teclas[KeyEvent.VK_S];
        direita = teclas[KeyEvent.VK_A];
        esquerda = teclas[KeyEvent.VK_D];

        attk = teclas[KeyEvent.VK_P];
        exit = teclas[KeyEvent.VK_ESCAPE];
        espaco = teclas[KeyEvent.VK_SPACE];


        if(exit) sair();


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= teclas.length) return;
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= teclas.length) return;
        teclas[e.getKeyCode()] = false;
    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= teclas.length)
            return false;
        return apertado[keyCode];
    }

    public void sair(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Sair?","APS",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
