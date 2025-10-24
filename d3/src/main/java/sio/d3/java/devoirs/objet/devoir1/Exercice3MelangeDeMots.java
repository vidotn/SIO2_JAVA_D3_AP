package sio.d3.java.devoirs.objet.devoir1;

import java.util.ArrayList;
import java.util.List;

public class Exercice3MelangeDeMots {

    public static void main( String[] args ) {

        List<String> des_mots;
        des_mots = new ArrayList<>();

        des_mots.add("la terre");
        des_mots.add("est");
        des_mots.add("bleue");
        des_mots.add("comme");
        des_mots.add("une orange");

        for(String courant: des_mots){
            System.out.print(courant + " ");
        }

        des_mots.remove(3);
        des_mots.add(1,",");
        des_mots.add(2,des_mots.get(4));
        des_mots.remove(3);
        des_mots.add(3,":");
        des_mots.remove(5);
        des_mots.add("ou orange ?");

        System.out.println();

        for(String courant: des_mots){
            System.out.print(courant + " ");
        }
    }
}