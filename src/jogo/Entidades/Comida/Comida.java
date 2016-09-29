package jogo.Entidades.Comida;


import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Utilidades.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Comida {

    //Handler
    public static Comida[] comidas = new Comida[256];
    public static Comida bigbill = new Comida(Assets.bigbill, "BigBill", 0, 3);
    public static Comida pizza = new Comida(Assets.pizza, "Pizza", 1, 1);
    public static Comida turkeyleg = new Comida(Assets.turkeyleg, "Pizza", 2, 2);
    public static Comida dogao = new Comida(Assets.dogao, "Dogão", 3, 2);
    public static Comida latte = new Comida(Assets.latte, "Latte", 4, 1);
    public static Comida pasta = new Comida(Assets.pasta, "Pasta", 5, 10);




    //Class

    private int tLixo = 32;
    protected Handler handler;
    protected BufferedImage textura;
    protected String nome;
    protected final int id;
    protected boolean pegado = false;

    protected Rectangle bounds;

    protected int x, y, hp;


    public Comida(BufferedImage textura, String nome, int id, int hp){
        this.textura = textura;
        this.nome = nome;
        this.id = id;
        this.hp = hp;

        bounds = new Rectangle(x, y, tLixo, tLixo);

        comidas[id] = this;
    }


    public void atualiza() {
        if(handler.getMundo().getGerenciadorDeEntidades().getPlayer().getCBounds(0f,0f).intersects(bounds)){
            pegado = true;
            handler.getGame().addPonto(hp);
            handler.getMundo().getGerenciadorDeEntidades().getPlayer().addSaude(hp);
            handler.getMundo().getGerenciadorDeEntidades().getPlayer().addDanoCount();
            handler.getGame().getMusica().ComeSound();
        }

    }

    public void render(Graphics g){
        if(handler == null) return;
        render(g, (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(textura, x, y, tLixo, tLixo, null);
    }

    public Comida criarNovo(int x, int y){
        Comida c = new Comida(textura, nome, id, hp);
        c.setPosicao(x * Ladrilho.LAD_WIDTH, y * Ladrilho.LAD_HEIGHT);
        return c;
    }

    public Comida dropNovo(int x, int y){
        Comida c = new Comida(textura, nome, id, hp);
        c.setPosicao(x,y);
        return c;
    }

    public void setPosicao(int x, int y){
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }


    public boolean isPegado() {
        return pegado;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTextura() {
        return textura;
    }

    public void setTextura(BufferedImage textura) {
        this.textura = textura;
    }
}