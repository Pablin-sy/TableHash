/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablashash;

import java.util.HashMap;
import java.util.StringTokenizer;


public class GenerarTabla {

    public void GenerarTokens(String buffer) {
        String text = "", text2 = "", textbuffer = "";
        int comp = 0, conty = 0, contx = 0, contesp = 0, jini = 0;
        for (int j = 0; j < buffer.length(); j++) {
            char letra = buffer.charAt(j);
            if (letra == ' ') {
                contesp = contesp + 1;
            }
            if (contesp == 0) {
                textbuffer = textbuffer + letra;
                jini = j + 2;
            }
        }

        for (int i = jini; i < buffer.length(); i++) {
            char letra = buffer.charAt(i);
            if ((Integer.valueOf(letra) == 10) || (Integer.valueOf(letra) == 13)) {
                contx = -1;
            }

            if (i > jini) {
                if (buffer.charAt(i - 1) == ' ' || buffer.charAt(i) == ';') {
                    text2 = text;
                    text = "";
                    System.out.print(" " + conty + contx + text2);

                }
            }

            int suma = 0;
            suma = 56 + 41;
            if (contx == 0) {
                if (conty == 0) {
                    System.out.print(" " + conty + contx + textbuffer);
                } else if (conty > 0) {
                    text2 = text;
                    text = "";
                    System.out.print(" " + conty + contx + text2);
                }
            }
            if (Integer.valueOf(letra) == 10) {
                conty = conty + 1;
            }
            text = text + letra;
            contx = contx + 1;
        }
        System.out.print(" " + conty + contx + text);
    
    }

    public HashMap tokens(String cadena){
        
        String []lineas = cadena.split("\n");
        HashMap<String, String> variables = new HashMap<String, String>();
        for (int i = 0; i < lineas.length; i++) {
            String cad_aux = lineas[i];
            String palabra="";
            int cont_ant=0;
            for (int j = 0; j < cad_aux.length(); j++) {
                if(cad_aux.charAt(j)==' '||cad_aux.charAt(j)==';'){
                    String clave = Integer.toString(i) + Integer.toString(cont_ant);
                    variables.put(clave, palabra);
           
                    palabra="";
                    cont_ant=j+1;
                }else
                    palabra+=cad_aux.charAt(j);
            }
            String clave = Integer.toString(i) + Integer.toString(cont_ant-1);
            variables.put(clave, ";");

        }
        
        System.out.println(variables);
        return variables;
    }
}
