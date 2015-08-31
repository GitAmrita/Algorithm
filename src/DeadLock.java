/**
 * Created by achowdhury on 7/12/2015.
 */
//http://www.java2novice.com/java-interview-programs/thread-deadlock/
public class DeadLock {
    String str1 = "Read Deadlock ";
    String str2 = "Write Deadlock ";

    Thread thd1 = new Thread("FirstThread"){
        public void run(){
            while(true){
                synchronized(str1){
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex){
                        System.err.println(ex.getMessage());
                    }
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };

    Thread thd2 = new Thread("SecondThread"){
        public void run(){
            while(true){
                synchronized(str2){
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex){
                        System.err.println(ex.getMessage());
                    }
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };

    public void CreateDeadLock(){
        thd1.start();
        thd2.start();
    }
}
