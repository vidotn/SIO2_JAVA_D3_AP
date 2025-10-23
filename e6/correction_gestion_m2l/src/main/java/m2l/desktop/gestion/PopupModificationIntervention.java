package m2l.desktop.gestion;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import m2l.desktop.gestion.controller.ModificationInterventionController;
import m2l.desktop.gestion.model.Intervention;

import java.io.IOException;


/****************************** SITUATION PROFESSIONNELLE  B ******************************

 Nom du projet : Gestion M2L

 Nom du package : m2l.desktop.gestion.controller

 Fichier : SallesTableviewController.java

 Date : Juin 2024

 Auteur : Equipe M2L

 Description : Classe permettant d'afficher la fenêtre modale pour l'ajout d'une intervention dans une salle.
 **************************************************************************************************/

public class PopupModificationIntervention {


    public PopupModificationIntervention(Stage fenprinc, Intervention i) {

        System.out.println("Ouverture de la fenêtre de modification d'une intervention..."+i);
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/m2l/desktop/gestion/formulaire_modif_intervention.fxml"));

        try
        {
            root = loader.load();

            // Récupération du controller associé à la vue
            ModificationInterventionController controller = loader.getController();
            // Passage de l'intervention sélectionnée au controller
            controller.setInterventionSelectionnee(i);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Modifier une intervention dans une salle");
            stage.setScene(scene);
            stage.initOwner(fenprinc);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();


        }
        catch (IOException ex)
        {
          //  Logger.getLogger(PopupSalleDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
