import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by achowdhury on 6/30/2015.
 */
public class NateroQ3 {
    private static int QUEUE_SIZE = 100;
    private Queue<String> queue = new LinkedList<String>() ;

    public class BlockingQueue{
        Condition isFullCondition;
        Condition isEmptyCondition;
        Lock lock;
        int limit;

        public BlockingQueue() {
            this.limit=QUEUE_SIZE;
            lock = new ReentrantLock();
            isFullCondition = lock.newCondition();
            isEmptyCondition = lock.newCondition();
        }

        public Boolean IsQueueFull(){return queue.size() == QUEUE_SIZE;}
        public Boolean IsQueueEmpty(){return queue.size() == 0;}

        public void Put(String value){
            lock.lock();
            try{
                while(IsQueueFull()){
                    try {
                        isFullCondition.await();
                    } catch (InterruptedException ex) {}
                }
                queue.add(value);
                isEmptyCondition.signalAll();
            }
            finally {
                lock.unlock();
            }
        }

        public String Take(){
            lock.lock();
            try{
                while (IsQueueEmpty()) {
                    try {
                        isEmptyCondition.await();
                    } catch (InterruptedException ex) {}
                }
                String value = queue.poll();
                isFullCondition.signalAll();
                return value;
            }
            finally {
                lock.unlock();
            }
        }
    }

    public void AnswerQ3(){
        BlockingQueue bq = new BlockingQueue();
        bq.Put("test");
        bq.Put("best");
        bq.Put("nest");
        System.out.println(bq.Take());
        System.out.println(bq.Take());
        System.out.println(bq.Take());
        bq.Put("zest");
        System.out.println(bq.Take());
    }
}
