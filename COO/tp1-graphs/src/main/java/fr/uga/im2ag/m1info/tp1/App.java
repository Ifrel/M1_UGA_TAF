package fr.uga.im2ag.m1info.tp1;

public class App {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        Graph graph = new Graph();
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addEdge(a, b, 3);
        graph.addEdge(b, c, 2);
        graph.addEdge(a, c, 10);

        graph.printGraph(System.out);
    }
}
