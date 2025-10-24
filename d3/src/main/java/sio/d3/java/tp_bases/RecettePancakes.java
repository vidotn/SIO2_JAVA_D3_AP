package sio.d3.java.tp_bases;

import java.util.Scanner;

public class RecettePancakes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nb = 0;

        System.out.print("Quelle quantité de pancakes souhaitez-vous ? ");
        nb = sc.nextInt();

        if (nb >= 15 && nb % 15 == 0) {
            int fois = nb / 15;

            int farine = 250*fois;
            int oeufs = 3*fois;
            int beurre = 60*fois;
            int lait = 25*fois;
            int levure = 1*fois;
            int sucre = 2*fois;
            int sel = 1*fois;

            System.out.println("Il vous faut : ");
            System.out.println(farine +" g de farine");
            System.out.println(oeufs +" oeufs");
            System.out.println(beurre +" g de beurre");
            System.out.println(lait +" cl de lait");
            System.out.println(levure +" cc de levure chimique");
            System.out.println(sucre +" cs de sucre");
            System.out.println(sel +" pincée(s) de sel");


        } else {
            System.out.println("Le nombre de pancakes doit être un multiple de  15");
        }
    }
}