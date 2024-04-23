package Graph;

import java.util.ArrayList;

public class Graph
{
    int size;
    public ArrayList<ArrayList<Edge>> adjacencyList;

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

    public boolean addEdge(int src , int destination)
    {
        if(src >= 0 && destination >= 0)
        {
            if(src > size - 1 || destination > size - 1)
            {
                return false;
            }
            else
            {
                adjacencyList.get(src).add(new Edge(src,destination));
            }
        }
        return false;
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
        if(vertex >= 0)
        {
            if(vertex > size - 1)
            {
                System.out.println("Vertex does not exist");
            }
            else
            {
                printPaths(adjacencyList.get(vertex));
            }
        }
    }

    public boolean removeEdge(int src, int destination)
    {
        if(src >= 0 && destination >= 0)
        {
            if(src > size - 1 || destination > size - 1)
            {
                return false;
            }
            else
            {
                ArrayList<Edge> edges = adjacencyList.get(src);
                for (int i = 0 ; i < edges.size() ; i++)
                {
                    if(edges.get(i).destination == destination)
                    {
                        edges.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeVertice(int vertice)
    {
        if (vertice < size && vertice >= 0)
        {
            adjacencyList.remove(vertice);
            for (int i = 0 ; i < adjacencyList.size() ; i++)
            {
                removeEdge(i,vertice);
            }
            size--;
            return true;
        }
        return false;
    }
}
