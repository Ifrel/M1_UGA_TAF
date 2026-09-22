package fr.uga.im2ag.m1info.tp2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DijkstraSolverTest {
    @Test
    public void testShortestPath() {
        Graph graph = new Graph();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 2);
        graph.addEdge(b, d, 6);
        graph.addEdge(c, d, 1);

        DijkstraSolver solver = new DijkstraSolver(graph);
        Path path = solver.getPlusCoursChemein(a, d);

        assertNotNull(path);
        assertEquals(4, path.getPoid());
        assertEquals(List.of(a, b, c, d), path.getSommets());
    }

    @Test
    public void testNoPath() {
        Graph graph = new Graph();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        graph.addVertex(a);
        graph.addVertex(b);

        DijkstraSolver solver = new DijkstraSolver(graph);
        assertNull(solver.getPlusCoursChemein(a, b));
    }
}
