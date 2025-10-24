package sio.d3.java.navale;

import java.util.ArrayList;
import java.util.List;

public class Navale
{
    private static List<Navire>bateaux_joueurs = new ArrayList();
    private static List<Navire>bateaux_ordinateur = new ArrayList();
    private static List<Point> plateau;
    private static Joueur joueur;

    private static int dim = 10;

    public static void main(String[] args)
    {
        //permet de lire le pseudo et la devise du joueur
        configurerJoueur();
        //créer le plateau (initilialisation de plateau avec des "o")
        CreerPlateau();
        //Affiche la plateau de jeu
        AffichePlateau();
        //demande au joueur de placer ses bateaux (les informations sont
        //sauvegardées dans bateaux_joueurs
        PlacerNaviresJoueur();
        //place les bateaux de l'odinateur de façon aléatoire (les informations sont sauvegardées dans bateaux_ordinateur)
        PlacerNaviresOrdinateur();
    }

    private static void configurerJoueur () {}
    private static void PlacerNaviresJoueur () {}
    private static void PlacerNaviresOrdinateur () {}

    private static void CreerPlateau ()
    {
        plateau = new ArrayList();

        for(char c='A';c <(char)'A'+dim;c++)
        {
            for(int j=1;j<= dim;j++)
            {
                plateau.add(new Point(c,j,'o'));
            }
        }

        plateau.get(2).etat ='x';
        plateau.get(3).etat ='x';
        plateau.get(4).etat ='x';
        plateau.get(5).etat ='x';

        plateau.get(87).etat ='x';
        plateau.get(88).etat ='B';
        plateau.get(89).etat ='x';
    }

    private static void AffichePlateau ()
    {
        System.out.print("");

        System.out.print("   ");
         for(int c=1;c<= dim;c++) System.out.print("\033[31;1m "+c+" ");

         System.out.println("");
            
         //équivalent à : for(int i=0;i< plateau.size();i++)
         for(Point unpoint : plateau)
         {
           //si on est en début de ligne on affiche la lettre
            if(unpoint.y ==1) System.out.print("\033[31;1m "+ unpoint.x +" ");

            //équivalent à : System.out.print (" "+plateau.get(i).etat);
            if(unpoint.etat =='o') System.out.print("\033[34m "+ unpoint.etat+" ");
            if(unpoint.etat =='x') System.out.print("\033[32m "+ unpoint.etat+" ");
            if(unpoint.etat =='B') System.out.print("\033[35m "+ unpoint.etat+" ");

            //si on est en fin de ligne on passe à la ligne
            if(unpoint.y==dim) System.out.println();
         }
    }
}