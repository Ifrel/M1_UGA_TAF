package fr.uga.im2ag.m1info.tp1;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;

public class Graph {
    private List<Vertex> vertexList;
    private List<Edge> edges;

    public Graph() {
        vertexList = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        if (vertexList.contains(vertex)) {
            return;
        }
        vertexList.add(vertex);
    }

    public void addEdge(Vertex a, Vertex b, int poid) {
        Edge edge = new Edge(a, b, poid);
        if (edges.contains(edge)) {
            return;
        }
        edges.add(edge);
    }

    public List<Vertex> getVertices() {
        return vertexList;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Edge> getEdgesFrom(Vertex a){
        List<Edge> edgesFromA = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(a)) {
                edgesFromA.add(edge);
            }
        }
        return edgesFromA;
    }
    public void printGraph(PrintStream out) {
        out.println("digraph {");
        for (Edge edge : edges) {
            out.println("\t" +edge);
        }
        out.println("}");
    }
}