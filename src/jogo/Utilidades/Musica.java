package jogo.Utilidades;



import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.*;
import java.net.URL;

public class Musica {

    Sequencer player;
    Clip clip;
    Clip selectClip;
    Clip itemClip;
    Clip moveClip;
    Clip comeClip;
    Clip socoClip;
    Clip youLoseClip;
    Clip musicaCreditosClip;
    Clip musicaJogoClip;
    Clip musicaMenuClip;

    public void wavMusic(String caminho, float vol, boolean rep){

        try {
            URL teste = Musica.class.getResource(caminho);
            clip = AudioSystem.getClip();
            //AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(teste);
            clip.open(inputStream);
            if(rep == true){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            //FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            //volume.setValue(vol);
            clip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void paraMusica(){
        clip.stop();
    }

    public void MusicaCreditos(){
        try {
            musicaJogoClip.stop();
            URL musicaCreditosSrc = Musica.class.getResource("/musicas/creditos1.wav");
            musicaCreditosClip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(musicaCreditosSrc);
            musicaCreditosClip.open(inputStream);
            musicaCreditosClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicaCreditosClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void PararCreditos(){
        musicaCreditosClip.stop();
    }

    public void MusicaMenu(){
        try {
            URL musicaMenuSrc = Musica.class.getResource("/musicas/menu.wav");
            musicaMenuClip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(musicaMenuSrc);
            musicaMenuClip.open(inputStream);
            musicaMenuClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicaMenuClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }


    public void MusicaJogo(){
        try {
            musicaMenuClip.stop();
            URL musicaJogoSrc = Musica.class.getResource("/musicas/jogo1.wav");
            musicaJogoClip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(musicaJogoSrc);
            musicaJogoClip.open(inputStream);
            musicaJogoClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicaJogoClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }


    public void SelectSound(){
        try {
            URL selectSrc = Musica.class.getResource("/musicas/MenuSelect.wav");
            selectClip = AudioSystem.getClip();
            //AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(selectSrc);
            selectClip.open(inputStream);
            selectClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void MoveSound(){
        try {
            URL moveSrc = Musica.class.getResource("/musicas/MenuMove.wav");
            moveClip = AudioSystem.getClip();
            //AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(moveSrc);
            moveClip.open(inputStream);
            moveClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void ItemSound(){
        try {
            URL itemSrc = Musica.class.getResource("/musicas/Item.wav");
            itemClip = AudioSystem.getClip();
            //AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(itemSrc);
            itemClip.open(inputStream);
            itemClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void ComeSound(){
        try {
            URL comeSrc = Musica.class.getResource("/musicas/Come.wav");
            comeClip = AudioSystem.getClip();
            //AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(comeSrc);
            comeClip.open(inputStream);
            comeClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void SocoSound(){
        try {
            URL socoSrc = Musica.class.getResource("/musicas/Soco.wav");
            socoClip = AudioSystem.getClip();
            //AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(socoSrc);
            socoClip.open(inputStream);
            socoClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void YouLoseSound(){
        try {
            URL youLoseSrc = Musica.class.getResource("/musicas/YouLose.wav");
            youLoseClip = AudioSystem.getClip();
            //AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminho));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(youLoseSrc);
            youLoseClip.open(inputStream);
            youLoseClip.start();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
