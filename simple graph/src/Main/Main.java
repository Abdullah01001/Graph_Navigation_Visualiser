package Main;

import Graph.Graph;

public class Main
{
    public static void main(String[] args)
    {
        Graph graph = new Graph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addEdge(0,3);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,0);
        graph.addEdge(2,1);
        graph.addEdge(1,0);
        graph.addEdge(3,2);
        graph.addEdge(4,0);
        graph.showPaths(1);
    }
}
