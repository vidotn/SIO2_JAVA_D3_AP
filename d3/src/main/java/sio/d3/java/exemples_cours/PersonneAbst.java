package sio.d3.java.exemples_cours;

public abstract class PersonneAbst {
    private String nom;
    private String prenom;


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

    //signature de la méthode
    protected abstract void AfficheInfos();

}
