package sio.d3.javafx.climatiseurs.tableview;

public class Climatiseur {

    private String marque;
    private int  puissance;
    private int surface_min;
    private int  surface_max;

    public Climatiseur(String marque, int puissance) {
        this.marque=marque;
        this.puissance=puissance;

        switch (this.puissance){
            case 7000: this.surface_min=7; this.surface_max=15; break;
            case 9000: this.surface_min=15; this.surface_max=25; break;
            case 12000: this.surface_min=25; this.surface_max=35; break;
            case 18000: this.surface_min=35; this.surface_max=50; break;
            case 24000: this.surface_min=50; this.surface_max=70; break;
            case 30000: this.surface_min=70; this.surface_max=80; break;
        }
    }


    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getSurface_min() {
        return surface_min;
    }

    public void setSurface_min(int surface_min) {
        this.surface_min = surface_min;
    }

    public int getSurface_max() {
        return surface_max;
    }

    public void setSurface_max(int surface_max) {
        this.surface_max = surface_max;
    }
}
