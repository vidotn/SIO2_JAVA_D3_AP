package sio.d3.java.devoirs.objet.devoir1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice4ListeMirroir {
    public static void main( String[] args ) {

        //la liste symli1 contient les valeurs : 2,7,11,6 et 8
        List<Integer> symli1 = new ArrayList<>(Arrays.asList(2, 7, 11, 6, 8));

        //la liste symli2 contient les valeurs : 8,6,11,7 et 2
        List<Integer> symli2 = new ArrayList<>(Arrays.asList(8, 6, 11, 7, 2));


        for(Integer courant: symli1){ System.out.print(courant + " ");}
        System.out.println();
        for(Integer courant: symli2){ System.out.print(courant + " ");}

        //A compléter sur la copie
        boolean reponse = false;

        if(symli1.size()==symli2.size())
        {

            reponse = true;

            int k=symli1.size()-1;


            for(Integer courant: symli1){

                if(courant!=symli2.get(k))
                {
                    reponse = false;
                    break;
                }

                k--;
            }
        }

        System.out.println();

        if(reponse) System.out.println("Nous avons des listes miroirs");
        else System.out.println("Nous n'avons pas des listes miroirs");


    }
}