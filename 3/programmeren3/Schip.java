import java.util.*;

public class Schip extends Opslag{


    public synchronized Container removecontainer(){
        Container container;

        while (this.opslag.size() == 0){ //zodra de opslag van het schip 0 is wait
            try {
                wait();
            }   catch (InterruptedException e){
                System.out.println("fout met container removen");
            }
        }
        notifyAll();
        //return en verwijder de eerste container op het schip
        container = this.opslag.remove(0);
        //ontkoppel wanneer nodig
        container.ontkoppel();

        return container;

    }
}
