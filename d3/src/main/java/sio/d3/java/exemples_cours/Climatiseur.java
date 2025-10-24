package sio.d3.java.exemples_cours;

public class Climatiseur {

    protected int puissance;

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setSurface_min(int surface_min) {
        this.surface_min = surface_min;
    }

    public void setSurface_max(int surface_max) {
        this.surface_max = surface_max;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getMarque() {
        return marque;
    }

    public int getSurface_min() {
        return surface_min;
    }

    public int getSurface_max() {
        return surface_max;
    }

    private String marque;
    private int surface_min;
    private int surface_max;


    public Climatiseur(){}

    public Climatiseur(String m, int p){
        this.marque =m;
        this.puissance = p;
        this.initialisationSurface();
    }

    private void initialisationSurface() {

        switch (puissance){
            case 7000: this.surface_min= 7; this.surface_max = 15; break;
            default : this.surface_min= 7; this.surface_max = 15; break;
        }
    }
}
