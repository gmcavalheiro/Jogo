package jogo;

public class Tijolo extends Ladrilho{

    public Tijolo(int id){
        super(Assets.tijolo, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
