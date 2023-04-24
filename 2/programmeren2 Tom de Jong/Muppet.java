public class Muppet {
    private String naam;
    private int leeftijd;
    private Muppet next;

    public Muppet(String naam){
        this.naam = naam;
    }
    public Muppet(String naam, int leeftijd){
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    
    public String getNaam(){
        return naam;
    }
    public void setNaam(String n){
        this.naam = n;
    }
    
    public int getLeeftijd(){
        return leeftijd;
    }
    public void setLeeftijd(int l){
        this.leeftijd = l;
    }

    public Muppet getNext(){
        return next;
    }
    public void setNext(Muppet nx){
        this.next = nx;
    }

    public void print(){
        if(leeftijd == 0){
            System.out.println("naam : " + naam);
        }else {
            System.out.println("naam : " + naam + " leeftijd: " + leeftijd);
        }
    }
}
