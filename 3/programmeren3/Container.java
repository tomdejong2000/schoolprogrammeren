public class Container {
    protected int id;
    public static final String containercolor = "\u001B[32m";
    public static final String colorreset = "\u001B[0m";


    public Container(int id){
        this.id = id;
    }

    //normale container hebben geen element om uit de ontkoppelen
    public void ontkoppel(){
        System.out.println(containercolor + "normal container" + id + " van schip af" + colorreset);
    }
    public void koppel(){
        System.out.println(containercolor + "normal container" + id + " van kade naar vrachtauto" + colorreset);
    }

    //return string met alle informatie over container
    public String info(){
        String info = containercolor + " normal container " + id + colorreset;
        return info;
    }


}
