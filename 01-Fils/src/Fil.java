
import java.util.concurrent.Semaphore;

public class Fil extends Thread {

    private final long pausa;
    private final Semaphore torn;
    private final Semaphore seguent;

    private volatile int feina;

    public Fil(String nom, int prioritat) {
        this(nom, prioritat, 0, null, null);
    }

    public Fil(String nom, int prioritat, long pausa,
               Semaphore torn, Semaphore seguent) {
        super(nom);
        setPriority(prioritat);
        this.pausa = pausa;
        this.torn = torn;
        this.seguent = seguent;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 9; i++) {

                if (torn != null) {
                    torn.acquire();
                }

                System.out.println(getName() + " " + i);

                if (seguent != null) {
                    seguent.release();
                }

                if (pausa > 0) {
                    Thread.sleep(pausa);
                } else {
                    for (int comptador = 0; comptador < 1000; comptador++) {
                        feina++;
                    }
                }
            }

            System.out.println("Acaba el fil " + getName());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}