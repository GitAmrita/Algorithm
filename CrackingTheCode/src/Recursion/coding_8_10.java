package Recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by amritachowdhury on 5/6/17.
 */
public class coding_8_10 {
    Vertex v0, v1, v2, v3, v4, v5, v6;
    List<Vertex> screen;
    public class Vertex {
        public int value;
        public String color;
        public boolean visited;
        public List<Vertex> edges;

        public Vertex(int value, String color) {
            this.value = value;
            this.color = color;
            this.visited = false;
            this.edges = null;
        }
    }

    public void fillColor() {
        getColorGraph();
        for (Vertex point : screen) {
            if (!point.visited) {
                showScreen(point);
            }
        }
        resetVisited();
        fillColor(v2, "red");
    }

    private void getColorGraph() {
        v0 = new Vertex(0, "blue");
        v1 = new Vertex(1, "blue");
        v2 = new Vertex(2, "blue");
        v3 = new Vertex(3, "blue");
        v0.edges = new LinkedList<>(Arrays.asList(v1, v2));
        v1.edges = new LinkedList<>(Arrays.asList(v2));
        v2.edges = new LinkedList<>(Arrays.asList(v0, v3));
        v3.edges = new LinkedList<>(Arrays.asList(v3));

        v4 = new Vertex(4, "yellow");
        v5 = new Vertex(5, "yellow");
        v4.edges = new LinkedList<>(Arrays.asList(v5));
        v5.edges = new LinkedList<>(Arrays.asList(v4));

        v6 = new Vertex(6, "white");
        v6.edges = new LinkedList<>();
        screen = new LinkedList<>(Arrays.asList(v2, v0, v1, v3, v4, v5, v6));
    }

    private void resetVisited() {
        v0.visited = false;
        v1.visited = false;
        v2.visited = false;
        v3.visited = false;
        v4.visited = false;
        v5.visited = false;
        v6.visited = false;
    }

    private void fillColor(Vertex point, String newColor) {
        Queue<Vertex> queue = new LinkedList<>();
        point.visited = true;
        point.color = newColor;
        System.out.println(point.value + ": " + point.color);
        queue.add(point);
        while (!queue.isEmpty()) {
            List<Vertex> edges = queue.poll().edges;
            for (Vertex v : edges) {
                if (!v.visited) {
                    v.visited = true;
                    v.color = newColor;
                    System.out.println(v.value + ": " + v.color);
                    queue.add(v);
                }

            }
        }
    }

    private void showScreen(Vertex point) {
        Queue<Vertex> queue = new LinkedList<>();
        point.visited = true;
        System.out.println(point.value + ": " + point.color);
        queue.add(point);
        while (!queue.isEmpty()) {
            List<Vertex> edges = queue.poll().edges;
            for (Vertex v : edges) {
                if (!v.visited) {
                    v.visited = true;
                    System.out.println(v.value + ": " + v.color);
                    queue.add(v);
                }

            }
        }
    }
}
