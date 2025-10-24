package sio.d3.java.devoirs.objet.devoir1;


import java.util.ArrayList;
import java.util.List;

public class Exercice2QuafficheProgramme {

    public static void main( String[] args ) {

        List<Integer> nombres_jours_mois;
        nombres_jours_mois=new ArrayList<>();

        //affichage des éléments de la liste
        affiche(nombres_jours_mois);

        nombres_jours_mois.add(31);

        affiche(nombres_jours_mois);

        for(int k=1; k<=6; k++){
            nombres_jours_mois.add(31);
        }

        affiche(nombres_jours_mois);

        nombres_jours_mois.add(4,30);
        nombres_jours_mois.add(4,30);

        affiche(nombres_jours_mois);

        nombres_jours_mois.add(6,28);

        affiche(nombres_jours_mois);

        nombres_jours_mois.add(7,30);
        nombres_jours_mois.add(7,30);

        affiche(nombres_jours_mois);

    }

    public static void affiche(List<Integer> liste)
    {
        System.out.print("[");
        for(Integer courant: liste){
            System.out.print(courant + " - ");
        }
        System.out.print("]\n");
    }

}