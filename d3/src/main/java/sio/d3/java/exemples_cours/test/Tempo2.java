package sio.d3.java.exemples_cours.test;


import sio.d3.java.exemples_cours.Climatiseur;

public class Tempo2 {
    public void go2() {
        Climatiseur c = new Climatiseur();

        c.setPuissance(1200);

        c.setMarque("Panasonic");

        int diff = c.getSurface_max() - c.getSurface_min();

        System.out.println("diff = " + diff);
    }
}
