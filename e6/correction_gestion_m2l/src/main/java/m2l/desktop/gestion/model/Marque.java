package m2l.desktop.gestion.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Marque {

    private int id;
    private String nom_marque;

    public Marque(int id, String nom_marque) {
        this.id = id;
        this.nom_marque = nom_marque;
    }

    public Marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNom_marque() {
        return nom_marque;
    }

    public void setNom_marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", nom_marque='" + nom_marque + '\'' +
                '}';
    }

    //les propriétés pour le TableView
    public SimpleStringProperty nomProperty() {
        return new SimpleStringProperty(nom_marque);
    }

    public SimpleIntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }
}
