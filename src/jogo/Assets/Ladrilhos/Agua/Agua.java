package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua extends Ladrilho {

    public Agua (int id) {
        super(Assets.agua, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
