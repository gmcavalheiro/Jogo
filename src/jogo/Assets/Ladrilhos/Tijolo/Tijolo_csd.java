package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_csd extends Ladrilho {

    public Tijolo_csd(int id){
        super(Assets.tijolo_csd, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}