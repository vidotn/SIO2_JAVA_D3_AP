package sio.d3.java.exemples_cours;

public class Inscrit extends PersonneAbst {

    private int age;
    public Inscrit(String n, String p) {
        this.setNom(n);
        this.setPrenom(p);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected void AfficheInfos() {
        System.out.println("Ici on affichera les infos de l'inscrit.");
    }
}
