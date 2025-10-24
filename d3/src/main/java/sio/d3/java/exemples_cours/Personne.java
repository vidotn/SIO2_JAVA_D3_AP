package sio.d3.java.exemples_cours;

public class Personne {

    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.verifierPersonne();
    }

    public Personne() {

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    protected void verifierPersonne()
    {
        System.out.println("Object créé : "+this.nom+" "+this.prenom);
    }
}
