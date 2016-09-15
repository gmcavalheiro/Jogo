package jogo.Utilidades;

import jogo.Camera;
import jogo.Jogo;
import jogo.Mundo;

public class Handler {

    private Jogo game;
    private Mundo mundo;

    public Handler(Jogo game){
        this.game = game;
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){ return game.getMouseManager(); }

    public Camera getCamera(){
        return game.getCamera();
    }


    public Jogo getGame() {
        return game;
    }

    public void setGame(Jogo game) {
        this.game = game;
    }

    public Mundo getMundo() {
        return mundo;
    }

    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }
}