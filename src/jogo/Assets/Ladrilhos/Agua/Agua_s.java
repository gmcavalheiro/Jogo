package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_s extends Ladrilho {

    public Agua_s(int id) {
        super(Assets.agua_s, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
