package jogo.Utilidades.Score;

import jogo.Utilidades.Handler;
import jogo.Utilidades.Utilidades;
import org.lwjgl.Sys;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Score {

    private Handler handler;
    private ArrayList<Registros> scoreboard;
    private IO io;
    private Registros reg;
    private Comparator<Registros> ordena = new Comparator<Registros>() {
        @Override
        public int compare(Registros o1, Registros o2) {
            if(o1.getPontos() < o2.getPontos()){
                return 1;
            }else{
                return -1;
            }
        }
    };


    public Score (Handler handler){
        this.handler = handler;
        scoreboard = new ArrayList<>();
        io = new IO(handler);

        io.entrada();

        scoreboard = io.getLista();

        for(int i = 0; i < io.getLista().size(); i++){
            System.out.println(io.getLista().get(i).getNome() + " - " + io.getLista().get(i).getPontos());
        }


//        try {
//            io.saida(scoreboard);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    public ArrayList<Registros> getScoreboard() {
        return scoreboard;
    }

    public void addScore(String nome, int pontos, float tempo){
        reg = new Registros();
        reg.setNome(nome);
        reg.setPontos(pontos);
        reg.setTempo(tempo);
        scoreboard.add(reg);
    }

    public void salvaScore(){
        scoreboard.sort(ordena);

        System.out.println("--------------------------------------------------");
        for(int i = 0; i < io.getLista().size(); i++){
            System.out.println(io.getLista().get(i).getNome() + " - " + io.getLista().get(i).getPontos());
        }

        try {
            io.saida(scoreboard);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
