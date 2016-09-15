package jogo.Assets.Ladrilhos;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Bloco_2 extends Ladrilho {

    public Bloco_2(int id) {
        super(Assets.bloco_2, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
