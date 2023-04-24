public class Vrachtwagen extends Voertuig{



    public Vrachtwagen(int i, Kade van, Schip schip) {     //constructor met alle classes en data wat de kraan nodig heeft

        this.id = i;
        this.Kade = van;
        this.Schip = schip;

    }
    public void run() {

        while(Schip.opslag.size() > 0 || Kade.opslag.size() > 0) { //zolang het schip niet leeg is of de kade niet leeg is

            System.out.println(vrachtautocolor + "vrachtauto" + this.id + " staat op wacht"); //wanner de vrachtauto op wacht staat

            container = Kade.removecontainer(); //haal op welke container er op de kade staat als er 1 staat en return deze en verwijder hem van de kade

            System.out.println(vrachtautocolor + "vrachtauto" + this.id + " heeft " + container.info() + vrachtautocolor + " ingeladen" + "\r\n" + "vrachtauto" + this.id + " rijdt weg met : " + container.info() );
            //print welke container er in de vrachtauto is ingeladen
            //de auto rijdt weg
            //samen in 1 println want anders komen er mischien andere prints tussen te staan

            int randomwacht = (int) Math.floor(Math.random() * (6000)+2000); //sleep voor 2-8 seconden om te simuleren hoelang de vrachtauto doet over het weg brengen van de container
            //als de tijd lager is dan dit zal er op de kade altijd 1 / 0 containers staan
            try {
                Thread.sleep(randomwacht);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(vrachtautocolor + "vrachtauto" + this.id + " heeft weg gebracht : " + container.info());//waneer de auto klaar is met weg brengen


            if(Schip.opslag.size() == 0 && Kade.opslag.size() == 0){
                break;
            }//break while wanneer beide leeg zijn

        }

        System.out.println(vrachtautocolor + "chaufeur van vrachtauto" + this.id + " is klaar en gaat naar huis");//alle containers zijn weg en de vrachtwagens zijn klaar


    }


}
