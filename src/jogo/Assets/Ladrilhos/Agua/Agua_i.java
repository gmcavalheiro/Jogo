package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_i extends Ladrilho {

    public Agua_i(int id) {
        super(Assets.agua_i, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
