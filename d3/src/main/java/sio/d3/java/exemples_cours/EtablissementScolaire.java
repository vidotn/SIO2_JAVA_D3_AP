package sio.d3.java.exemples_cours;

public class EtablissementScolaire {

    private static String adresseRectorat;

    private  String nom;
    private String adresse;

    public EtablissementScolaire(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public static String getAdresseRectorat() {
        return adresseRectorat;
    }

    public static void setAdresseRectorat(String adresseRectorat) {
        EtablissementScolaire.adresseRectorat = adresseRectorat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
