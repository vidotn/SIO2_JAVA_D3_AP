package sio.d3.javafx.climatiseurs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

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

        ajoutClimatiseur(p,m);

        System.out.println(climatiseursToString());

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