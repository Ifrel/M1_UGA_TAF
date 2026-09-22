package fr.uga.im2ag.m1info.tp2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void testAddVertex() {
        Graph graph = new Graph();
        Vertex a1 = new Vertex("A");
        Vertex a2 = new Vertex("A");
        Vertex b = new Vertex("B");

        graph.addVertex(a1);
        graph.addVertex(a2);
        graph.addVertex(b);

        List<Vertex> vertices = graph.getVertices();
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains(a1));
        assertTrue(vertices.contains(b));
    }

    @Test
    public void testAddEdgeAddsMissingVertices() {
        Graph graph = new Graph();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");

        graph.addEdge(a, b, 3);

        assertEquals(2, graph.getVertices().size());
        assertEquals(1, graph.getEdgesFrom(a).size());
        assertEquals(0, graph.getEdgesFrom(b).size());
    }

    @Test
    public void testPrintGraph() {
        Graph graph = new Graph();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addEdge(a, b, 3);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        graph.printGraph(new PrintStream(buffer));
        String output = buffer.toString();

        assertTrue(output.startsWith("digraph {"));
        assertTrue(output.contains("A -> B [ label=3 ];"));
        assertTrue(output.contains("C;"));
        assertTrue(output.trim().endsWith("}"));
    }
}
