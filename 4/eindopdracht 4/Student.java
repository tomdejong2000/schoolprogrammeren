import java.util.HashMap;

public class Student {
    int studentnummer;
    String naam;
    String geslacht;
    int klas;
    String studierichting;


    //hashmaps voor alle resultaten
    HashMap<Vak, Double> cijfers = new HashMap<Vak, Double>();

    //getters
    public String getNaam() {
        return naam;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public Student(int s, String n, String g, int k, String sr){
        this.studentnummer = s;
        this.naam = n;
        this.geslacht = g;
        this.klas = k;
        this.studierichting = sr;

    }

    //voeg resultaat toe
    public void AddCijfer(Vak v, Double c){

        if(c >= 0.0 && c <= 10){
            cijfers.put(v, c);  //als het een voldoende is stop het resultaat in de behaald hashmap
            v.addResult(this,c); //stop de student + cijfer in de hashmap van het vak
        }else{
            System.out.println("We accepteren alleen cijfer tussen 0.0 en 10");
        }

    }

    public String getGeslacht() {
        return geslacht;
    }



}
