// Mansur Ischanov (mischano@calpoly.edu) & Luis 
// July 23rd, 2022
// Project 5

import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class DiGraph {
    private final LinkedList<Integer>[] ll;

    public DiGraph(int N) {
        this.ll = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            ll[i] = new LinkedList<>();
            ll[i].add(i);
        }
    }

    public boolean addEdge(int from, int to) {
        if (!ll[from - 1].contains(to - 1)) {
            ll[from - 1].add(to - 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEdge(int from, int to) {
        int index = ll[from - 1].indexOf(to - 1);
        if (ll[from - 1].contains(to - 1)) {
            ll[from - 1].remove(index);
            return true;
        } else {
            return false;
        }
    }

    public int edgeCount() {
        int edgeSum = 0;
        for (LinkedList<Integer> integers : ll) {
            edgeSum += integers.size() - 1;
        }

        return edgeSum;
    }

    public int vertexCount() {
        return ll.length;
    }

    private int[] indegrees() {
        int[] ind = new int[ll.length];
        for (LinkedList<Integer> integers : ll) {
            for (int j = 0; j < integers.size() - 1; j++) {
                ind[integers.get(j + 1)] += 1;
            }
        }

        return ind;
    }

    public int[] topSort() {
        int[] ind = indegrees();
        int[] sll = new int[ll.length];
        LinkedList<Integer> regQueue = new LinkedList<>();

        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 0) {
                regQueue.addLast(i);
            }
        }

        int i = 0;
        while (!regQueue.isEmpty()) {
            int j = regQueue.removeFirst();
            for (int k : ll[j]) {
                ind[k] -= 1;
                if (ind[k] == 0) {
                    regQueue.addLast(k);
                }
            }
            sll[i] = j + 1;
            i++;
        }

        try {
            if (i != ll.length) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: Graph is cyclic!");
            return null;
        }

        return sll;
    }

    private VertexInfo[] BFS(int s) {
        VertexInfo[] vi = new VertexInfo[ll.length];
        LinkedList<Integer> rq = new LinkedList<>();

        for (int i = 0; i < ll.length; i++) {
            vi[i] = new VertexInfo(-1, -1);
        }

        vi[s].pathLength = 0;
        rq.addLast(s);

        while (!rq.isEmpty()) {
            int i = rq.removeFirst();
            for (int j : ll[i]) {
                if (-1 == vi[j].pathLength) {
                    vi[j].pathLength = vi[i].pathLength + 1;
                    vi[j].vertexParent = i;
                    rq.addLast(j);
                }
            }
        }
        return vi;
    }

    public boolean isTherePath(int from, int to) {
        VertexInfo[] vi = BFS(from - 1);
        return (vi[to - 1].vertexParent != -1 || from == to);
    }

    public int lengthOfPath(int from, int to) {
        VertexInfo[] vi = BFS(from - 1);

        int i = to - 1;
        if ((vi[i].vertexParent == -1) && (from != to)) {
            return -1;
        }

        int j = 0;
        while (-1 != vi[i].vertexParent) {
            j++;
            i = vi[i].vertexParent;
        }

        return j;
    }

    public void printPath(int from, int to) {
        VertexInfo[] vi = BFS(from - 1);

        if ((vi[to - 1].vertexParent == -1) && (from != to)) {
            System.out.println("There is no path");
            return;
        }

        StringBuilder result = new StringBuilder();
        int i = to - 1;
        while (vi[i].vertexParent != -1) {
            result.insert(0, " to " + (i + 1));
            i = vi[i].vertexParent;
        }
        System.out.println("" + from + result);
    }

    public void print() {
        for (int i = 0; i < ll.length; i++) {
            System.out.format("" + (i + 1) + " is connected to:");
            if (ll[i].size() > 1) {
                for (int j = 1; j < ll[i].size(); j++) {
                    if (j == 1) {
                        System.out.format(" " + (ll[i].get(j) + 1));
                    } else {
                        System.out.format(", " + (ll[i].get(j) + 1));
                    }
                }
            }
            System.out.format("\n");
        }
    }

    private TreeNode buildTree(int s) {
        VertexInfo[] paths = BFS(s - 1);
        TreeNode[] tree = new TreeNode[paths.length];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new TreeNode(i + 1);
        }
        for (int i = 0; i < paths.length; i++) {
            int parent = paths[i].vertexParent;
            if (parent != -1) {
                tree[parent].addChild(tree[i]);
            }
        }

        return tree[s - 1];
    }

    public void printTree(int s) {
        TreeNode root = buildTree(s);
        System.out.println(root.vertexNumber);
        printTreeRecursive(root, 1);
    }

    private void printTreeRecursive(TreeNode current, int d) {
        for (TreeNode child : current.vertexChildren) {
            System.out.println(String.join("", Collections.nCopies(d, "\t")) + child.vertexNumber);
            printTreeRecursive(child, d + 1);
        }
    }

    private static class TreeNode {
        int vertexNumber;
        LinkedList<TreeNode> vertexChildren;

        private TreeNode(int n) {
            this.vertexNumber = n;
            this.vertexChildren = new LinkedList<>();
        }

        private void addChild(TreeNode child) {
            this.vertexChildren.add(child);
        }
    }

    private static class VertexInfo {
        public int pathLength;
        public int vertexParent;

        public VertexInfo(int i, int j) {
            this.pathLength = i;
            this.vertexParent = j;
        }
    }
}