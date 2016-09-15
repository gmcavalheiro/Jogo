package jogo.Assets.Ladrilhos.Tijolo;

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