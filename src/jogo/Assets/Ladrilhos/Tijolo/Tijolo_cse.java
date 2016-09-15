package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_cse extends Ladrilho {

    public Tijolo_cse(int id){
        super(Assets.tijolo_cse, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}