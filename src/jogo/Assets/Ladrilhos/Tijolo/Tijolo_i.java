package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_i extends Ladrilho {

    public Tijolo_i(int id){
        super(Assets.tijolo_i, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}