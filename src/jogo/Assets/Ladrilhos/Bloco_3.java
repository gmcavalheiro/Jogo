package jogo.Assets.Ladrilhos;

import jogo.Assets.Assets;
import jogo.Assets.Ladrilho;

public class Bloco_3 extends Ladrilho {

    public Bloco_3(int id) {
        super(Assets.bloco_3, id);
    }

    @Override
    public boolean solido(){
        return true;
    }
}