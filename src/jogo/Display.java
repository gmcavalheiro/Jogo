package jogo;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String titulo;
    private int widtth, height;

    public Display(String titulo, int widtth, int height){
        this.titulo = titulo;
        this.widtth = widtth;
        this.height = height;

        criarDisplay();
    }

    private void criarDisplay(){
        //Cria a tela do jogo
        frame = new JFrame(titulo); //define o titulo
        frame.setSize(widtth,height); //define o tamanho
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Cria a exibição do jogo, com tamanho definido
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension( widtth, height));
        canvas.setMaximumSize(new Dimension(widtth, height));
        canvas.setMinimumSize(new Dimension(widtth, height));

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}
