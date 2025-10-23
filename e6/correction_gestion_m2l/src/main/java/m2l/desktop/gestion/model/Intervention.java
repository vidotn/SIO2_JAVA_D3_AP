/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l.desktop.gestion.model;

//import java.sql.Date ;

import com.google.gson.annotations.Expose;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * @author nathalie
 */
public class Intervention {
    private int id_intervention;
    private int numSalle;
    private int numIntervenant;
    private LocalDateTime date_heure ;
    private String motif;

    private Intervenant intervenant;

    private Salle salle;

    public Intervention(int id_intervention, String motif, LocalDateTime  date ,int numIntervenant, int numSalle, Salle salle, Intervenant intervenant) {
        this.id_intervention = id_intervention;
        this.motif = motif;
        this.date_heure  = date ;
        this.numIntervenant = numIntervenant;
        this.numSalle = numSalle;
        this.salle = salle;
        this.intervenant = intervenant;

    }

    public Intervention(String motif) {
        this.motif = motif;
    }

    public int getId_intervention() {
        return id_intervention;
    }

    public void setId_intervention(int id_intervention) {
        this.id_intervention = id_intervention;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public int getNumIntervenant() {
        return numIntervenant;
    }

    public void setNumIntervenant(int numIntervenant) {
        this.numIntervenant = numIntervenant;
    }

    public LocalDateTime getDate_heure() {
        return date_heure;
    }

    public void setDate_heure(LocalDateTime date_heure) {
        this.date_heure = date_heure;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public String toString() {
        return "Intervention n°" + this.id_intervention + " le " + this.date_heure  + " pour le motif : " + this.motif +
                "\n-- " + this.salle.toString() + "\n-- " + this.intervenant.toString();
    }


    //Les propriétés pour la TableView
    public SimpleStringProperty getDateProperty() {

    //  SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
      //String la_Date  = f.format(this.date_heure );

        return new SimpleStringProperty(date_heure .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
    }



    public SimpleStringProperty getMotifProperty() {

        return new SimpleStringProperty(this.motif);

    }

    public SimpleStringProperty motifProperty() {
        return new SimpleStringProperty(motif);
    }
}
