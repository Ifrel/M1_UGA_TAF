package fr.uga.im2ag.m1info.tp1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Vertex, List<Edge>> graphe;

    public Graph() {
        graphe = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        if (!graphe.containsKey(vertex)) {
            graphe.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(Vertex source, Vertex target, int poids) {
        addVertex(source);
        addVertex(target);
        graphe.get(source).add(new Edge(source, target, poids));
    }

    public List<Edge> getEdgesFrom(Vertex source) {
        List<Edge> edges = graphe.get(source);
        if (edges == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(edges);
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(graphe.keySet());
    }

    public void printGraph(PrintStream out) {
        out.println("digraph {");
        for (Vertex vertex : graphe.keySet()) {
            for (Edge edge : graphe.get(vertex)) {
                out.println("\t" + edge);
            }
        }
        for (Vertex vertex : graphe.keySet()) {
            if (graphe.get(vertex).isEmpty()) {
                out.println("\t" + vertex + ";");
            }
        }
        out.println("}");
    }
}
