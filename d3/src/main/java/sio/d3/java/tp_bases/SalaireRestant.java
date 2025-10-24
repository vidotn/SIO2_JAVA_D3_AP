package sio.d3.java.tp_bases;

import java.util.Scanner;

public class SalaireRestant {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float salaire = 0F;
        float charge  = 0.0F;
        String rep = "n";

        System.out.print("Saisir votre salaire : ");
        salaire = sc.nextFloat();

        do {
            System.out.print("Saisir le montant de la charge : ");
            charge = sc.nextFloat();
            salaire = salaire- charge;

            System.out.print("Continuer ? o ou n : ");
            rep=sc.next();

        }while(rep.equals("o"));

        System.out.print("\n\nAprès paiement de vos charges, il vous reste " + salaire+" euros");
    }
}