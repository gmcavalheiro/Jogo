package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_e extends Ladrilho {

    public Tijolo_e(int id){
        super(Assets.tijolo_e, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}