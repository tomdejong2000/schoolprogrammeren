public class ColdContainer extends Container{

    //gebruik id uit de parent
    public ColdContainer(int id){
        super(id);
    }
    //functie als een koude container wordt ontkoppeld
    public void ontkoppel(){
        System.out.println(containercolor + "koude container" + id + " uit koelings element" + " van schip" + colorreset);
    }

    //wanneer een koude container wordt gekoppeld
    public void koppel(){
        System.out.println(containercolor + "koude container" + id + " van kade naar koelings element" + " van vrachtauto" + colorreset);
    }

    //return een string met alle informatie over de container
    public String info(){
        String info = containercolor + " Koude container " + id + colorreset;
        return info;
    }

}
