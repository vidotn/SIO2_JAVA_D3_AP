package sio.d3.java.devoirs.objet.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //initialisation de la liste avec des valeurs chaîne de caractères
        List<String> countries = new ArrayList<>(Arrays.asList("France", "Royaume-Uni", "Espagne",
                "Portugal", "Allemagne", "Pologne", "Ukraine",
                "Bulgarie", "Hongrie", "Etats-Unis", "Canada", "Mexique", "Brésil", "Argentine",
                "Chili", "Afrique du sud", "Russie", "Turquie", "Norvège", "Chine", "Inde",
                "Tahilande", "Vietnam", "Indonésie", "Australie", "Philippines", "Suède", "Finlande"));

        //initialisation de la liste avec des valeurs réelles
        List<Float> stats = new ArrayList<>(List.of(23.2f, 28.6f, 11.4f,3.7f, 44.6f, 17.5f,
                11.1f, 1.1f, 3.0f, 188.0f, 24.1f, 5.7f, 31.9f, 10.2f, 5.8f, 1.8f, 56.3f, 16.1f,
                4.3f, 242.3f, 4.4f, 11.0f, 3.5f, 4.5f, 13.3f, 6.2f, 7.7f, 4.1f));



        /*Affichage du nombre péta_octets par pays en parcourant la liste*/
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i) + ": " + stats.get(i) + " Po.");
        }

        System.out.println("\n\nLe nombre moyen de péta octets  téléchargés est de : \n\n");

    }

    /**
     * Cette fonction prend un paramètre une liste et renvoi l'indice correspondant à la valeur la moins élevée
     *
     * @param L : la liste pour laquelle on veut déterminer la valeur mininmal
     * @return : la valeur minimale parmi toutes les valeurs de la liste
     * *
     */
    public int min_key(List<Float> L) {
        int min = 0;
        float val_min;

        //à compléter

        return min;
    }

    /**
     * Cette fonction prend un paramètre une liste et renvoi l'indice correspondant à la valeur la plus élevée
     *
     * @param L : la liste pour laquelle on veut déterminer la valeur maximal
     * @return : la valeur maximale parmi toutes les valeurs de la liste
     */
    public int max_key(List<Float> L) {
        int max = L.size() - 1;
        float val_max;
        //à compléter

        return max;
    }
}