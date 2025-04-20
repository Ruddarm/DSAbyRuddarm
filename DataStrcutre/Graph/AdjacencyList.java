package DSAbyRuddarm.DataStrcutre.Graph;

import java.util.ArrayList;

class Edge {
    int src, dest, wt;

    Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}

public class AdjacencyList {
    // Adjacency List representation of a graph
    // Each vertex has a list of adjacent vertices
    // This is a more space-efficient representation than an adjacency matrix
    // especially for sparse graphs
    public static void main(String[] args) {
        int V = 5; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // Adding edges to the graph
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));

        // Print the adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print("Vertext " + i + " : ");
            for (Edge edge : graph[i]) {
                System.out.print(" -> " + edge.dest + " (wt: " + edge.wt + ")");
            }
            System.out.println();
        }
    }

}