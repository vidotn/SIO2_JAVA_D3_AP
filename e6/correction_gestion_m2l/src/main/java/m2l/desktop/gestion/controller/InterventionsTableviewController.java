package m2l.desktop.gestion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import m2l.desktop.gestion.PopupAjoutIntervention;
import m2l.desktop.gestion.model.Climatiseur;
import m2l.desktop.gestion.model.Intervention;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import m2l.desktop.gestion.model.ModelQueries;
import m2l.desktop.gestion.PopupModificationIntervention;

public class InterventionsTableviewController implements Initializable {

    /**
     * récupération des éléments définis dans la vue (fxml)
     */
    @FXML
    public TableColumn<Intervention, String> salleCol;
    @FXML
    public TableColumn<Intervention, String> intervenantCol;
    @FXML
    public TableColumn<Intervention, Number> contactCol;
    @FXML
    public TableColumn<Intervention, String> motifCol;
    @FXML
    public TableColumn<Intervention, String> dateHeureCol;

    @FXML
    public TableView<Intervention> tableviewInterventions;


    @FXML
    public Label dateJour;

    //liste contenant les salles à afficher
    private List<Intervention> liste_des_interventions = new ArrayList<Intervention>();


    private ObservableList<Intervention> donnees_interventions;


    /**
     * Méthode lancée lors de l'appui sur le bouton
     * sur la page d'accueil
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");

        try {
            configureOngletInterventions();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void configureOngletInterventions() throws IOException {

        System.out.println("Chargement des interventions...");

        liste_des_interventions = ModelQueries.getInterventionsFromApi();

            // Afficher les objets Personne
            for (Intervention p : liste_des_interventions) {
                System.out.println(p);
            }

        /****************************** SITUATION PROFESSIONNELLE  B ******************************

         Nom du projet : Gestion M2L

         Nom du package : m2l.desktop.gestion.controller

         Fichier : SallesTableviewController.java

         Date : Juin 2024

         Auteur : Equipe M2L

         Description : Rendre le tableview des interventions éditable
         **************************************************************************************************/
        //le  tableview sera éditable
        tableviewInterventions.setEditable(true);

        //la salle pourra être modifiée
        //dans le tableview en double-cliquant dessus
        salleCol.setEditable(true);


        /***************************************************************************************************/

            //mise en correspondance de la colonne "motifCol" du tableview
            //avec la propriété "motif" de la salle de la classe Intervention
            motifCol.setCellValueFactory(cell -> cell.getValue().motifProperty());
            motifCol.setCellFactory(TextFieldTableCell.forTableColumn());



            //mise en correspondance de la colonne "salleCol" du tableview
            //avec la propriété "nom" de la salle de la classe Intervention
            salleCol.setCellValueFactory(cell -> cell.getValue().getSalle().nomProperty());

            dateHeureCol.setCellValueFactory(cell -> cell.getValue().getDateProperty());

            //mise en correspondance de la colonne "intervenantCol" du tableview
            //avec la concaténation "prénom nom" de l'intervenant de la classe Intervention
            intervenantCol.setCellValueFactory(cell -> cell.getValue().getIntervenant().prenomProperty().concat(" ").concat(cell.getValue().getIntervenant().nomProperty()));

            //mise en correspondance de la colonne "contactcol" du tableview
            //avec la propriété "telephone" de l'intervention de la classe Intervention
            contactCol.setCellValueFactory(cell -> cell.getValue().getIntervenant().telephoneProperty());

            //création de la liste qui correspondra au contenu
            //du tableview
            donnees_interventions = FXCollections.observableList(liste_des_interventions);
            //mise en correspondance de la liste "donneesIntJour"
            //avec le tableview "todayInt"
            tableviewInterventions.setItems(donnees_interventions);


    }

    public void ajoutIntervention(MouseEvent mouseEvent) {
        Scene scene = (Scene) ((ImageView) mouseEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        new PopupAjoutIntervention(stage);
    }



    /****************************** SITUATION PROFESSIONNELLE  B ******************************

     Nom du projet : Gestion M2L

     Nom du package : m2l.desktop.gestion.controller

     Fichier : SallesTableviewController.java

     Date : Juin 2024

     Auteur : Equipe M2L

     Description : Rendre le tableview des interventions éditable
     **************************************************************************************************/
    public void modifierIntervention(MouseEvent mouseEvent) {

        Scene scene = (Scene) ((ImageView) mouseEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        Intervention inter = tableviewInterventions.getSelectionModel().getSelectedItem();

        new PopupModificationIntervention(stage, inter);
    }

    public void modificationIntervention(TableColumn.CellEditEvent<Intervention, String> interventionStringCellEditEvent) {

        Intervention i = tableviewInterventions.getSelectionModel().getSelectedItem();
        i.setMotif(interventionStringCellEditEvent.getNewValue().toString());

            ModelQueries.updateInterventionViaApi(i);

    }
}
