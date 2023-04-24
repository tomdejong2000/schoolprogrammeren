public class LinkedList{
    private int size = 0;               //totale grote van
    private Muppet start = null;

    public LinkedList(Muppet begin){        //constuctor om een start muppet aantegeven
        start = begin;
        size ++;
    }

    public LinkedList(){            //constructor voor geen start
    }


    public void push(Muppet m, int p){ //stopt muppet m op positie p
        Muppet current = start;
        Muppet previous = null;
        if(m == null){   //check of er een muppet is meegeven, vooral als je een verkeerde return value probeert te poppen
            System.out.println("dit kan je niet pushen");
        }else{
        if(p < 1){ //check of je een positie onder 1 probeert te poppen
        System.out.println(p + " is een negatief getal en kan je niet pushen");
        }else{
            if(start == null){               //als er nog geen muppet op start is wordt hij er hier opgezet 
                start = m;
                size ++;
            }
            else if(start.getNext() == null){  //als de start geen next heeft zet het element als next dus als 2e
                start.setNext(m);
                size ++;
            }
            else if(p == 1){   //als er naar positie 1 gepushed wordt zet de next van deze muppet de oude start
                m.setNext(start);
                start = m;
                size ++;
            }

            else if(start.getNext() != null){
                
                if(p > size){  //als p groter is dan size stop hem achter in de lijst
                
                    while(current.getNext() != null){
                        current = current.getNext();        
                    }
                    
                    current.setNext(m);
                    size ++;

                }else if(p <= size){  //als p kleiner is dan size loop hem tot hij bij de juiste positie komt en stop de m in de previous setnext en zet de current in m setnext

                    for(int i = 1; i < p; i++){
                    previous = current;
                    current = current.getNext();
                    previous.setNext(m);

                    m.setNext(current);
                    size ++;
                    }
                }
            }
        }
    }
    }   

        
    public Muppet pop(int p){   //verwijder de puppet op positie p, laat zien welke verwijderd is en return deze
        
        Muppet previous = null;
        Muppet current = start;
               
            if(p > size || p < 1){
                System.out.println(p + " is geen goede positie om te poppen");   //als je een positie groter dan de size of kleiner dan 1wil poppen wat niet kan
                return null;
            }
                
            else if(p == 1){
                start = start.getNext();   //als je positie 1 wil poppen maak nummer 2 de nieuwe start
                size--;

                System.out.println("--------------------------");
                    System.out.println("deze muppet is gepopped:");
                    current.print();
                    System.out.println("--------------------------");
                    
                    return current;

            }
            else{
                
                for(int i = 1; i < p; i++){  //als p niet het eerste element is loop door de elementen tot je bij de positie komt die je wil poppen
                    previous = current;
                    current =current.getNext();
                }
                System.out.println("--------------------------");
                System.out.println("deze muppet is gepopped:");
                current.print();
                System.out.println("--------------------------");
                    
                previous.setNext(current.getNext());    //zet de next van de muppet 1 plaats voor de gepopte muppet naar de next van de gepopte muppet
                size--;
                    
                return current;
                    
            }
    }

    public Muppet pop(String s){  //verwijder de muppet op naam laat zien welke verwijderd is en return deze
    
        Muppet previous = null;
        Muppet current = start;
        if(start == null){ //als de list leeg is
            System.out.println("deze list is leeg, je kan niks poppen");
        }else {
            if (current.getNaam() == s) {   //als je de start muppet wil poppen

                System.out.println("--------------------------");
                System.out.println("deze muppet is gepopped:");
                current.print();
                System.out.println("--------------------------");
                start = start.getNext();
                size--;
            } else {

                int countpop = 0;    //telt het aantal keer dat er naar een nieuwe muppet is gegaan
                while (current.getNaam() != s) {

                    previous = current;
                    current = current.getNext();
                    countpop++;                    //elke keer als je checked voor naam tel 1 op

                    if (countpop >= size) {   //als er evenveel of meer keer is gechecked dan lengte van de lijst zijn de namen op en is de naam dus niet in de lijst
                        System.out.println("--------------------------");
                        System.out.println("naam bestaat niet en kan niet gepopt worden");
                        System.out.println("--------------------------");

                        break;
                    } else if (current.getNaam() == s) {    //als naam in lijst zit print deze naam
                        System.out.println("--------------------------");
                        System.out.println("deze muppet is gepopped:");
                        current.print();
                        System.out.println("--------------------------");
                        previous.setNext(current.getNext()); //zet de next van de vorige muppet op de next van de muppet die gepopt wordt
                        size--;
                        break;

                    }
                }
            }
        }
            return current; 
    }


    public Muppet peek(String s) { //peek voor naam
        Muppet current = start;
        int peekpos = 0;

        if(start == null) { //als de list leeg is
            System.out.println("deze list is leeg, je kan niks peeken");
        }else {
            for (int i = 1; i < size; i++) {  //loopen tot i kleiner is dan size en je bij de positie bent die je wilt zien
                peekpos = i;   //bij elke check tel 1 op om de positie te kunnen zien en later te kunnen printen
                if (current.getNaam() == s) {
                    break;      //als naam gevonden is break uit de loop
                }

                current = current.getNext();
            }

            if (current.getNaam() != s) {  //als de naam niet bestaat
                System.out.println("--------------------------");
                System.out.println(s + " bestaat niet en kan niet gepeeked worden");
                System.out.println("--------------------------");
                return null;
            } else { //als de naam er wel in staat
                System.out.println("--------------------------");
                System.out.println("peek :");
                current.print();
                System.out.println("positie : " + peekpos);
                System.out.println("--------------------------");
                return current;
            }
        }
        return current;
    }


    public Muppet peek(int p){
        Muppet current = start;    
        if(p < 1){  //als n lager is dan 1 wat niet mag
            System.out.println("--------------------------");
            System.out.println(p + " is geen positie om te peeken");
            System.out.println("--------------------------");
        }
        else{
          
            if(p > size){  //als n groter is dan de size van de list  en dus niet mogelijk is om te peeken
                
                System.out.println("--------------------------");
                System.out.println(p + " is geen positie om te peeken");
                System.out.println("--------------------------");

                }
            else{
                for(int i = 1; i < p; i++){      //gaat door alle muppets in de list totdat hij aangekomen is bij de juiste plek
        
                    current = current.getNext();
                }
                System.out.println("--------------------------");
                System.out.println("peek: ");
                current.print();
                System.out.println("--------------------------");

            }
        }
        return current;
    }

    public int size(){   //de size van de list
        int total = size;
        System.out.println("--------------------------");
        System.out.println(" size van deze linked list : " + total);
        System.out.println("--------------------------");

        return total;
    }

    public void printList(){ //print de hele lijst uit
        if (start == null){ //als er geen start is en dus de lijst leeg is
            System.out.println("--------------------------");
            System.out.println("deze linkedlist is leeg");
            System.out.println("--------------------------");

        }else{
                System.out.println("complete lijst: ");
                Muppet current = start;
                
                current.print();
                   
                while (current.getNext() != null) {

                    current = current.getNext(); //zolang de muppet een next heeft blij loopen en muppets uitprinten

                    current.print();

                if(current.getNext() == null){//als de muppet geen next heeft hebben we het einde berijkt en breek de loop
                    break;
                    }
                }
                
            System.out.println("de size van de list :" + size);
            }


        }

    }