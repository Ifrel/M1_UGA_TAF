package fr.uga.im2ag.m1info.tp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path implements Comparable<Path> {
    private final List<Vertex> sommets;
    private final int poid;

    public Path(Vertex source) {
        sommets = new ArrayList<>();
        sommets.add(source);
        poid = 0;
    }

    public Path(Path chemin, Edge edge) {
        if (!chemin.getDernierSomment().equals(edge.getSource())) {
            throw new RuntimeException("La source de l'arête doit être le dernier sommet du chemin");
        }

        sommets = new ArrayList<>(chemin.sommets);
        sommets.add(edge.getTarget());
        poid = chemin.poid + edge.getPoid();
    }

    public List<Vertex> getSommets() {
        return Collections.unmodifiableList(sommets);
    }

    public int getPoid() {
        return poid;
    }

    private Vertex getDernierSomment() {
        return sommets.get(sommets.size() - 1);
    }

    @Override
    public int compareTo(Path p) {
        int comp = Integer.compare(poid, p.poid);
        if (comp != 0) {
            return comp;
        }

        comp = Integer.compare(sommets.size(), p.sommets.size());
        if (comp != 0) {
            return comp;
        }

        for (int i = 0; i < sommets.size(); i++) {
            comp = sommets.get(i).toString().compareTo(p.sommets.get(i).toString());
            if (comp != 0) {
                return comp;
            }
        }

        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Path)) {
            return false;
        }
        Path path = (Path) other;
        return poid == path.poid && sommets.equals(path.sommets);
    }

    @Override
    public int hashCode() {
        return 17 * sommets.hashCode() + poid;
    }

    @Override
    public String toString() {
        return sommets + " (poids=" + poid + ")";
    }
}
