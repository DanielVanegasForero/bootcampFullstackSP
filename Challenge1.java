package minireto1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Challenge1 {

    String sequence = "0123456789";
    String sequence2 = "";
    String finalsequence;

    // Desafío 2.a
    public String randomString(String a) {
        if ("Tipo A".equals(a)) {
            String num = "54";
            //Obtención de cadena aleatoria
            for (int i = 0; i < 8; i++) {
                int index = ThreadLocalRandom.current().nextInt(0, sequence.length());
                char charand = sequence.charAt(index);
                sequence2 += charand;
            }
            finalsequence = num + sequence2;
        } else if ("Tipo B".equals(a)) {
            String num = "08";
            //Obtención de cadena aleatoria
            for (int i = 0; i < 8; i++) {
                int index = ThreadLocalRandom.current().nextInt(0, sequence.length());
                char charand = sequence.charAt(index);
                sequence2 += charand;
            }
            finalsequence = num + sequence2;
        }
        return finalsequence;
    }
    
    //Desafío 2.b
    public boolean findLetter(String a, List<String> b) {
        boolean x = false;
        for (String i : b) {
            if (i == null ? a == null : i.equals(a)) {
                x = true;
                break;
            } else {
                x = false;
            }
        }
        return x;
    }

    public static void main(String[] args) {

        Challenge1 mr1 = new Challenge1();
        Scanner sc = new Scanner(System.in);
        
        //Desafío 2.a
        try{
            System.out.print("Escriba 1 para Tipo A o escriba 2 para Tipo B: ");
             int type = sc.nextInt();
        switch(type){
            case 1:{
                System.out.println(mr1.randomString("Tipo A"));
                break;
            }
            case 2:{
                System.out.println(mr1.randomString("Tipo B"));
                break;
            }default:{
                System.out.println("Opcion incorrecta");
            }
        }
        }catch(InputMismatchException | NumberFormatException ex){
            System.out.println("Ha ingresado un tipo de dato diferente al solicitado");
        }
        
        //Desafío 2.b
        try {
            String a;
            System.out.print("Digite una cadena: ");
            sc.nextLine();
            a = sc.nextLine();
            System.out.print("Digite el número de elementos que tendrá la lista: ");
            int c = Integer.parseInt(sc.nextLine());
            List<String> b = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                System.out.print("Ingrese el " + (i + 1) + " elemento de la lista: ");
                //b[i] = sc.nextLine();
                b.add(sc.nextLine());
            }
            System.out.println(mr1.findLetter(a, b));
        } catch (InputMismatchException | NumberFormatException ex) {
            System.out.println("Error, digitó un dato inválido");
        }

    }
}
