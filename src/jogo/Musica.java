package jogo;



import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import java.io.File;

public class Musica {

    Sequencer player;

    public void bgMusica(String caminho, int rep){
        try{
            player = MidiSystem.getSequencer();
            Sequence musica = MidiSystem.getSequence(new File(caminho));
            player.open();
            player.setSequence(musica);
            player.setLoopCount(rep);
            player.start();
        }catch (Exception e){
            System.out.println(e);
        }
    }



}
