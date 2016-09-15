package jogo.Assets.Ladrilhos.Tijolo;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Tijolo_cid extends Ladrilho {

    public Tijolo_cid(int id){
        super(Assets.tijolo_cid, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}