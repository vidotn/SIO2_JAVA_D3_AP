package sio.d3.javafx.climatiseurs.bdd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionClimatiseurs extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionClimatiseurs.class.getResource("accueil-tableview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),  1200, 700);
        scene.setFill(Color.BEIGE);
        stage.setTitle("Gestion des climatiseur");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}