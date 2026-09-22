package fr.uga.im2ag.m1info.tp2;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraSolver {
    private final Graph graph;

    public DijkstraSolver(Graph graph) {
        this.graph = graph;
    }


    // https://fr.wikipedia.org/wiki/Algorithme_de_Dijkstra
    public Path getPlusCoursChemein(Vertex source, Vertex target) {
        PriorityQueue<Path> queue = new PriorityQueue<>();
        Set<Vertex> visite = new HashSet<>();

        queue.add(new Path(source));

        while (!queue.isEmpty()) {
            Path current = queue.poll();
            Vertex last = current.getSommets().get(current.getSommets().size() - 1);

            if (visite.contains(last)) {
                continue;
            }

            visite.add(last);

            if (last.equals(target)) {
                return current;
            }

            for (Edge edge : graph.getEdgesFrom(last)) {
                Vertex suivant = edge.getTarget();
                if (!visite.contains(suivant)) {
                    queue.add(new Path(current, edge));
                }
            }
        }

        return null;
    }


}
