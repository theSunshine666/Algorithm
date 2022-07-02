package com.company.wq.datastructure.graph;

import java.util.Iterator;

public class GraphTraversal {
    ListGraph listGraph;
    boolean[] visited;
    public GraphTraversal(ListGraph listGraph){
        this.listGraph = listGraph;
        visited = new boolean[listGraph.graphs.size()];
    }
    public void DFSTraversal(int v){
        if (visited[v]){
            return;
        }
        visited[v] = true;
        System.out.println(v+"->");
        Iterator<Integer> neighbors = listGraph.graphs.get(v).listIterator();
        while(neighbors.hasNext()){
            int nextNode = neighbors.next();
            if (!visited[nextNode]){
                DFSTraversal(nextNode);
            }
        }
    }


}
