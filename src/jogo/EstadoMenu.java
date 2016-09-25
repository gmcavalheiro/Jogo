package jogo;

import jogo.Assets.Assets;
import jogo.Utilidades.Handler;
import jogo.Utilidades.UI.GerenciadorUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

public class EstadoMenu extends Estado {

    private GerenciadorUI gerenciadorUI;

    private int[] opcoesLista = {0,1,2}; //opções do jogo.
    private int opcaoSelecionada = 0;
    private String op1, op2, op0;
    private boolean cima, baixo;
    private boolean[] joy, apertado, nao;
    private float h = 0f;
    int hsb;
    Color cor;
    public boolean trava = true;

    InputStream istream = getClass().getResourceAsStream("/fonts/PressStart.ttf");
    Font font = null;



    public EstadoMenu(Handler handler){
        super(handler);
        trava = true;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, istream);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        font = font.deriveFont(20f);


        joy = new boolean[2];
        nao = new boolean[joy.length];
        apertado = new boolean[joy.length];
        gerenciadorUI = new GerenciadorUI(handler);
        handler.getMouseManager().setGerenciadorUI(gerenciadorUI);




    }

    @Override
    public void atualiza() {
        gerenciadorUI.atualiza();
        menu();
        opcoesMenu();

        if(h >= 0 && h < 1){
            h += 0.01f;
        }else if( h >=1){
            h = 0;
        }
        hsb = Color.HSBtoRGB(h, 1f, 0.8f);
        cor = new Color(hsb);

    }

    @Override
    public void render(Graphics g) {
        gerenciadorUI.render(g);
        g.drawImage(Assets.menuFundo,0,0,null);
        g.setFont(font);
        //g.setColor(cor);
        //g.drawString("Titulo!", 200, 30);

        int x, y;
        x = 210;
        y = 480;
        g.setColor(Color.GRAY);
        g.fillRect(x-10, y-30, 380, 100);


        g.setColor(Color.BLACK);
        g.drawString("[" + op0 + "] Contra o Tempo", x, y);
        g.drawString("[" + op1 + "] Jogo Infinito", x, y+30);
        g.drawString("[" + op2 + "] Sair", x, y+60);



    }

    private void iniciaJogo(){
        if(trava) return;

        handler.getGame().getMusica().paraMusica(); //Para a musca do Menu
        handler.getGame().getMusica().wavMusic("/musicas/jogo1.wav", -30.0f, true); //Começa a musicas do Jogo
        handler.getGame().setMouseAtivo(false);
        handler.getMundo().setComeco();
        trava = true;
        Estado.setEstadoAtual(handler.getGame().estadoJogo);
    }

    private void menu(){
        if(Estado.getEstadoAtual().equals(this)){
            //Inicia o Jogo com Start e espaço
            //if(handler.getJoystickManager().start || handler.getKeyManager().espaco) iniciaJogo();

        }
    }

    public void opcoesMenu(){

        joystick();

        for(int i = 0; i < joy.length; i++){
            if(nao[i] && !joy[i]){
                nao[i] = false;
            }else if(apertado[i]){
                nao[i] = true;
                apertado[i] = false;
            }
            if(!nao[i] && joy[i]){
                apertado[i] = true;
            }
        }

        //if(validaJoy(0)) System.out.println("Baixo");

        if(opcaoSelecionada > 2) opcaoSelecionada = 0;
        if(opcaoSelecionada < 0) opcaoSelecionada = 2;

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S) || validaJoy(0)) {
            opcaoSelecionada++; //desce
            trava = false;
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W) || validaJoy(1)) {
            opcaoSelecionada--;//sobe
            trava = false;
        }

        switch (opcaoSelecionada){
            case 0: //Jogo com tempo
                op0 = ">";
                op1 = op2 = " ";
                if(handler.getJoystickManager().start || handler.getKeyManager().espaco){
                    handler.getMundo().setDuracao(3);
                    iniciaJogo();
                }
                break;
            case 1: //Jogo normal
                op1 = ">";
                op0 = op2 = " ";
                if(handler.getJoystickManager().start || handler.getKeyManager().espaco){
                    handler.getMundo().setDuracao(0);
                    iniciaJogo();
                }
                break;
            case 2: //Jogo Sair
                op2 = ">";
                op1 = op0 = " ";
                if(handler.getJoystickManager().start || handler.getKeyManager().espaco){
                    handler.getKeyManager().sair();
                }
                break;

        }
    }

    public void joystick(){
        if(handler.getJoystickManager().getYDpad() == 1 || handler.getJoystickManager().getYJoystick() == 1){
            joy[0] = true;
        }else if(handler.getJoystickManager().getYDpad() == -1 || handler.getJoystickManager().getYJoystick() == -1){
            joy[1] = true;
        }else{
            joy[0] = joy[1] = false;
        }

        /*
        0 = baixo
        1 = cima
         */
    }


    public boolean validaJoy(int keyCode){
        if(keyCode < 0 || keyCode >= joy.length)
            return false;
        return apertado[keyCode];
    }

}

