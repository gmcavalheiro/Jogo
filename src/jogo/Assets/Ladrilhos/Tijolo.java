package jogo.Assets.Ladrilhos;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo extends Ladrilho {

    public Tijolo(int id){
        super(Assets.tijolo, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
