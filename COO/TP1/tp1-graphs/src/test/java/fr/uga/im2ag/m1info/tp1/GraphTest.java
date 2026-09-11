package fr.uga.im2ag.m1info.tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GraphTest {

    @Test
    public void testGraphNoEdges() {
        Graph g = new Graph();
        Vertex a = new Vertex("A");
        g.addVertex(a);
        List<Edge> edges = g.getEdgesFrom(a);
        assertTrue(edges.isEmpty());
    }

    @Test
    public void testAddVertexAndEdges() {
        Graph g = new Graph();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");

        g.addVertex(a);
        g.addVertex(b);
        g.addEdge(a, b, 3);

        List<Edge> edgesFromA = g.getEdgesFrom(a);
        assertEquals(1, edgesFromA.size());
        assertEquals(a, edgesFromA.get(0).getSource());
        assertEquals(b, edgesFromA.get(0).getTarget());
        assertEquals(3, edgesFromA.get(0).getWeight());

        g.printGraph(System.out);
    }

}