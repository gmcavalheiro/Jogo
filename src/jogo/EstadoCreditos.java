package jogo;

import jogo.Utilidades.Handler;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class EstadoCreditos extends Estado {


    private int pontos, kills;
    private float tempo;
    private String nome;
    private float h = 0f;
    int hsb;
    Color cor;
    InputStream istream = getClass().getResourceAsStream("/fonts/PressStart.ttf");
    Font font = null;

    public EstadoCreditos(Handler handler){
        super(handler);
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, istream);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        font = font.deriveFont(20f);

    }

    @Override
    public void atualiza() {

        if(h >= 0 && h < 1){
            h += 0.01f;
        }else if( h >=1){
            h = 0;
        }
        hsb = Color.HSBtoRGB(h, 1f, 0.8f);
        cor = new Color(hsb);
        creditos();
   }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        Graphics2D g2 = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(50, 90, Color.white, 50, 130, Color.black);

        g.setColor(cor);
        g.setFont(font);
        //g.drawString("Jogador: " + nome, 50, 90);
        g.drawString("Tempo: " + (String.format("%.1f", tempo)), 50, 100);
        g.drawString("Pontos: " + pontos, 50, 130);
        g.drawString("Kills: " + kills, 50, 160);

        g2.setPaint(gp);
        g2.drawString("teste", 50, 200);


        g.setColor(Color.BLACK);
    }


    private void creditos(){
        if(Estado.getEstadoAtual().equals(this)){

            //Recebe as informações
            pontos = handler.getGame().getPontos();
            kills = handler.getGame().getKills();
            tempo = handler.getMundo().getTempo();
            nome = handler.getGame().getNome();

            if(handler.getKeyManager().espaco || handler.getJoystickManager().start) iniciaMenu();

        }


    }

    private void iniciaMenu(){
        handler.getGame().getMusica().paraMusica(); //Para a musca do Menu
        handler.getGame().getMusica().wavMusic("/musicas/menu.wav", -28.0f, true); //Começa a musicas do Jogo (mudar também em Jogo.java)
        handler.getGame().setMouseAtivo(true);
        handler.getMundo().setComeco();
        handler.getMundo().reset();
        Estado.setEstadoAtual(handler.getGame().estadoMenu);
    }







}
