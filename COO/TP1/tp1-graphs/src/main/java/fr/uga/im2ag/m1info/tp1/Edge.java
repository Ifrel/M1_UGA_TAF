package fr.uga.im2ag.m1info.tp1;
public class Edge {
    private Vertex ID_SOURCE;
    private Vertex ID_CIBLE;
    private int POID;

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

    public int getWeight() {
        return POID;
    }

    @Override
    public String toString() {
        return ID_SOURCE + " -> " + ID_CIBLE + " [ label=" + POID + " ]";
    }
}