package Karat;

import java.util.*;

/**
 * Created by amritachowdhury on 8/2/17.
 */
public class commonAncestor {
    Map<Integer, List<Integer>> childParent = new HashMap<>();
    int[][] input = new int[][] {
            {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},//(parent, child}
            {4, 5}, {4, 8}, {8, 9}};

    public  void run() {
        boolean b = hasCommonAncestor(3, 8);
        System.out.println(b);
    }


    private boolean hasCommonAncestor(int x, int y) {
        fillChildParent();
        List<Integer> xAncestors = getAncestors(x);
        List<Integer> yAncestors = getAncestors(y);
        return !Collections.disjoint(xAncestors, yAncestors);
    }

    private List<Integer> getAncestors(int x) {
        List<Integer> xAncestor = new ArrayList<>();
        Queue<Integer> xQueue = new LinkedList<>();
        xQueue.add(x);
        while(!xQueue.isEmpty()) {
            int q = xQueue.poll();
            xAncestor.add(q);
            List<Integer> list = childParent.get(q);
            if (list == null || list.size() == 0) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                xQueue.add(list.get(i));
            }
        }
        return xAncestor;
    }


    private void fillChildParent() {
        for (int i = 0; i < input.length; i++) {
            int parent = input[i][0];
            int child = input[i][1];
            List<Integer> p = childParent.get(child);
            p = p == null ? new ArrayList<Integer>() : p;
            p.add(parent);
            childParent.put(child, p);
        }
    }
}
