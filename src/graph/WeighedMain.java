package graph;

public class WeighedMain {
    static void main() {
        String[] values = {"철수", "영희", "동건", "준호", "재상", "승우"};
        WeightedGraph<String> graph =
                new WeightedGraph<>(values);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 7);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 5, 6);
        graph.addEdge(1, 2, 9);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 1);

        graph.print();
        graph.bfs(0);
        graph.dfs(0);

        graph.primMST();
        graph.kruskalMST();
    }
}
