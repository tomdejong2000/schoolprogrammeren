public class App {

    public static void main(String[] args) {
        Vak tes1 = new Vak("tintes1", 1);
        Vak tes2 = new Vak("tintes2", 1);
        Vak pro1 = new Vak("pro1", 1);
        Vak pro2 = new Vak("pro2", 1);
        Vak pro3 = new Vak("pro3", 1);
        Administratie Administratie = new Administratie();

        Student klaas69 = new Student(69, "klaas", "man", 1, "it");
        Student henk145 = new Student(145, "henk", "man", 1, "it");
        Student jasmijn14 = new Student(14, "jasmijn", "vrouw", 1, "it");
        Student karlijn34 = new Student(34, "karlijn", "vrouw", 1, "it");
        Student willemijn18 = new Student(18, "willemijn", "vrouw", 1, "it");


        klaas69.AddCijfer(tes1, 4.0);
        klaas69.AddCijfer(tes2, 6.9);
        klaas69.AddCijfer(pro1, 5.6);
        klaas69.AddCijfer(pro2, 5.9);
        klaas69.AddCijfer(pro3, 9.1);



        henk145.AddCijfer(tes1, 5.3);
        henk145.AddCijfer(tes2, 6.3);
        henk145.AddCijfer(pro1, 1.3);
        henk145.AddCijfer(pro2, 8.3);
        henk145.AddCijfer(pro3, 9.3);


        jasmijn14.AddCijfer(tes1, 3.2);
        jasmijn14.AddCijfer(tes2, 6.2);
        jasmijn14.AddCijfer(pro1, 8.1);
        jasmijn14.AddCijfer(pro2, 7.2);
        jasmijn14.AddCijfer(pro2, 5.7);

        karlijn34.AddCijfer(tes1, 5.7);
        karlijn34.AddCijfer(tes2, 10.0);
        karlijn34.AddCijfer(pro1, 5.0);
        karlijn34.AddCijfer(pro2, 9.1);
        karlijn34.AddCijfer(pro3, 4.9);

        willemijn18.AddCijfer(tes1, 6.9);
        willemijn18.AddCijfer(tes2, 4.9);
        willemijn18.AddCijfer(pro1, 6.9);
        willemijn18.AddCijfer(pro2, 8.0);
        willemijn18.AddCijfer(pro3, 6.5);

        //administratie functies

        //Administratie.behaald(tes1);
        //Administratie.behaald(klaas69);

        //Administratie.nietbehaald(klaas69);
        //Administratie.gemiddelde(klaas69);
        //Administratie.gemiddelde(tes1);

        //Administratie.vergelijkgeslacht(tes1);
        //Administratie.optellen(klaas69);
        //Administratie.standaarddeviatie(klaas69);
        Administratie.variantie(tes1);


    }
}
