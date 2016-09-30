package jogo;

import jogo.Utilidades.Handler;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class EstadoCreditos extends Estado {


    private int pontos, kills;
    private float tempo;
    private String nome = "", textoTempo, textoPontuacao;
    private float h = 0f;
    int hsb;
    Color cor;
    InputStream istream = getClass().getResourceAsStream("/fonts/PressStart.ttf");
    Font font = null;
    Font font_maior, font_menor, font_texto;
    int w, x;

    public EstadoCreditos(Handler handler){
        super(handler);
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, istream);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        font_menor = font.deriveFont(17f);
        font_maior = font.deriveFont(45f);
        font_texto = font.deriveFont(10f);

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

        g.setColor(cor); //texto Colorido
        g.setFont(font_maior); //Fonte maior
        w = g.getFontMetrics().stringWidth(nome); //Determina o tamanho do texto em pixels
        x = (handler.getGame().getFrameW() - w)/2; //calcula a posição do texto
        g.drawString(nome, x, 60); //Imprime o texto

        //Exibe os pontos
        g.setFont(font_menor);
        textoPontuacao = "Pontos: " + pontos + " | Kills: " + kills;
        w = g.getFontMetrics().stringWidth(textoPontuacao); //Determina o tamanho do texto em pixels
        x = (handler.getGame().getFrameW() - w)/2; //calcula a posição do texto
        g.drawString(textoPontuacao, x, 90);

        //Exibe o tempo
        textoTempo = "Tempo: " + (String.format("%.1f", tempo));
        w = g.getFontMetrics().stringWidth(textoTempo); //Determina o tamanho do texto em pixels
        x = (handler.getGame().getFrameW() - w)/2; //calcula a posição do texto
        g.drawString(textoTempo, x, 120);

        g.setColor(Color.white);
        g.fillRect(25,130,750,5);






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
