package jogo.Assets.Ladrilhos;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Bloco_1 extends Ladrilho {

    public Bloco_1(int id) {
        super(Assets.bloco_1, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}
