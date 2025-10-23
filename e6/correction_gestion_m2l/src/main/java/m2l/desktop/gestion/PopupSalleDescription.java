/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l.desktop.gestion;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author nathalie
 */
public class PopupSalleDescription {

    public PopupSalleDescription(Stage fenprinc, String nomsalle)
    {

        Parent root;
        try
        {
            root = FXMLLoader.load(getClass().getResource("/m2l/desktop/gestion/detailsSalle.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Plan de la Maison des ligues de Lorraine");
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
