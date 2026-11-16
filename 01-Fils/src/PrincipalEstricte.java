
import java.util.concurrent.Semaphore;

public class PrincipalEstricte {

    public static void main(String[] args) {
        Semaphore tornJuan = new Semaphore(1);
        Semaphore tornPepe = new Semaphore(0);

        Fil juan = new Fil(
            "Juan", Thread.NORM_PRIORITY, 1, tornJuan, tornPepe
        );

        Fil pepe = new Fil(
            "Pepe", Thread.NORM_PRIORITY, 1, tornPepe, tornJuan
        );

        System.out.println("Termina thread main");

        juan.start();
        pepe.start();
    }
}