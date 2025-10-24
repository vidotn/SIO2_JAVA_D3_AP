package sio.d3.javafx.climatiseurs.bdd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AjoutClimatiseurController implements Initializable {

    @FXML
    private Label marque;
    @FXML
    private Label puissance;

    @FXML
    private TextArea valMarque;
    @FXML
    private TextArea valPuissance;
    protected List<Climatiseur> lesclims=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        marque.setText("Saisir la marque : ");
        puissance.setText("Saisir la puissance : ");

    }

    public void ajoutClimatiseur(int p, String m)
    {
        Climatiseur c = new Climatiseur(m,p);
        lesclims.add(c);
    }

    public  String climatiseursToString(){

        String infos="";
        int cpt=1;

        for(Climatiseur c : lesclims)
        {
            infos=infos+"Climatiseur "+cpt+" : "+c.getPuissance() + " de "+c.getSurface_min()+" à "+c.getSurface_max() + "m2"+"\n";
            cpt++;
        }

        return  infos;
    }

    public  List<Climatiseur> ClimParPuissance (int puiss)
    {

        List<Climatiseur> resultat = new ArrayList<>();

        for(Climatiseur c : lesclims)
        {
            if (c.getPuissance()==puiss) resultat.add(c);
        }

        return  resultat;

    }

    public void enregistrer(MouseEvent event)
    {
        int p = Integer.parseInt(valPuissance.getText());
        String m = valMarque.getText();

        System.out.println("Enregistrement du climatiseur .... "+m+" : "+p);

        //création d'un nouvel objet
        Climatiseur c = new Climatiseur(m,p);

        //ajout du climatiseur dans la liste du climatiseur du modèle
        AccueilTableViewController.getClimatiseurs().add(c);


        Stage stage = (Stage) marque.getScene().getWindow();

        try
        {
            FXMLLoader root = new FXMLLoader(GestionClimatiseurs.class.getResource("accueil-tableview.fxml"));
            Scene scene = new Scene(root.load(),700, 900);
            stage.setScene(scene);
            stage.setTitle("Gestion des climatiseur");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.err.println(getClass().getName()+" : Il y a une erreur lors de laffichage de la liste des climatiseurs après ajout d'un nouveu climatiseur.");
        }

    }


  /*  @FXML
    public void eraseField(MouseEvent event) {

        System.out.println(event.getX()+" "+event.getY());

        sh_val.setText("");
        nbh_val.setText("");
        resultat.setText("Le résultat s'affichera ici");

    }*/

    /*
    @FXML
    protected void onHelloButtonClick() {

        int res = Integer.parseInt(sh_val.getText())*Integer.parseInt(nbh_val.getText());

        resultat.setText("Votre salaire hebdomadaire sera de "+res+" euros.");
    }
*/
}