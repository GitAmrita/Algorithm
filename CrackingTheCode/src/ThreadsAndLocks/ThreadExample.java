package ThreadsAndLocks;

/**
 * Created by amritachowdhury on 7/24/17.
 */
public class ThreadExample extends Thread {

    public void run() {
        int count = 0;
        System.out.println("thread start");
        try {
            while (count <= 5) {
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException ex) {
            System.out.println("interrupted");
        }
        System.out.println("thread end");
    }
}
