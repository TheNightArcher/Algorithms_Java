package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> elements = Arrays.stream(input.split("\\s+")).
                        map(Integer::parseInt)
                        .collect(Collectors.toList());

                graph.add(elements);
            }
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected component: ");
            for (Integer integer : connectedComponent) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                components.add(new ArrayDeque<>());
                bfs(start, components, graph, visited);
            }
        }

        return components;
    }

    private static void bfs(int start, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            components.get(components.size() - 1).offer(node);

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }

    private static void dfs(int start, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[start]) {
            visited[start] = true;
            for (int child : graph.get(start)) {
                dfs(child, components, graph, visited);
            }
            components.get(components.size() - 1).offer(start);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        List<String> sorted = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Set<String> detectCycles = new HashSet<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dfsSort(node.getKey(), visited, graph, sorted, detectCycles);
        }
        Collections.reverse(sorted);

        return sorted;
    }

    private static void dfsSort(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted, Set<String> detectCycles) {
        if (detectCycles.contains(key)) {
            throw new IllegalStateException();
        }
        if (!visited.contains(key)) {
            visited.add(key);
            detectCycles.add(key);

            for (String child : graph.get(key)) {
                if (!visited.contains(child)) {
                    dfsSort(child, visited, graph, sorted, detectCycles);
                }
            }
            detectCycles.remove(key);
            sorted.add(key);
        }
    }
}
