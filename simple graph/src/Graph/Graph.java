package Graph;

import java.util.ArrayList;

public class Graph
{
    int size;
    ArrayList<ArrayList<Edge>> adjacencyList;

    public Graph()
    {
        adjacencyList = new ArrayList<>();
        size = 0;
    }

    public void addVertex()
    {
        ArrayList<Edge> vertex = new ArrayList<>();
        adjacencyList.add(vertex);
        size++;
    }

    public void addEdge(int src , int destination)
    {
        if(src > size - 1 || destination > size - 1)
        {
            System.out.println("One of these vertices does not exist");
        }
        else
        {
            adjacencyList.get(src).add(new Edge(src,destination));
        }
    }

    private void printPaths(ArrayList<Edge> edges)
    {
        for (Edge edge : edges)
        {
            System.out.println(edge.src + " ---> " + edge.destination);
        }

    }

    public void showPaths(int vertex)
    {
        if(vertex > size)
        {
            System.out.println("Vertex does not exist");
        }
        else
        {
            printPaths(adjacencyList.get(vertex));
        }
    }
}
