package jogo.Assets.Ladrilhos.Agua;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Agua_cid extends Ladrilho {

    public Agua_cid(int id) {
        super(Assets.agua_cid, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
