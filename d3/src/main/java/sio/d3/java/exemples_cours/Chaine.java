package sio.d3.java.exemples_cours;

public class Chaine implements Calculatrice
{
    private String ch1;
    private String ch2;

    public Chaine(String ch1, String ch2) {
        this.ch1 = ch1;
        this.ch2 = ch2;
    }

    public String getCh1() {
        return ch1;
    }

    public void setCh1(String ch1) {
        this.ch1 = ch1;
    }

    public String getCh2() {
        return ch2;
    }

    public void setCh2(String ch2) {
        this.ch2 = ch2;
    }

    @Override
    public String Multiplication() {

        int s1,s2,min,i;
        StringBuilder res= new StringBuilder();

        s1=ch1.length();
        s2=ch2.length();

        min=s1;

        if(min>s2) min=s2;

        for(i=0;i<min;i++){
            res.append(ch1.charAt(i)).append(ch2.charAt(i));
        }

        if(s1>s2){
            for(i=0;i<ch1.length();i++){
                res.append(ch1.charAt(i));
            }
        }
        else        {
            for(i=0;i<ch2.length();i++){
                res.append(ch2.charAt(i));
            }
        }
        return res.toString();
    }
}
