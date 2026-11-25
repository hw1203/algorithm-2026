package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class WeightedGraph<E> {
    VertexList<E>[] adjacentList;
    int vertexCount;

    public WeightedGraph(E[] value) {
        this.adjacentList = new VertexList[value.length];
        this.vertexCount = value.length;
        for (int i = 0; i < value.length; i++) {
            adjacentList[i] = new VertexList<>(value[i]);
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacentList[source].add(destination, weight);
        adjacentList[destination].add(source, weight);
    }

    public void addDirecredEdge(int source, int destination, int weight) {
        adjacentList[source].add(destination, weight);
    }


    void print() {
        for (int i = 0; i < adjacentList.length; i++) {
            System.out.print(i + ":" + adjacentList[i].value + " -> ");
            for (Vertex v : adjacentList[i].list) {
                System.out.print("(to: " + v.v + ", weight: " + v.weight + ") ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        System.out.print("BFS");

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print("  -> " + u + ":" + adjacentList[u].value);
            LinkedList<Vertex> adjList = adjacentList[u].list;
            for (Vertex v : adjList) {
                if (!visited[v.v]) {
                    visited[v.v] = true;
                    queue.add(v.v);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        System.out.print("DFS");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print("  -> " + v + ":" + adjacentList[v].value);
        LinkedList<Vertex> adjList = adjacentList[v].list;
        for (Vertex x : adjList) {
            if (!visited[x.v]) {
                dfsUtil(x.v, visited);
            }
        }
    }

    void dijkstra(int start) {
        int[] distances = new int[vertexCount];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int[] previous = new int[vertexCount];
        Arrays.fill(previous, -1);

        HashSet<Integer> noVisited = new HashSet<>();
        for (int i = 0; i < vertexCount; i++) {
            noVisited.add(i);
        }

        distances[start] = 0;
        while (!noVisited.isEmpty()){
            int u = extractMin(noVisited, distances);
            if (u == -1) {
                break;
            }
            noVisited.remove(u);
            for (Vertex e : adjacentList[u].list) {
                int v = e.v;
                int weight = e.weight;
                if (noVisited.contains(v) && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    previous[v] = u;
                }
            }
            System.out.println(Arrays.toString(distances));
        }

        printPath(start, distances, previous);

    }

    private void printPath(int start, int[] distances, int[] previous) {
        System.out.println(adjacentList[start].value + "로부터 각 정점까지의 최단 거리: ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(adjacentList[i].value + "까지의 거리: " + distances[i] + " (경로: ");
            int current = i;
            String path = "";
            while (current != -1) {
                path = adjacentList[current].value + " " + path;
                current = previous[current];
            }
            System.out.println(path + ")");
        }
    }

    private int extractMin(HashSet<Integer> noVisited, int[] distances) {
        int minDist = Integer.MAX_VALUE;
        int u = -1;
        for (int v : noVisited) {
            if (distances[v] < minDist) {
                minDist = distances[v];
                u = v;
            }
        }
        return u;
    }

    void floyWarshall() {
        int[][] distances = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++){
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[i][i] = 0;
        }

        for (int u = 0; u < vertexCount; u++) {
            for (Vertex v : adjacentList[u].list) {
                distances[u][v.v] = v.weight;
            }
        }

        System.out.println("Floyd-Warshall 최단 거리 행렬:");
        for (int k = 0; k < vertexCount; k++) {
            for (int i = 0; i < vertexCount; i++) {
                for(int j = 0; j < vertexCount; j++) {
                    System.out.print(distances[i][j] + "  ");
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }
    }

    public void primMST() {
        int[] costs = new int[vertexCount];
        int[] parent = new int[vertexCount];
        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[vertexCount];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        costs[0] = 0;
        pq.add(new Vertex(0, 0));
        int mstWeight = 0;

        System.out.println("Prim MST:");
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            int u = cur.v;
            if (visited[u]) continue;
            visited[u] = true;
            mstWeight += cur.weight;

            if (parent[u] != -1) {
                System.out.println(adjacentList[parent[u]].value + " - "
                        + adjacentList[u].value + " : " + cur.weight);
            }

            for (Vertex e : adjacentList[u].list) {
                if (!visited[e.v] && e.weight < costs[e.v]) {
                    costs[e.v] = e.weight;
                    parent[e.v] = u;
                    pq.add(new Vertex(e.v, e.weight));
                }
            }
        }
        System.out.println("Prim MST 최소 비용: " + mstWeight);
    }

    public void kruskalMST() {
        // 1. 모든 간선 수집
        LinkedList<Edge> edges = new LinkedList<>();
        boolean[][] seen = new boolean[vertexCount][vertexCount];
        for (int u = 0; u < vertexCount; u++) {
            for (Vertex v : adjacentList[u].list) {
                if (!seen[u][v.v] && !seen[v.v][u]) {
                    edges.add(new Edge(u, v.v, v.weight));
                    seen[u][v.v] = true;
                    seen[v.v][u] = true;
                }
            }
        }

        // 2. 간선 정렬 (오름차순)
        edges.sort((a, b) -> Integer.compare(a.weight, b.weight));

        // 3. Union-Find 구조 초기화
        int[] parent = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) parent[i] = i;

        int mstWeight = 0;
        System.out.println("Kruskal MST:");

        for (Edge e : edges) {
            int rootU = find(parent, e.u);
            int rootV = find(parent, e.v);

            if (rootU != rootV) {
                union(parent, rootU, rootV);
                mstWeight += e.weight;
                System.out.println(adjacentList[e.u].value + " - " + adjacentList[e.v].value + " : " + e.weight);
            }
        }

        System.out.println("Kruskal MST 최소 비용: " + mstWeight);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY)
            parent[rootY] = rootX;
    }

    static class Edge {
        int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }


    private static class Vertex implements Comparable<Vertex>{
        int v;
        int weight;

        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static class VertexList<E> {
        E value;
        LinkedList<Vertex> list;

        public VertexList(E value) {
            this.value = value;
            this.list = new LinkedList<>();
        }

        public void add(int destination, int weight) {
            this.list.add(new Vertex(destination, weight));
        }
    }
}