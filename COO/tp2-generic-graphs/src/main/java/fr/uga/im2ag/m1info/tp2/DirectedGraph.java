package fr.uga.im2ag.m1info.tp2;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph implements GraphInterface {

    private final Graph graphe;

    public DirectedGraph(Graph graphe) {
        this.graphe = graphe;
    }

   @Override
   public List<Edge> getEdgesFrom(Vertex source) {
       List<Edge> edges = graphe.getEdges(source);
       if (edges == null) {
           return new ArrayList<>();
       }
       return new ArrayList<>(edges);
   }

}
