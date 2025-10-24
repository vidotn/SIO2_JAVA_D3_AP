package sio.d3.java.tp_bases;

import java.util.ArrayList;
import java.util.List;

public class ClassesAdressesIP {
    public static void main(String[] args) {
        List<String> adresses_ip = new ArrayList<>(6);
        int i;

        adresses_ip.add("145.245.45.225");
        adresses_ip.add("192.168.1.2");
        adresses_ip.add("97.124.36.142");
        adresses_ip.add("224.0.4.5");
        adresses_ip.add("202.2.48.149");
        adresses_ip.add("240.2.77.27");

        String bin = getPremOctetBin(adresses_ip.get(0));
        System.out.println(bin);

    }

    //Fonction qui converti le premier octet d’une adresse ip en binaire
    public static String getPremOctetBin(String adresseip) {
        String[] morceaux = adresseip.split("\\.");
        String bin = "", bin2 = "";
        int deci = Integer.valueOf(morceaux[0]);
        int r;

        for (int i = 0; i < 8; i++) {
            r = (int) (deci % 2);
            deci = deci / 2;

            bin = bin + String.valueOf(r);
        }


        for (int j = 7; j >= 0; j--) {
            bin2 = bin2 + bin.charAt(j);
        }

        return bin2;
    }
}