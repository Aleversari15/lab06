package it.unibo.generics.graph;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    private final Map<N, Set<N>> edges = new LinkedHashMap<>();

    public GraphImpl(){

    } 
    
    @Override
    public void addNode(final N node) {
        this.edges.put(node, null);
        
    }

    @Override
    public void addEdge(N source, N target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
