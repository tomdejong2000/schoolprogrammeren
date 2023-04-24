import static java.lang.Thread.currentThread;

import java.util.concurrent.TimeUnit;
import java.util.*;

public class Kraan extends Voertuig {





    public Kraan(int i, Schip van, Kade naar) {     //constructor met alle classes en data wat de kraan nodig heeft

        this.id = i;
        this.Schip = van;
        this.Kade = naar;

    }





    public void run() { //run van de thread

        while (Schip.opslag.size() > 0) { //zolang het schip meer dan 0 container in de opslag heeft

            try {
                int randomsleepstart = (int) Math.floor(Math.random() * (300));  //zodat niet beide threads precies tegerlijk beginnen
                Thread.sleep(randomsleepstart);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(kraancolor + "kraan" + this.id + " staat op wacht"); //wanneer een kraan staat te wachten op een taak
            container = Schip.removecontainer(); //krijg de eerste container van het schip en verwijder hem van schip
            System.out.println(kraancolor +"kraan" + this.id + " verplaatst container: " + container.info()); //laat zien welke container je hebt gepakt

            System.out.println(schipcolor + "aantal containers op schip :" + Schip.opslag.size() + colorreset); //geef update hoeveel container er op het schip staan nadat je er 1 hebt verwijderd


            int randomwacht = (int) Math.floor(Math.random() * (5000) + 1000); //random duur tussen 1 en 6 seconden
            try {
                Thread.sleep(randomwacht);  //thread slaapt voor 1-6 seconden om de tijd dat het kost om de container te verplaatsen te simuleren
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(kraancolor + "kraan" + this.id + " zet nu op kade container: " + container.info() );
            Kade.addcontainer(container); //als tijd over is voeg de container toe aan de kade

            //print wanneer de kraan de container op de kade zet


        }

        System.out.println(kraancolor + "bestuurder van kraan" + this.id + " is klaar en gaat naar huis"); //waneer alle container van het schip zijn verplaatst naar de kade is de kraan klaar

    }
}
