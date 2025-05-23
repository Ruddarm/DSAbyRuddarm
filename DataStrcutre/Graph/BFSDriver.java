package DSAbyRuddarm.DataStrcutre.Graph;

import java.security.interfaces.EdECKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import DSAbyRuddarm.DataStrcutre.ArrayList.Arraylist;

// class to represent an edge in the graph
class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    // Adjacency list representation of the graph
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    // method to add vertices to the graph
    public void addVertex(int vertex) {
        // check if vertix is alredy presnt in graph
        if (vertex < graph.size())
            return;
        // add vertex to graph and add an empty list of edges to the graph
        while (graph.size() <= vertex) {
            graph.add(new ArrayList<Edge>());
        }
    }

    // method to add edges to the graph
    public void addEdges(int src, int dest, int weight, Scanner sc, boolean isDirected) {
        // check if the vertices are present in the graph
        addVertex(src);
        addVertex(dest);
        // add the edge to the graph
        graph.get(src).add(new Edge(src, dest, weight));
        if (!isDirected) {
            graph.get(dest).add(new Edge(dest, src, weight));
        }
    }

    // method to perform BFS on the graph
    // BFS algorithm uses a queue to keep track of the vertices to be visited
    public void bfs(int start, boolean visited[]) {
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {

            int currVertext = queue.remove(0);
            System.out.print(currVertext + "-->");
            visited[currVertext] = true;
            // iterate through the edges of the current vertex
            for (Edge edge : graph.get(currVertext)) {
                // check if the destination vertex is not visited
                if (!visited[edge.dest]) {
                    queue.add(edge.dest);
                    visited[edge.dest] = true;
                }
            }
        }
        System.out.println("null");
        System.out.println("BFS traversal completed.");
    }

    //
    public void dfs(int start, boolean[] visited) {
        System.out.print(start + "--> ");
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            Edge e = graph.get(start).get(i);
            if (!visited[e.dest]) {
                dfs(e.dest, visited);
            }
        }
    }

    // metho to find patfh
    public boolean hasPathUtil(int src, int des, boolean visited[]) {
        visited[src] = true;
        if (src == des)
            return true;
        for (Edge e : graph.get(src)) {
            if (!visited[e.dest] && hasPathUtil(e.dest, des, visited))
                return true;
        }
        return false;

    }

    // A method to detect cylce in graph directed and undircted graph
    public boolean detectCycleUtil(int curr, int parent, boolean[] visited) {
        visited[curr] = true;
        for (Edge e : graph.get(curr)) {
            // case not visited
            if (!visited[e.dest]) {
                if (detectCycleUtil(e.dest, curr, visited))
                    return true;
            } else if (visited[e.dest] && e.dest != parent)
                return true;
            // if vistied but it parrent continue
        }
        return false;
    }

    // dectecting cycle
    public boolean detectCycleUtil(int curr, boolean[] visited, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;
        for (Edge e : graph.get(curr)) {
            if (!visited[e.dest]) {
                return detectCycleUtil(e.dest, visited, stack);
            } else if (stack[e.dest]) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    // find topo logical order for dag graph using dfs
    public void topsort(int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;
        for (Edge edge : graph.get(curr)) {
            if (!visited[edge.dest]) {
                topsort(edge.dest, visited, stack);
            }
        }
        stack.push(curr);
    }

    // incoming outgoing
    public void calInDeg(int[] indeg) {
        for (ArrayList<Edge> g : graph) {
            for (Edge e : g) {
                indeg[e.dest]++;
            }
        }
    }

    // topsort bfs
    public void topsort(int src) {
        int indeg[] = new int[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        calInDeg(indeg);
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(curr + " --> ");
            for (Edge e : graph.get(curr)) {
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    queue.add(e.dest);
                }
            }
        }
    }

    // is birpartile
    public boolean birepartile(int curr, boolean visited[], int[] group) {
        visited[curr] = true;
        // group[]
        for (Edge edge : graph.get(curr)) {
            if (group[edge.dest] != -1 && group[curr] == group[edge.dest]) {
                return false;
            }

        }
        return false;
    }

}

public class BFSDriver {
    Graph graph = new Graph();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BFSDriver bfsDriver = new BFSDriver();
        boolean key = true;
        while (key) {
            int option = 0;
            System.out.println("1 Add Vertex ");
            System.out.println("2 Add Edge ");
            System.out.println("3 Perform BFS ");
            System.out.println("4 Perform DFS ");
            System.out.println("5 Detect Cycle");
            System.out.println("6 Find path");
            System.out.println("7 Perform Topological sort");
            System.out.println("0 Exit ");
            System.out.print("Enter your option: ");
            option = bfsDriver.sc.nextInt();
            switch (option) {
                case 1:
                    bfsDriver.addVertex();
                    break;
                case 2:
                    bfsDriver.addEdge();
                    break;
                case 3:
                    bfsDriver.performBFS();
                    break;
                case 4:
                    bfsDriver.performDFS();
                    break;
                case 5:
                    bfsDriver.detectCylce();
                    break;
                case 6:
                    bfsDriver.hasPath();
                    break;
                case 7:
                    bfsDriver.topoSort();
                    break;
                case 8:
                    bfsDriver.BfsTopoSort();

                case 0:
                    key = false;
                    break;
                default:
                    break;
            }
        }
    }

    // method to add vertices to the graph
    public void addVertex() {
        System.out.print("Enter the vertex: ");
        int vertex = sc.nextInt();
        graph.addVertex(vertex);
        System.out.println("Vertex " + vertex + " added to the graph.");
    }

    // method to add edges to the graph
    public void addEdge() {
        System.out.print("Enter the source vertex: ");
        int src = sc.nextInt();
        System.out.print("Enter the destination vertex: ");
        int dest = sc.nextInt();
        System.out.print("Enter the weight of the edge: ");
        int weight = sc.nextInt();
        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();
        graph.addEdges(src, dest, weight, sc, isDirected);
        System.out.println("Edge added from " + src + " to " + dest + " with weight " + weight);
        if (isDirected) {
            System.out.println("The graph is directed.");
        } else {
            System.out.println("The graph is undirected.");
        }
    }

    // method to perform BFS on the graph
    public void performBFS() {
        System.out.println("Enter the starting vertex for BFS: ");
        int start = sc.nextInt();
        // check if the vertex is present in the graph
        if (start >= graph.graph.size()) {
            System.out.println("Vertex " + start + " is not present in the graph.");
            return;
        }
        // perform BFS on the graph
        System.out.println("Performing BFS on the graph starting from vertex " + start + "...");
        boolean[] visited = new boolean[graph.graph.size()];

        for (int i = 0; i < graph.graph.size(); i++) {
            if (!visited[i])
                graph.bfs(i, visited);

        }
    }

    // method to perform DFS on the graph
    public void performDFS() {
        System.out.println("Enter the strating vertex for DFS");
        int start = sc.nextInt();
        if (start >= graph.graph.size()) {
            System.out.println("Vertex " + start + "is not present in the graph");
            return;
        }
        System.out.println("Performing DFS on the graph starting from vertex " + start + "...");
        // visited edge trakcer
        boolean visited[] = new boolean[graph.graph.size()];
        graph.dfs(start, visited);
        System.out.println("null");
        System.out.println("DFS traversal completed.");

    }

    // check path
    public void hasPath() {
        int src;
        int des;
        System.out.println("Enter Starting Vertex");
        src = sc.nextInt();
        System.out.println("Enter Destination ");
        des = sc.nextInt();
        boolean visited[] = new boolean[graph.graph.size()];
        if (graph.hasPathUtil(src, des, visited)) {
            System.out.println("Path exist from " + src + " to " + des);
        } else {
            System.out.println("Path not found");
        }
    }

    // detect cycle
    public void detectCylce() {
        System.out.println("1 : For undirected Graph");
        System.out.println("2 : For directed Graph");
        System.out.println("0 : exit");
        switch (sc.nextInt()) {
            case 1: {
                boolean visited[] = new boolean[graph.graph.size()];
                for (int i = 0; i < graph.graph.size(); i++) {
                    if (!visited[i]) {
                        if (graph.detectCycleUtil(i, -1, visited)) {
                            System.out.println("Cycle Found : True");
                            return;
                        }
                    }
                }
                break;
            }
            case 2: {
                boolean visited[] = new boolean[graph.graph.size()];
                boolean stack[] = new boolean[graph.graph.size()];
                for (int i = 0; i < graph.graph.size(); i++) {
                    if (!visited[i]) {
                        if (graph.detectCycleUtil(i, visited, stack)) {
                            System.out.println("Cycle Found : True");
                            return;
                        }
                    }
                }
                break;
            }
            case 0:
                return;
            default:
                return;
        }
        System.out.println("Cycle Found : False");

    }

    // perofrm toplogical sort
    public void topoSort() {
        boolean visited[] = new boolean[graph.graph.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.graph.size(); i++) {
            if (!visited[i]) {
                graph.topsort(i, visited, stack);
                while (!stack.isEmpty()) {
                    System.out.println(stack.pop() + " --> ");
                }
            }
        }
    }

    public void BfsTopoSort() {
        graph.topsort(0);
    }

}
