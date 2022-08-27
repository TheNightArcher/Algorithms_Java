package MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class Tower_Hanoi {
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static StringBuilder output = new StringBuilder();

    public static int steps;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(bufferedReader.readLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }

        solve(disk, source, destination, spare);
        System.out.println(output.toString());
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            output.append(String.format("Step %d: Moved disk %n", ++steps));
            print();
            return;
        }

        solve(disk - 1, source, spare, destination);
        solve(1, source, destination, spare);
        solve(disk - 1, spare, destination, source);
    }

    private static void print() {
        output.append("Source: ").append(formatRod(source))
                .append(System.lineSeparator())
                .append("Destination: ").append(formatRod(destination))
                .append(System.lineSeparator())
                .append("Spare: ").append(formatRod(spare))
                .append(System.lineSeparator())
                .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
