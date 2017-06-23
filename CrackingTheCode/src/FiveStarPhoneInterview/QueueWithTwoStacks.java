package FiveStarPhoneInterview;

import java.util.Stack;

/**
 * Created by amritachowdhury on 6/7/17.
 */
// https://www.glassdoor.com/Interview/FiveStars-Software-Engineer-Interview-Questions-EI_IE447133.0,9_KO10,27.htm
//Implement a queue with two stacks (enqueue, dequeue, peek)
public class QueueWithTwoStacks {

    Queue queue = new Queue();

    public void run() {
        try {
            enQueue(1); enQueue(2); enQueue(5); enQueue(7);
            int res = deQueue(); System.out.println(res); //1
            res = deQueue(); System.out.println(res); //2
            enQueue(9); enQueue(20);
            res = peek(); System.out.println(res); //5
            enQueue(3); enQueue(4);
            res = deQueue(); System.out.println(res); //5
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private class Queue {
        Stack sIn, sOut;

        public Queue() {
            this.sIn = new Stack();
            this.sOut = new Stack();
        }

        public void enQueue(int number) {
            if (sIn.empty()) {
                popAndPush(sOut, sIn);
            }
            this.sIn.push(number);
        }

        public Integer deQueue() {
            if (isQueueEmpty())
                return null;
            popAndPush(this.sIn, this.sOut);
            Integer poppedVal = (Integer)sOut.pop();
            return poppedVal;
        }

        public Integer peek() {
            if (isQueueEmpty())
                return null;
            popAndPush(this.sIn, this.sOut);
            Integer peekedVal = (Integer)sOut.peek();
            return peekedVal;
        }

        private void popAndPush(Stack popFrom, Stack pushInto) {
            while (!popFrom.empty()) {
                pushInto.push(popFrom.pop());
            }
        }

        private boolean isQueueEmpty() {
            return this.sIn.size() == 0 && this.sOut.size() == 0;
        }
    }

    private void enQueue(int value) {
        queue.enQueue(value);
    }

    private int deQueue() throws Exception{
        Integer value =  queue.deQueue();
        if (value == null) {
            throw  new Exception("The queue is empty");
        }
        else return value;
    }

    private int peek() throws Exception{
        Integer value =  queue.peek();
        if (value == null) {
            throw  new Exception("The queue is empty");
        }
        else return value;
    }
}
