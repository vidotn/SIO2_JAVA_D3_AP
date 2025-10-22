/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l.desktop.gestion.model;

//import java.sql.Date;

import com.google.gson.annotations.Expose;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author nathalie
 */
public class Intervention {
    private int id_intervention;
    private int numSalle;
    private int numIntervenant;
    private Date date;
    private String heure;
    private String motif;

    private Intervenant intervenant;

    private Salle salle;

    public Intervention(int id_intervention, String motif, Date date, String heure, int numIntervenant, int numSalle, Salle salle, Intervenant intervenant) {
        this.id_intervention = id_intervention;
        this.motif = motif;
        this.date = date;
        this.heure = heure;
        this.numIntervenant = numIntervenant;
        this.numSalle = numSalle;
        this.salle = salle;
        this.intervenant = intervenant;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
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
        return "Intervention n°" + this.id_intervention + " le " + this.date + " à " + this.heure + " pour le motif : " + this.motif +
                "\n-- " + this.salle.toString() + "\n-- " + this.intervenant.toString();
    }


    //Les propriétés pour la TableView
    public SimpleStringProperty getDateProperty() {

        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        String la_date = f.format(this.date);

        return new SimpleStringProperty(la_date);
    }

    public SimpleStringProperty getHeureProperty() {

        return new SimpleStringProperty(this.heure);

    }

    public SimpleStringProperty getMotifProperty() {

        return new SimpleStringProperty(this.motif);

    }

    public SimpleStringProperty motifProperty() {
        return new SimpleStringProperty(motif);
    }
}
