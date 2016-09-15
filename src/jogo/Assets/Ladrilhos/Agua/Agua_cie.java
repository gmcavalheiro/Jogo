package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_cie extends Ladrilho {

    public Agua_cie(int id) {
        super(Assets.agua_cie, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
