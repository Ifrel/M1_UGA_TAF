package fr.uga.im2ag.m1info.tp2;

import java.util.List;

public interface GraphInterface {

    /**
     * Retourne la liste des arêtes sortantes d'un sommet.
     *
     * @param source Le sommet source
     * @return la liste des arêtes sortantes du sommet source
     */
    public List<Edge> getEdgesFrom(Vertex source);

    

}
