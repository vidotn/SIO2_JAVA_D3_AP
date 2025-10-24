package sio.d3.java.tp_bases;

import java.util.Scanner;

public class NombreDeE {
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String message="";
        int nbe=0;

        System.out.println( "Saisir un message : " );

        message+= sc.next();

        for(int i=0;i<message.length();i++){
            if(message.charAt(i)=='e'||message.charAt(i)=='E'){
                nbe++;
            }
        }
        System.out.println( " Il y a "+nbe+" lettre \"e\" dans le message \""+message+"\"");

    }
}