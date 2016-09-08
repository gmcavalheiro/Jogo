package jogo;



import com.sun.media.sound.WaveFileReader;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.*;

public class Musica {

    Sequencer player;

    public void MidiMusic(String caminho, int rep){
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

    public void wavMusic(String caminho){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            clip.open(inputStream);
            clip.start();
        }catch (Exception e){
            System.out.println(e);
        }
    }



}
