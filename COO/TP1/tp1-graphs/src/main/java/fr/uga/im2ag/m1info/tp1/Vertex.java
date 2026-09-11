package fr.uga.im2ag.m1info.tp1;
import java.util.Objects;
public class Vertex {
    private final String label;
    Vertex(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ( !(other instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) other;
        return label.equals(vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}