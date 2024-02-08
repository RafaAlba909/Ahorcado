package AHORCADO;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) {

        String[] palabras= new String[]{"hola", "bingo", "cuatro", "rojo", "botella"};
        Random r = new Random();
        int n = r.nextInt(palabras.length);
        String palabraSecreta = palabras[n];

        int numeroLetrasPalSecret = palabraSecreta.length();
        char[] palabraGuiones = new char[numeroLetrasPalSecret];
        Arrays.fill(palabraGuiones, '_');

        boolean juegoTerminado=false;
        Scanner scanner= new Scanner(System.in);
        int intentos=5;

        do {
            System.out.println(palabraGuiones);
            System.out.println("Introduce una letra");
            System.out.println("Te quedan " +intentos+ " intentos");
            char letraPedida=scanner.next().charAt(0);

            boolean letraAcertada=false;

            for (int i = 0; i <palabraSecreta.length() ; i++) {
                if (palabraSecreta.charAt(i)==letraPedida){
                    palabraGuiones[i]=letraPedida;
                    letraAcertada=true;
                }
            }
            if (!letraAcertada){
                System.out.println("Lo siento, vuelve a intentarlo");
                --intentos;
                if (intentos==0) {
                    System.out.println("Has perdido, agotaste los intentos");
                    juegoTerminado=true;
                }
            }else {
               boolean juegoGana = !hayGuiones(palabraGuiones);
               if (juegoGana){
                   System.out.println("La palabra era: "+palabraSecreta);
                   System.out.println("Has ganado, felicidades!!!");
                   juegoTerminado=true;
                   break;
               }
            }
        }while (!juegoTerminado);

    }

    static boolean hayGuiones(char[] array){
        for (char item:array) {
            if (item == '_') {
                return true;
            }
        }
        return false;
    }
}

