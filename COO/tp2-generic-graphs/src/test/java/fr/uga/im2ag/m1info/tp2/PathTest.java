package fr.uga.im2ag.m1info.tp2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest {
    @Test
    public void testPathFromVertex() {
        Vertex a = new Vertex("A");
        Path path = new Path(a);

        assertEquals(List.of(a), path.getSommets());
        assertEquals(0, path.getPoid());
    }

    @Test
    public void testPathExtension() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Edge edge = new Edge(a, b, 3);
        Path path = new Path(new Path(a), edge);

        assertEquals(List.of(a, b), path.getSommets());
        assertEquals(3, path.getPoid());
    }

    @Test
    public void testInvalidExtension() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Edge edge = new Edge(b, c, 3);

        assertThrows(RuntimeException.class, () -> new Path(new Path(a), edge));
    }

    @Test
    public void testPathIsImmutable() {
        Vertex a = new Vertex("A");
        Path path = new Path(a);

        assertThrows(UnsupportedOperationException.class,
                () -> path.getSommets().add(new Vertex("B")));
    }

    @Test
    public void testCompareTo() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        Path p1 = new Path(new Path(a), new Edge(a, b, 3));
        Path p2 = new Path(new Path(a), new Edge(a, c, 5));
        Path p3 = new Path(new Path(a), new Edge(a, c, 3));

        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p1.compareTo(p3) < 0);
    }
}
