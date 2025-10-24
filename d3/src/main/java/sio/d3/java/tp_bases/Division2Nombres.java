package sio.d3.java.tp_bases;

import java.util.Scanner;

public class Division2Nombres {
    public static void main( String[] args )
    {

        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b =0;

        System.out.print( "Saisir la valeur de a : " );
        a = sc.nextInt();

        System.out.print( "Saisir la valeur de b : " );
        b = sc.nextInt();

        if(a>b && b!=0)
        {
            int div = a/b;

            System.out.println( "\n"+ a+"/"+b+" = "+div);
        }
        else
        {
            System.out.println("a doit être supérieure à b et b doit être différent de 0.");
        }


    }
}
