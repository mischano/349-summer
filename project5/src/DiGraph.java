import java.util.LinkedList;

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
}
