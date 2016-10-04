package jogo;

import jogo.Utilidades.Handler;
import jogo.Utilidades.Score.Registros;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class EstadoCreditos extends Estado {


    private int pontos, kills;
    private float tempo;
    private String nome = "", textoTempo, textoPontuacao, grupo, texto = "";
    private float h = 0f;
    int hsb;
    Color cor;
    InputStream istream = getClass().getResourceAsStream("/fonts/PressStart.ttf");
    Font font = null;
    Font font_maior, font_menor, font_texto;
    int w, x, sb;
    private ArrayList<Registros> scoreboard;


    public EstadoCreditos(Handler handler){
        super(handler);
        scoreboard = new ArrayList<>();
        scoreboard = handler.getGame().getScore().getScoreboard();
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
        w = g.getFontMetrics().stringWidth(texto); //Determina o tamanho do texto em pixels
        x = (handler.getGame().getFrameW() - w)/2; //calcula a posição do texto
        g.drawString(texto, x, 60); //Imprime o texto

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

        g.setFont(font_texto); //Fonte maior
        sb = 180;
        for(Registros reg : scoreboard){
            g.drawString(reg.getNome() + " - " + reg.getPontos(), 50, sb);
            sb += 20;
        }

//        g.drawString("Obrigado por jogar, esperamos que tenha gostado.", 50, 200);
//        g.drawString("Jogo feito pelos alunos: Gabriel Cavalheiro, Gabriel Teodoro,", 50, 250);
//        g.drawString("Vinicius Trebejo e Vitor Cardoso, do Segundo Ano(4º semestre)", 50, 300);
//        g.drawString("da UNIP, Campus de Bauru.", 50, 350);
//        g.drawString("Agradecimentos ao professor de programação orientada a objeto,", 50, 400);
//        g.drawString("Célio Castelano, e à coordenadora do curso de Ciência da Computação,", 50, 450);
//        g.drawString("Angela Rochetti.", 50, 500);



        g.setColor(Color.white);
        g.fillRect(25,550,750,5);
        g.setFont(font_texto); //Fonte maior
        grupo = "Gabriel Cavalheiro, Gabriel Teodoro, Vinicius Trebejo e Vitor Cardoso";
        w = g.getFontMetrics().stringWidth(grupo); //Determina o tamanho do texto em pixels
        x = (handler.getGame().getFrameW() - w)/2; //calcula a posição do texto
        g.drawString(grupo, x, 580);


        g.setColor(Color.BLACK);
    }


    private void creditos(){
        if(Estado.getEstadoAtual().equals(this)){

            //Recebe as informações
            pontos = handler.getGame().getPontos();
            kills = handler.getGame().getKills();
            tempo = handler.getMundo().getTempo();
            nome = handler.getGame().getNome();
            texto = handler.getGame().getTexto();

            if(handler.getKeyManager().espaco || handler.getJoystickManager().start) iniciaMenu();

        }


    }

    private void iniciaMenu(){
        //handler.getGame().getMusica().paraMusica(); //Para a musca do Menu
        handler.getGame().getMusica().PararCreditos();
        handler.getGame().getMusica().MusicaMenu(); //Começa a musicas do Jogo (mudar também em Jogo.java)
        handler.getGame().setMouseAtivo(true);
        handler.getMundo().setComeco();
        handler.getMundo().reset();
        Estado.setEstadoAtual(handler.getGame().estadoMenu);
    }







}
