public class Futbolista extends Thread {
    private final int NUM_JUGADORS = 11;
    private final int NUM_TIRADES = 20;
    private final float PROBABILITAT =  0.5f;
    
    private int ngols;
    private int ntirades;

    public Futbolista(String nombre,int ngols, int ntirades){
        super(nombre);
        this.ngols = 0;
        this.ntirades = 0;

    }
 
    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            
        }
    }
    public static void main(String[] args) {
        

    }

}
