public class App{

    public static void main(String[] args){
        Muppet Animal = new Muppet("Animal", 9);
        Muppet Beaker = new Muppet("Beaker", 4);
        Muppet Gonzo = new Muppet("Gonzo", 21);
        Muppet Kermit = new Muppet("Kermit", 1);
        Muppet MissPiggy = new Muppet("MissPiggy", 16);
        Muppet SwedishChef = new Muppet("SwedishChef", 7);

        LinkedList list = new LinkedList();

        /*
        list.pop(2);
        list.printList();
        */


        list.push(Animal, 1);
        list.push(Beaker, 2);
        list.push(Gonzo, 3);
        list.push(Kermit, 4);
        list.push(MissPiggy, 5);
        list.push(SwedishChef, 6);


        /*
        list.printList();
        */

        list.push(list.pop("SwedishChef"),1);
        list.printList();

        list.peek("SwedishChef");




    }

}