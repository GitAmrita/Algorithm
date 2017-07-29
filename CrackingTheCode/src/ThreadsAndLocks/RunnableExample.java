package ThreadsAndLocks;

/**
 * Created by amritachowdhury on 7/24/17.
 */
public class RunnableExample {

    public void run() {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        ThreadExample ins = new ThreadExample();
        ins.start();
    }
}
