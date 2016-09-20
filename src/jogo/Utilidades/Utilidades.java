package jogo.Utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilidades {

    public static String loadFile(String caminho){
        StringBuilder construtor = new StringBuilder();

        try {
            //BufferedReader br = new BufferedReader(new FileReader(caminho));
            BufferedReader br = new BufferedReader(new InputStreamReader(Utilidades.class.getResourceAsStream(caminho)));
            String linha;
            while ((linha = br.readLine()) != null){
                construtor.append(linha + "\n");
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return construtor.toString();
    }

    public static int parseInt(String num){
        try {
            return Integer.parseInt(num);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}
