import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
//http://javarevisited.blogspot.sg/2012/02/producer-consumer-design-pattern-with.html
/**
 * Created by achowdhury on 7/12/2015.
 */
public class ProducerConsumerPattern {

    public class Producer implements Runnable{

        private final BlockingQueue sharedResource ;
        public Producer(BlockingQueue sharedResource) {
            this.sharedResource = sharedResource;
        }
        @Override
        public void run(){
            for(int i=0; i<10; i++){
                try {
                    System.out.println("Produced: " + i);
                    sharedResource.put(i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public class Consumer implements Runnable{
        private final BlockingQueue sharedResource ;
        public Consumer(BlockingQueue sharedResource) {
            this.sharedResource = sharedResource;
        }
        @Override
        public void run(){
            while(true){
                try {
                    System.out.println("Consumed: "+ sharedResource.take());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void CreateThread(){
        //creating shared object
        java.util.concurrent.BlockingDeque<Integer> sharedResource = new LinkedBlockingDeque<Integer>();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedResource));
        Thread consThread = new Thread(new Consumer(sharedResource));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }
}
