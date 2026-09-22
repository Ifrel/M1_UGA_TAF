package fr.uga.im2ag.m1info.tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EdgeTest {
    @Test
    public void testEdgeCreation() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Edge edge = new Edge(a, b, 3);

        assertEquals(a, edge.getSource());
        assertEquals(b, edge.getTarget());
        assertEquals(3, edge.getPoid());
        assertEquals("A -> B [ label=3 ];", edge.toString());
    }
}
