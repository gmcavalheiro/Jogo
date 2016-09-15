package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_d extends Ladrilho {

    public Agua_d(int id) {
        super(Assets.agua_d, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
