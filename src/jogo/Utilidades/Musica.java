package jogo.Utilidades;



import com.sun.media.sound.WaveFileReader;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

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

    public void wavMusic(String caminho, float vol, boolean rep){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            clip.open(inputStream);
            if(rep == true){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(vol);
            clip.start();
        }catch (Exception e){
            System.out.println(e);
        }
    }



}
