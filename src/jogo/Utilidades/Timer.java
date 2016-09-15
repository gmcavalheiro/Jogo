package jogo.Utilidades;

public class Timer {

    private long startTimer, stopTimer;
    private long duracao = 30;

    public Timer(){

    }

    public void start(){
        startTimer = System.currentTimeMillis();
    }

    public void stop(){
        stopTimer = System.currentTimeMillis();
    }

    public int getTempo(){
        return (int) ((startTimer - stopTimer)/1000);
    }

}
