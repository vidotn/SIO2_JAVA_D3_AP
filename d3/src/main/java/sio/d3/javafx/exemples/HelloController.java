package sio.d3.javafx.exemples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label resultat;
    @FXML
    private TextArea sh_val, nbh_val;

    @FXML
    protected void onHelloButtonClick() {

        int res = Integer.parseInt(sh_val.getText())*Integer.parseInt(nbh_val.getText());

        resultat.setText("Votre salaire hebdomadaire sera de "+res+" euros.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //traitement à effectuer lors du chargement de la fenêtre
    }

    @FXML
    public void eraseField(MouseEvent event) {

        System.out.println(event.getX()+" "+event.getY());

        sh_val.setText("");
        nbh_val.setText("");
        resultat.setText("Le résultat s'affichera ici");

    }
}