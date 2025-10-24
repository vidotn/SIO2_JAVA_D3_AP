package sio.d3.java.exemples_cours;

import java.util.Date;

public class Voiture {

    private String imma;

    public Voiture(String imma) {
        this.imma = imma;
    }

    public String getImma() {
        return imma;
    }

    public void setImma(String imma) {
        this.imma = imma;
    }

    public class RoueSecours{
        private Date dateChangement;

        public RoueSecours(Date dateChangement) {
            this.dateChangement = dateChangement;
        }

        public Date getDateChangement() {
            return dateChangement;
        }

        public void setDateChangement(Date dateChangement) {
            this.dateChangement = dateChangement;
        }
    }
}
