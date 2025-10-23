package m2l.desktop.gestion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import m2l.desktop.gestion.PopupAjoutIntervention;
import m2l.desktop.gestion.model.ModelQueries;
import m2l.desktop.gestion.model.Salle;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.TableCell;

/****************************** SITUATION PROFESSIONNELLE  A ******************************

 Nom du projet : Gestion M2L

 Nom du package : m2l.desktop.gestion.controller

 Fichier : SallesTableviewController.java

 Date : Juin 2024

 Auteur : Equipe M2L

 Description : Controller pour la vue affichant les salles dans un TableView.
 **************************************************************************************************/
public class SallesTableviewController implements Initializable {

    /**
     * récupération des éléments définis dans la vue (fxml)
     */
    @FXML
    public TableColumn<Salle, String> nomCol;
    @FXML
    public TableColumn<Salle, Number> capaciteCol;
    @FXML
    public TableColumn<Salle, String> equipementsCol;
    @FXML
    public TableColumn<Salle, String> batimentCol;


    public TableView tableviewSalles;


    @FXML
    public Label dateJour;

    //liste contenant les salles à afficher
    private List<Salle> liste_des_salles = new ArrayList<Salle>();


    private ObservableList<Salle> donnees_salles;


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

        System.out.println("Chargement des salles...");

        liste_des_salles = ModelQueries.getSallesFromApi();


        String bat = "liste_des_salles.get(0).getBatiment();";

        // Afficher les objets Personne
        for (Salle p : liste_des_salles) {
            System.out.println(p);
        }

        //mise en correspondance de la colonne "batimentCol" du tableview
        //avec la propriété "batiment" de la salle de la classe Intervention
        batimentCol.setCellValueFactory(cell -> cell.getValue().batimentProperty());

        batimentCol.setCellFactory(col -> new TableCell<Salle, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                    setStyle("-fx-alignment: CENTER;"); // Style pour centrer le texte
                }
            }
        });

        //mise en correspondance de la colonne "motifCol" du tableview
        //avec la propriété "motif" de la salle de la classe Intervention
        nomCol.setCellValueFactory(cell -> cell.getValue().nomProperty());

        //mise en correspondance de la colonne "salleCol" du tableview
        //avec la propriété "nom" de la salle de la classe Intervention
        capaciteCol.setCellValueFactory(cell -> cell.getValue().capaciteProperty());

        capaciteCol.setCellFactory(col -> new TableCell<Salle, Number>() {
            @Override
            protected void updateItem(Number item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(Integer.toString(item.intValue()));
                    setStyle("-fx-alignment: CENTER;"); // Style pour centrer le texte
                }
            }
        });

        //mise en correspondance de la colonne "intervenantCol" du tableview
        //avec la concaténation "prénom nom" de l'intervenant de la classe Intervention
        equipementsCol.setCellValueFactory(cell -> cell.getValue().equipementsProperty());

        //création de la liste qui correspondra au contenu
        //du tableview
        donnees_salles = FXCollections.observableList(liste_des_salles);
        //mise en correspondance de la liste "donneesIntJour"
        //avec le tableview "todayInt"
        tableviewSalles.setItems(donnees_salles);


    }

    public void ajoutIntervention(MouseEvent mouseEvent) {
        Scene scene = (Scene) ((ImageView) mouseEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        new PopupAjoutIntervention(stage);
    }


    // Classe interne pour représenter une salle séparatrice dans le TableView
    public class SeparatorSalle extends Salle {
        public SeparatorSalle(String name) {
            super(name);
        }
    }
}
