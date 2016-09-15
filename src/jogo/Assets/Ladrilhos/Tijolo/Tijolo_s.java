package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_s extends Ladrilho {

    public Tijolo_s(int id){
        super(Assets.tijolo_s, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}