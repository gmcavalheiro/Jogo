package jogo.Utilidades;

public class Score {

    private int kills = 0;

    public Score(){

    }

    public int getKills() {
        return kills;
    }

    public void addKill() {
        kills++;
    }
}
