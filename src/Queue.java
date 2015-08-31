/**
 * Created by achowdhury on 5/29/2015.
 */
public class Queue {
    public int[] queue = new int [3];
    public int rear = -1 ;
    public int front = -1;

    public void Push(int element)
    {
        if(!OverFlow())
        {
            rear ++;
            queue[rear] = element;
            if(front == -1)
                front ++ ;
            Display();
        }
        else
            System.out.println("OverFlow !!");
    }
    public int Pop()
    {
        if(!Underflow())
        {
            int popped = queue[front];
            queue[front]=0;
            front ++ ;
            System.out.println(popped);
            Display();
            return popped ;
        }
        else return -9999;
    }

    public boolean Underflow()
    {
        if(front == -1 || front > rear)
            return true;
        else
            return false;
    }

    public boolean OverFlow()
    {
        if(rear == queue.length - 1)
            return true;
        else return false;
    }

    public void Display()
    {
        for(int i = 0 ; i < queue.length ; i++)
            System.out.println(queue[i]);
        System.out.println(front);
        System.out.println(rear);
        System.out.println("##################");
    }

    public  void CallQueue()
    {
        Queue q = new Queue();
        int popped ;
        popped = q.Pop();
        q.Push(1);
        popped = q.Pop();
        q.Push(1);
        q.Push(2);
        q.Push(3);
        popped = q.Pop();
        popped = q.Pop();
        popped = q.Pop();
    }
}
