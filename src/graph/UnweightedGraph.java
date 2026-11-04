package graph;

import java.util.LinkedList;

public class UnweightedGraph<E> {
    VertexList<E>[] adjacentList;
    int vertexCount;

    public UnweightedGraph(E[] value) {
        this.adjacentList = new VertexList[value.length];
        this.vertexCount = value.length;
        for (int i = 0; i < value.length; i++) {
            adjacentList[i] = new VertexList<>(value[i]);
        }
    }

    public void addEdge(int source, int destination) {
        adjacentList[source].add(destination);
        adjacentList[destination].add(source);
    }

    public void addDirecredEdge(int source, int destination) {
        adjacentList[source].add(destination);
    }


    void print() {
        for (int i = 0; i < adjacentList.length; i++) {
            System.out.print(i + ":" + adjacentList[i].value + " ->");
            for ( int v : adjacentList[i].list) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }

        visited[start] = true;
        System.out.print("BFS");
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print("  -> " + u + ":" + adjacentList[u].value);
            LinkedList<Integer> adjList = adjacentList[u].list;
            for (int v : adjList) {
                if (!visited[v]){ //visited[v] == false 똑같다
                    visited[v] = true;
                    queue.add(v);
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
        LinkedList<Integer> adjList = adjacentList[v].list;
        for (int x : adjacentList[v].list) {
            if (!visited[x]) {
                dfsUtil(x, visited);
            }
        }
    }

    private static class VertexList<E> {
        E value;
        LinkedList<Integer> list;

        public VertexList(E value) {
            this.value = value;
            this.list = new LinkedList<>();
        }

        public void add(int destination) {
            this.list.add(destination);
        }
    }
}