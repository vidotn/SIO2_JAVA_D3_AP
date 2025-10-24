package sio.d3.java.exemples_cours;

public class Coach extends PersonneAbst {

    private int tel;

    public Coach(String n, String p) {
        this.setNom(n);
        this.setPrenom(p);
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    protected void AfficheInfos() {
        System.out.println("Ici on affichera les infos du coach.");
    }
}
