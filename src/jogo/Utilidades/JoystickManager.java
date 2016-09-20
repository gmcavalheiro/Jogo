package jogo.Utilidades;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

import javax.swing.*;
import java.util.ArrayList;

public class JoystickManager {

    public Controller controller;
    private ArrayList<Controller> controles;


    public boolean attk, start, select;
    public boolean cima, baixo, direita, esquerda;
    private int idx;



    public JoystickManager(){
        try {
            Controllers.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        controles = new ArrayList<>();

        Controllers.poll();


        for(int i = 0; i < Controllers.getControllerCount(); i++){
            controller = Controllers.getController(i);
            controles.add(controller);
        }

        String[] listaDeControles = new String[controles.size()];

        for(int i = 0; i < controles.size(); i++){
            listaDeControles[i] = controles.get(i).getIndex() + " - " + controles.get(i).getName();
            //System.out.println(listaDeControles[i]);
        }


        //Mensagem para escolher o controle.
        String input = (String) JOptionPane.showInputDialog(null, "APS",
                "Selecione o Controle: ", JOptionPane.QUESTION_MESSAGE, null,
                listaDeControles,
                listaDeControles[0]);

        //corta a string do controle escolhido e converte em Integer
        idx = Integer.parseInt(input.substring(0,1));
        System.out.println(idx);

        controller = Controllers.getController(idx);


        //acerta a tolerancia do controle
        for(int i = 0; i < controller.getAxisCount(); i++){
            controller.setDeadZone(i, 0.3f);
        }
    }

    public void atualiza(){

        if(controller.getButtonCount() != 12) return;

        cima = false;
        baixo = false;
        direita = false;
        esquerda = false;

        controller.poll();

        if(controller.getPovX() > 0 || controller.getXAxisValue() > 0){
            esquerda = true;
        }else if(controller.getPovX() < 0 || controller.getXAxisValue() < 0){
            direita = true;
        }

        if(controller.getPovY() < 0 || controller.getYAxisValue() < 0){
            cima = true;
        }else if(controller.getPovY() > 0 || controller.getYAxisValue() > 0){
            baixo = true;
        }

        select = controller.isButtonPressed(8);
        start = controller.isButtonPressed(9);
        attk = controller.isButtonPressed(5);
//        if(select) System.out.println("sel");
//        if(start) System.out.println("sts");
//        if(attk) System.out.println("attk");
//        if(esquerda) System.out.println("Esq.");
//        if(direita) System.out.println("Dir.");
//        if(cima) System.out.println("Cima");
//        if(baixo) System.out.println("Baixo");
    }
}

/*
MAPA DE BOTOES
0: Botão 0: 1
1: Botão 1: 2
2: Botão 2: 3
3: Botão 3: 4
4: Botão 4: L1
5: Botão 5: R1
6: Botão 6: L2
7: Botão 7: R2
8: Botão 8: Select
9: Botão 9: Start
10: Botão 10: L3
11: Botão 11: R3
 */
