package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_e extends Ladrilho {

    public Agua_e(int id) {
        super(Assets.agua_e, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
