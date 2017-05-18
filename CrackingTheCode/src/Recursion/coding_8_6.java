package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amritachowdhury on 5/1/17.
 */
public class coding_8_6 {
    private List<Integer> A = new ArrayList<>();
    private List<Integer> B = new ArrayList<>();
    private List<Integer> C = new ArrayList<>();

    public void play() {
        A.add(1); A.add(2); A.add(3); A.add(4); A.add(5); A.add(6);
        for (Integer x : A) {
            System.out.println(x);
        }
        System.out.println("########");
        towerOfHanoi(A);
        for (Integer x : C) {
            System.out.println(x);
        }
    }



    private void towerOfHanoi(List<Integer> A) {
        if (A.size() == 1) {
            C.add(A.get(0));
        } else if (A.size() == 2) {
            int smallestNo = A.remove(A.size() - 1);
            B.add(smallestNo);
            C.add(A.get(0));
            C.add(B.get(0));
            B.remove(0);
        } else if (A.size() == 3) {
            C.add(A.remove(A.size() - 1));
            B.add(A.remove(A.size() - 1));
            B.add(C.remove(C.size() - 1));
            C.add(A.remove(A.size() - 1));
            A.add(B.remove(B.size() - 1));
            C.add(B.remove(B.size() - 1));
            C.add(A.remove(A.size() - 1));
        } else {
            int smallestNo = A.remove(A.size() - 1);
            List<Integer> temp = new ArrayList<>();
            temp.add(smallestNo);
            towerOfHanoi(A) ;
            towerOfHanoi(temp);
        }
    }
}
