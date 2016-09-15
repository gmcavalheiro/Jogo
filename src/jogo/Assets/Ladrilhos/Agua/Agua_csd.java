package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_csd extends Ladrilho {

    public Agua_csd(int id) {
        super(Assets.agua_csd, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
