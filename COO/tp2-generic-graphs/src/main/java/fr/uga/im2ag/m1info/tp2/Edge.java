package fr.uga.im2ag.m1info.tp2;

public class Edge {
    private final Vertex ID_SOURCE;
    private final Vertex ID_CIBLE;
    private final int POID;

    public Edge(Vertex ID_SOURCE, Vertex ID_CIBLE, int POID) {
        this.ID_SOURCE = ID_SOURCE;
        this.ID_CIBLE = ID_CIBLE;
        this.POID = POID;
    }

    public Vertex getSource() {
        return ID_SOURCE;
    }

    public Vertex getTarget() {
        return ID_CIBLE;
    }

    public int getPoid() {
        return POID;
    }

    @Override
    public String toString() {
        return ID_SOURCE + " -> " + ID_CIBLE + " [ label=" + POID + " ];";
    }
}
