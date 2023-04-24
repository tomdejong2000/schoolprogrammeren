import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Vak {
    String modulecode;
    int jaar;


    //hashmaps om bij te houden welke student welk cijfer heeft gehaald
    HashMap<Student, Double> cijfers = new HashMap<Student, Double>();


    //getters
    public String getModulecode() {
        return modulecode;
    }


    public Vak(String m, int j){
        modulecode = m;
        jaar = j;
    }

    //voeg resultaat toe functie die wordt aangeroepen binnen in student class toevoeg functie zodat het in beide staat
    //voor makkelijkere vergelijkingen
    public void addResult(Student s, double c){
            cijfers.put(s, c);
    }



}
