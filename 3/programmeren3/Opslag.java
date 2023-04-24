import java.util.ArrayList;

public abstract class Opslag {
        public static final String containercolor = "\u001B[32m";
        public static final String kadecolor = "\u001B[36m";
        protected int Capaciteit;


        //de max capaciteit
        public int getCapaciteit() {
                return Capaciteit;
        }

        public void setCapaciteit(int capaciteit) {
                Capaciteit = capaciteit;
        }

        //arraylist voor de kade en het schip
        public ArrayList<Container> opslag = new ArrayList<Container>();

}
