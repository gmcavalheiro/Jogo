package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_cse extends Ladrilho {

    public Agua_cse(int id) {
        super(Assets.agua_cse, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
