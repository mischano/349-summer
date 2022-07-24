// Mansur Ischanov (mischano@calpoly.edu) & Luis 
// July 23rd, 2022
// Project 5

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiGraphTest {
    public static void main(String[] args) {
        System.out.println("Enter the number of vertices in the directed graph:");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        DiGraph dg = new DiGraph(Integer.parseInt(input));
        //noinspection TextBlockMigration
        System.out.println("Choose one of the following operations:\n" +
                "- add edge (enter a)\n" +
                "- delete edge (enter d)\n" +
                "- edge count (enter e)\n" +
                "- vertex count (enter v)\n" +
                "- print graph (enter p)\n" +
                "- topological sort (enter t)\n" +
                "- is there a path (enter i)\n" +
                "- length of the path (enter l)\n" +
                "- shortest path (enter s)\n" +
                "- print breadth-first-tree (enter b)\n" +
                "- Quit (enter q)");
        while (!input.equals("q")) {
            do {
                input = in.nextLine();
            } while (input.isEmpty());
            int from, to;
            switch (input) {
                case "a":
                    System.out.println("Enter the edge's vertices:");
                    from = in.nextInt();
                    to = in.nextInt();
                    if (dg.addEdge(from, to)) {
                        System.out.format("Edge (%d, %d) was added.\n", from, to);
                    } else {
                        System.out.format("Edge (%d, %d) already exists.\n", from, to);
                    }
                    break;
                case "d":
                    System.out.println("Enter the edge's vertices:");
                    from = in.nextInt();
                    to = in.nextInt();
                    if (dg.deleteEdge(from, to)) {
                        System.out.format("Edge (%d, %d) was deleted.\n", from, to);
                    } else {
                        System.out.format("Edge (%d, %d) does not exist.\n", from, to);
                    }
                    break;
                case "e":
                    System.out.format("Number of edges is: %d\n", dg.edgeCount());
                    break;
                case "v":
                    System.out.format("Number of vertices is: %d\n", dg.vertexCount());
                    break;
                case "p":
                    System.out.println("The graph is the following:");
                    dg.print();
                    break;
                case "t":
                    int[] vertices = dg.topSort();
                    if (vertices != null) {
                        System.out.format("Topologically sorted vertices: %s\n",
                                IntStream.of(vertices).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
                    }
                    break;
                case "i":
                    System.out.println("Enter start and destination vertex");
                    from = in.nextInt();
                    to = in.nextInt();
                    in.nextLine();
                    boolean path = dg.isTherePath(from, to);
                    if (path) {
                        System.out.println("There is a path from " + from + " to " + to + ".");
                    } else {
                        System.out.println("There is not a path from " + from + " to " + to + ".");
                    }
                    break;
                case "l":
                    System.out.println("Enter start and destination vertex");
                    from = in.nextInt();
                    to = in.nextInt();
                    in.nextLine();
                    int length = dg.lengthOfPath(from, to);
                    System.out.println("The path length from " + from + " to " + to + " is " + length + ".");
                    break;
                case "s":
                    System.out.println("Enter start and destination vertex");
                    from = in.nextInt();
                    to = in.nextInt();
                    in.nextLine();
                    path = dg.isTherePath(from, to);
                    if (path) {
                        System.out.println("The shortest path is the following:");
                        dg.printPath(from, to);
                    } else {
                        System.out.println("There is not a path from " + from + " to " + to + ".");
                    }
                    break;
                case "b":
                    System.out.println("Enter the source vertex number:");
                    int vertex = in.nextInt();
                    System.out.println("The breadth-first-tree is the following:");
                    dg.printTree(vertex);
                    break;
                case "q":
                    continue;
                default:
                    System.out.println("InputMismatchException: Invalid menu choice!");
                    break;
            }
        }
        System.out.println("Good bye.");
    }
}