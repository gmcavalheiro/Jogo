package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_d extends Ladrilho {

    public Tijolo_d(int id){
        super(Assets.tijolo_d, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}