package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_cie extends Ladrilho {

    public Tijolo_cie(int id){
        super(Assets.tijolo_cie, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}