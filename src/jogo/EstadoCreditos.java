package jogo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;
import jogo.Utilidades.ClickListener;
import jogo.Utilidades.Handler;
import jogo.Utilidades.UI.BotaoUI;
import jogo.Utilidades.UI.GerenciadorUI;

import java.awt.*;

public class EstadoCreditos extends Estado {


    private int pontos, kills;
    private float tempo;
    private String nome;

    public EstadoCreditos(Handler handler){
        super(handler);

    }

    @Override
    public void atualiza() {
        creditos();
   }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        Graphics2D g2 = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(50, 90, Color.white, 50, 130, Color.black);

        g.setColor(Color.white);
        g.drawString("Jogador: " + nome, 50, 90);
        g.drawString("Tempo: " + (String.format("%.1f", tempo)), 50, 105);
        g.drawString("Pontos: " + pontos, 50, 120);
        g.drawString("Kills: " + kills, 50, 135);

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
        handler.getGame().getMusica().wavMusic("/musicas/Young_Love.wav", -28.0f, true); //Começa a musica do Jogo (mudar também em Jogo.java)
        handler.getGame().setMouseAtivo(true);
        handler.getMundo().setComeco();
        Estado.setEstadoAtual(handler.getGame().estadoMenu);
    }







}
