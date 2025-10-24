package sio.d3.java.tp_bases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaireVersDecimale {
    public static void main( String[] args )
    {
        // Lire le nombre binaire au clavier
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un nombre binaire de 8 bits : ");
        String binaryString = scanner.nextLine();

        // Convertir la chaîne en liste d'entiers
        List<Integer> binary = new ArrayList<>();
        for (int i = 0; i < binaryString.length(); i++) {
            binary.add(Character.getNumericValue(binaryString.charAt(i)));
        }

        int decimal = convertir(binary);

        System.out.println("Le nombre binaire " + binary + " correspond au nombre décimal " + decimal);
    }

    public static int convertir(List<Integer> binary)
    {
        int decimal = 0;
        int k = 0;

        // Parcourir la liste en partant de la fin (bit de poids faible)
        for (int i = binary.size() - 1; i >= 0; i--) {
            // Récupérer la valeur du bit courant
            int bit = binary.get(i);

            // Si le bit est à 1, ajouter la puissance de deux correspondante au nombre décimal
            if (bit == 1) {
                decimal += Math.pow(2, k);
            }
            k++;

        }

        return decimal;

    }
}