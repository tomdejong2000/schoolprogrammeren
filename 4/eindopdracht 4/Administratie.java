import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Administratie {

    //
    public void behaald(Vak b){
        System.out.println("deze studenten hebben " + b.getModulecode() + " gehaald");

        Iterator it = b.cijfers.entrySet().iterator();
        //loop door alle hashmap items
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();

            //geef de datatypes aan voor de keys en values
            Student student = (Student) pair.getKey();
            double cijfer = (double) pair.getValue();

            //als cijfer hoger dan 5.5 en dus voldoende print de naam van de key(student) en student nummer met cijfer
            if(cijfer >= 5.5){
                System.out.println("studentnaam " + student.getNaam() + " studentnummer:  " + student.getStudentnummer() + " cijfer : " + cijfer);
            }
        }
        System.out.println("------------------------------------------");
    }
    public void behaald(Student b){
        System.out.println(b.getNaam() + " met studentnummer: " + b.getStudentnummer() + " heeft deze vakken gehaald");

        Iterator it = b.cijfers.entrySet().iterator();

        //loop door alle items in de hashmap
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();

            //geef aan welke datatype de key en value zijn
            Vak vak = (Vak) pair.getKey();
            double cijfer = (double) pair.getValue();


            //als hoger dan 5.5 heb en dus voldoende print de module coden het cijfer
            if(cijfer >= 5.5){
                System.out.println(vak.getModulecode() + " : " + cijfer);
            }

        }
        System.out.println("------------------------------------------");
    }

    public void nietbehaald(Student n){
        System.out.println(n.getNaam() + " met studentnummer: " + n.getStudentnummer() + " heeft deze vakken niet gehaald");

        Iterator it = n.cijfers.entrySet().iterator();

        //loop door alle hashmap items
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();

            //geef aan welke datatypes de key en de value zijn
            Vak vak = (Vak) pair.getKey();
            double cijfer = (double) pair.getValue();

            //als de value on de 5.5 is haal de modulecode van de key(vak) op en print deze met het cijfer
            if(cijfer <= 5.5){
                System.out.println(vak.getModulecode() + " : " + cijfer);
            }

        }
        System.out.println("------------------------------------------");
    }

    public void nietbehaald(Vak v){
        System.out.println("deze studenten hebben " + v.getModulecode() + " niet gehaald");

        Iterator it = v.cijfers.entrySet().iterator();

        //loop door alle hashmap items heen
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            //geef aan welke datatypes de value en key zijn
            Student student = (Student) pair.getKey();
            double cijfer = (double) pair.getValue();

            //als de value onder de 5.5 is en dus een onvoldoende print de key(student) naam uit met het cijfer
            if(cijfer <= 5.5){
                System.out.println(student.getNaam() + " : " + cijfer);
            }

        }

        System.out.println("------------------------------------------");
    }


    public void gemiddelde(Vak g){
        //stream voor gemmidelde van de values van cijfers hashmap
        Double gem = g.cijfers.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println("het gemiddelde voor vak " + g.getModulecode() + " is: " + gem);
        System.out.println("------------------------------------------");
    }


    public void optellen(Student o){
        //stream voor de sum van alle values van de hashmap
        double som = o.cijfers.values().stream().mapToDouble(Double::doubleValue).sum();

        System.out.println("optelsom van alle cijfers van student " + o.getNaam() + " met studentnummer: " + o.getStudentnummer() + " is: "+ som);
        System.out.println("------------------------------------------");
    }

    public void gemiddelde(Student g){
        //stream voor het gemiddelde van de values van de hashmap
        Double gem = g.cijfers.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println("het gemiddelde voor student " + g.getNaam() + " met studentnummer: " + g.getStudentnummer() + " is: " + gem);
        System.out.println("------------------------------------------");
    }

    public void standaarddeviatie(Student s){

        //get length en gemiddelde
        double length = s.cijfers.size();
        Double gem = s.cijfers.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        double kwadraten = 0;

        //loop door alle waardes
        for (Double value : s.cijfers.values()){
            double a = value;
            //loop door alle waardes heen
            double b = a - gem;
            //krijg de deviaties
            double c = b * b;
            //kwadraateer en tel alle kwadraten bij elkaar op
            kwadraten = kwadraten + c;
        }


        double gemkwadraten = kwadraten / length;
        //krijg het gemiddelde van de kwadraten en pak daar de wortel van

        double standaarddeviatie = Math.sqrt(gemkwadraten);


        System.out.println("de standaarddeviatie van " + s.getNaam() + " met studentnummer: " + s.getStudentnummer() + " is : " + standaarddeviatie);

        System.out.println("------------------------------------------");
    }

    public void variantie(Vak v){
        //get length en gemiddelde
        double length = v.cijfers.size();
        Double gem = v.cijfers.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        double kwadraten = 0;

        //loop door alle waardes van de cijfers hashmap
        for (Double value : v.cijfers.values()){
            double a = value;
            //loop door alle waardes heen
            double b = a - gem;
            //krijg de deviaties
            double c = b * b;

            //tel alle kwadraten bij elkaar op
            kwadraten = kwadraten + c;
        }

        //krijg het gemiddelde en dus de variantie van alle kwadraten
        double variantie = kwadraten / length;


        System.out.println("de variatie van " + v.getModulecode() + "is: " + variantie);

        System.out.println("------------------------------------------");
    }


    public void vergelijkgeslacht(Vak c){

        System.out.println("vergelijken van man en vrouw gemiddelde bij vak " + c.getModulecode());

        Iterator it = c.cijfers.entrySet().iterator();

        double aantalman = 0;
        double totalman = 0;
        double totalvrouw = 0;
        double aantalvrouw = 0;

        //loop door alle waardes heen
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();

            //define welke datatypes er in de map staan om hier mee te werken
            Student student = (Student) pair.getKey();
            double cijfer = (double) pair.getValue();

            //als de student een man is
            if(Objects.equals(student.getGeslacht(), "man")){

                //tel op bij totaal aantal mannen voor formule
                aantalman ++;

                //tel alle cijfers van mannen bij elkaar op
                totalman = totalman + cijfer;

            }else if(Objects.equals(student.getGeslacht(), "vrouw")){ //als de student een vrouw is
                //tel op bij totaal aantal vrouwen voor formule
                aantalvrouw ++;

                //tel alle cijfers bij elkaar op
                totalvrouw = totalvrouw + cijfer;

            }else{//als de student een ander geslacht is
                System.out.println("geslacht " + student.getGeslacht() + " van " + student.getNaam() + " is geen man of vrouw en kan niet worden vergeleken");
            }

        }

        //bereken gemiddelde per geslacht
        double gemvrouw = totalvrouw / aantalvrouw;
        double gemman = totalman / aantalman;


        System.out.println("het gemmidelde van man : " + gemman + " het gemiddelde van vrouw : " + gemvrouw );

        //bepaal wie hoger gemiddelde heeft
        if(gemvrouw > gemman){
            System.out.println("vrouwen hebben een hoger gemiddelde");
        }else if(gemman > gemvrouw){
            System.out.println("mannen hebben een hoger gemiddelde");
        }else if(gemman == gemvrouw){
            System.out.println("het gemiddelde van mannen en vrouwen is hetzelfde");
        }

        System.out.println("------------------------------------------");

    }


}
