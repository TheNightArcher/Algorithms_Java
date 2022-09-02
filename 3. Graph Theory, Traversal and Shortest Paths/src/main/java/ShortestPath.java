package main.java;

import java.util.*;

public class ShortestPath {
    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int edgesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < edgesCount; i++) {
            int[] node = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.get(node[0]).add(node[1]);
        }
        visited = new boolean[n + 1];
        prevNodes = new int[n + 1];

        Arrays.fill(prevNodes, -1);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        bfs(graph, start, end);

        List<Integer> path = new ArrayList<>();

        path.add(end);

        int prevNode = prevNodes[end];

        while (prevNode != -1) {
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }

        System.out.printf("Shortest path length is: %d %n", path.size() - 1);

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static void bfs(List<List<Integer>> graph, int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return;
            }

            for (int child : graph.get(current)) {

                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = current;
                    queue.offer(child);
                }
            }
        }
    }
}
