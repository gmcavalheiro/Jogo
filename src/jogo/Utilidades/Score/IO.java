package jogo.Utilidades.Score;

import jogo.Utilidades.Handler;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class IO {

    private Handler handler;
    private ArrayList<Registros> nomes;
    private Registros reg;


    public IO(Handler handler){
        this.handler = handler;
        nomes = new ArrayList<>();
    }



    public void entrada(){
        Scanner arquivo = null;

        arquivo = new Scanner(new InputStreamReader(Score.class.getResourceAsStream("/score/pontos.txt")));

        while (arquivo.hasNext()){
            reg = new Registros();
            reg.setNome(arquivo.next());
            reg.setPontos(Integer.parseInt(arquivo.next()));
            //System.out.println(arquivo.next());
            nomes.add(reg);
        }
        arquivo.close();

//        for(int i = 0; i < nomes.size(); i++){
//            System.out.println(nomes.get(i).getNome() + " - " + nomes.get(i).getPontos());
//        }

    }

    public void saida(ArrayList<Registros> lista) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("res/score/pontos.txt"));
        for (Registros list : lista) {
            String text = list.getNome() + "    " + list.getPontos();
            System.out.println(text);
            pw.println(text);
        }
        pw.close();


    }

    public ArrayList<Registros> getLista(){
        return nomes;
    }


}
