public class Kade extends Opslag{


    public synchronized Container removecontainer(){
        Container container;

        while(this.opslag.size() == 0) {
            try {
                wait(); //zolang kade leeg is wacht
            } catch (InterruptedException e) {
                System.out.println("fout met removecontainer");
            }
        }

        try {//zodat de auto niet de container pakt voordat de update met aantal containers op kade kan worden uitgeprint
            Thread.sleep(200);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        notifyAll(); //maak de threads wakker

        container = this.opslag.remove(0); //returned de 1e container en verwijderd hem uit de arraylist van de kade
        container.koppel(); //ontkoppel uit de warmte of koude element wanneer nodig
        System.out.println(kadecolor + "aantal containers op kade :" + this.opslag.size() + "/5");
        return container;

    }

    public synchronized void addcontainer(Container c){
        Container container = c;


        while(this.opslag.size() == Capaciteit) { //zolang de kade vol zit wacht
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("fout met addcontainer");
            }
        }
        //als de kade niet vol is voeg container c toe
        this.opslag.add(container);
        System.out.println(kadecolor + "aantal containers op kade :" + this.opslag.size() + "/5");

        notifyAll(); //maak de threads wakker


    }


}
