import java.util.*;

public class App {
    public static void main(String[] args){

        //maak schip
        Schip Schip1 = new Schip();
        Schip1.setCapaciteit(100);

        //maak kade
        Kade Kade1 = new Kade();
        Kade1.setCapaciteit(5);

        int aantalKranen = 2; //2
        int aantalVrachtwagens = 3; //3


        //maak de containers en zet ze op het schip, random normaal warm of koud
        for (int i = 0; i < Schip1.getCapaciteit(); i++) {
            int containerGen = (int)Math.floor(Math.random()*(3));
            if(containerGen == 0){
                Schip1.opslag.add(new Container(i));
            }else if(containerGen == 1){
                Schip1.opslag.add(new HotContainer(i));
            }else if(containerGen == 2){
                Schip1.opslag.add(new ColdContainer(i));
            }

        }

        //threadarray voor 2 kranen
        Kraan[] Kranen = new Kraan[aantalKranen];
        for (int i = 0; i < aantalKranen; i++) {
            Kranen[i] = new Kraan(i, Schip1, Kade1);
            Kranen[i].start();
        }


        //threadarray voor de vrachtwagens
        Vrachtwagen[] Vrachtwagens = new Vrachtwagen[aantalVrachtwagens];
        for (int i = 0; i < aantalVrachtwagens; i++) {
            Vrachtwagens[i] = new Vrachtwagen(i, Kade1, Schip1);
            Vrachtwagens[i].start();
        }








    }
}
