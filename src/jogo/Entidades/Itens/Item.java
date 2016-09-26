package jogo.Entidades.Itens;


import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Entidades.Entidade;
import jogo.Utilidades.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    //Handler
    public static Item[] itens = new Item[256];
    public static Item salgadinho = new Item(Assets.salgadinho, "Salgadinho", 0);
    public static Item garrafa = new Item(Assets.garrafa, "Garrafa", 1);
    public static Item lata = new Item(Assets.lata, "Lata", 2);
    public static Item papel = new Item(Assets.papel, "Papel", 3);
    public static Item saco = new Item(Assets.saco, "Saco", 4);
    public static Item sacola = new Item(Assets.sacola, "Sacola", 5);



    //Class

    private int tLixo = 32;
    protected Handler handler;
    protected BufferedImage textura;
    protected String nome;
    protected final int id;
    public static final int pegado =-1;

    protected int x, y, count;


    public Item(BufferedImage textura, String nome, int id){
        this.textura = textura;
        this.nome = nome;
        this.id = id;
        count = 1;

        itens[id] = this;
    }


    public void atualiza() {

    }

    public void render(Graphics g){
        if(handler == null) return;
        render(g, (int) (x - handler.getCamera().getxOffset()),
                (int) (y - handler.getCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(textura, x, y, tLixo, tLixo, null);
    }

    public Item criarNovo(int x, int y){
        Item i = new Item(textura, nome, id);
        i.setPosicao(x * Ladrilho.LAD_WIDTH, y * Ladrilho.LAD_HEIGHT);
        return i;
    }

    public Item dropNovo(int x, int y){
        Item i = new Item(textura, nome, id);
        i.setPosicao(x,y);
        return i;
    }

    public void setPosicao(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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