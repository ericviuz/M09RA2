public class Futbolista extends Thread {
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT =  0.5f;
    
    private int ngols;
    private int ntirades;

    public Futbolista(String nombre){
        super(nombre);
        this.ngols = 0;
        this.ntirades = 0;

    }
 
    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public static void main(String[] args) throws InterruptedException {
        String[] nombres = {
                            "Piqué",
                            "Vinicius",
                            "Torres",
                            "Ramos",
                            "Ronaldo",
                            "Lewan",
                            "Belli",
                            "Arnau",
                            "Aspas",
                            "Messi",
                            "MBapé"
                            };

        Futbolista jugadores[] = new Futbolista[NUM_JUGADORS];                   
        for (int i = 0; i < nombres.length; i++) {
            jugadores[i] = new Futbolista(nombres[i]);
        }
        
        System.out.println("Inici dels xuts --------------");

        for (Futbolista f : jugadores) {
            f.start();
        }

        for (Futbolista f : jugadores) {
            f.join();
        }
        System.out.println("Fi dels xuts ------------------");
        System.out.println("--- Estadistiques ----");

        for (int i =0; i<jugadores.length;i++) {
            System.out.printf("%-10s -> %d gols%n",jugadores[i].getName(),jugadores[i].getNgols());    
        }

    }

}
