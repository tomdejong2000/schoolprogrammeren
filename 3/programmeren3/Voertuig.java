import java.util.*;

public abstract class Voertuig extends Thread{

    //variabelen voor alle voertuigen
    int id;
    Schip Schip;
    Kade Kade;
    Container container;

    //colors om cmd duidelijker te maken
    public static final String schipcolor = "\u001B[33m";
    public static final String colorreset = "\u001B[0m";
    public static final String kraancolor = "\u001B[31m";
    public static final String containercolor = "\u001B[32m";
    public static final String vrachtautocolor = "\u001B[35m";
    public static final String kadecolor = "\u001B[36m";



}
