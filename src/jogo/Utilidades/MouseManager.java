package jogo.Utilidades;

import jogo.Utilidades.UI.GerenciadorUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{

    private boolean mouseEsquerdo, mouseDireito;
    private int mouseX, mouseY;
    private GerenciadorUI gerenciadorUI;

    public MouseManager(){

    }

    public void setGerenciadorUI(GerenciadorUI gerenciadorUI){
        this.gerenciadorUI = gerenciadorUI;
    }

    //Getters


    public boolean isMouseEsquerdo() {
        return mouseEsquerdo;
    }

    public boolean isMouseDireito() {
        return mouseDireito;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    //
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            mouseEsquerdo = true;
        }else if(e.getButton() == MouseEvent.BUTTON3){
            mouseDireito = true;
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            mouseEsquerdo = false;
        }else if(e.getButton() == MouseEvent.BUTTON3){
            mouseDireito = false;
        }

        if(gerenciadorUI != null){
            gerenciadorUI.onMouseRelease(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(gerenciadorUI != null){
            gerenciadorUI.onMouseMove(e);
        }
    }
}
