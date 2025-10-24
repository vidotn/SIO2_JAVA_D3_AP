package sio.d3.java.exemples_cours;

public class Tempo {

    public void go() {
        Climatiseur c = new Climatiseur();

        c.puissance = 1200;

        c.setMarque("Panasonic");

        int diff = c.getSurface_max() - c.getSurface_min();

        System.out.println("diff = " + diff);
    }
}
