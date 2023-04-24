public class HotContainer extends Container{

    //gebruik id uit de parent
    public HotContainer(int id){
        super(id);
    }

    //functie wanneer warme container moet worden ontkoppeld
    public void ontkoppel(){
        System.out.println(containercolor + "Hot container" + id + " uit warmte element" + " van schip" + colorreset);
    }

    //functie wanneer warme container moet worden gekoppeld
    public void koppel(){
        System.out.println(containercolor + "Hot container" + id + " van kade naar warmte element" + " van vrachtauto" + colorreset);
    }

    //return een string met alle informatie over de container
    public String info(){
        String info = containercolor + " hot container " + id + colorreset;
        return info;
    }
}
