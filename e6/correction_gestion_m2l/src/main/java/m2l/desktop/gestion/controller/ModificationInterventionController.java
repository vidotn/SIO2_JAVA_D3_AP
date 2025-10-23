package m2l.desktop.gestion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import m2l.desktop.gestion.model.Intervention;
import m2l.desktop.gestion.model.ModelQueries;

import java.net.URL;
import java.util.ResourceBundle;

public class ModificationInterventionController  implements Initializable {

    @FXML
    TextArea motifIntervention;

    private Intervention interventionSelectionnee;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    public  void setInterventionSelectionnee(Intervention is) {
        this.interventionSelectionnee = is;
        motifIntervention.setText(is.getMotif());
    }

    public void enregistrer_modification_intervention(ActionEvent actionEvent) {

        System.out.println("Enregistrement de la modification de l'intervention .... ");

        this.interventionSelectionnee.setMotif(motifIntervention.getText());

        ModelQueries.updateInterventionViaApi(this.interventionSelectionnee);

        fermerFenetre(actionEvent);
    }

    public void fermerFenetre(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
