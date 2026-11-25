package graph;

public class DijkstraMain {
    static void main() {
        String[] cities = {"서울", "대전", "세종", "공주", "대구", "부산", "경주"};
        WeightedGraph<String> graph = new WeightedGraph<>(cities);

        graph.addEdge(0,1,8);
        graph.addEdge(0,2,9);
        graph.addEdge(0,3,11);
        graph.addEdge(1,4,10);
        graph.addEdge(2,4,5);
        graph.addEdge(2,3,13);
        graph.addEdge(2,5,12);
        graph.addEdge(3,6,8);
        graph.addEdge(5,6,7);

        graph.dijkstra(0);
        graph.floyWarshall();
    }
}
