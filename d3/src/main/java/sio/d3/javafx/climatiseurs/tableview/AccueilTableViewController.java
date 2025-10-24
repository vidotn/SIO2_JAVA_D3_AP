package sio.d3.javafx.climatiseurs.tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccueilTableViewController implements Initializable {


    @FXML
    private TableView tableViewClims;

    private static ObservableList<Climatiseur> climatiseurs  =
            FXCollections.observableArrayList();



    @FXML
    public void goToAjoutClimatiseur(MouseEvent event)
    {

        Stage stage = (Stage) tableViewClims.getScene().getWindow();

        try
        {
            FXMLLoader root = new FXMLLoader(GestionClimatiseurs.class.getResource("ajout-climatiseur.fxml"));
            Scene scene = new Scene(root.load(),700, 900);
            stage.setScene(scene);
            stage.setTitle("Nouveau climatiseur");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.err.println(getClass().getName()+" : Il y a une erreur lors de laffichage de la fenêtre d'ajout.");
        }


    }

    public static ObservableList<Climatiseur> getClimatiseurs() {
        return climatiseurs;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Climatiseur c = new Climatiseur("Climatiseur test",24000);
        climatiseurs.add(c);

        tableViewClims.setItems(climatiseurs);
    }
}
