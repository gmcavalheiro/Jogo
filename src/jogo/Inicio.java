package jogo;

import java.io.File;

public class Inicio {
    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath", new File("lib/natives").getAbsolutePath());
        Jogo jogo = new Jogo("APS - Jogo", 800, 600);
        jogo.start();
    }
}
