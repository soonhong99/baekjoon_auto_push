
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int computerNum = Integer.parseInt(br.readLine());
        int connectComputerPairNum = Integer.parseInt(br.readLine());
        Graph g = new Graph(computerNum);
        for (int i = 0; i < connectComputerPairNum; i++) {
            int edge[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            g.addEdge(edge[1], edge[0]);
            g.addEdge(edge[0], edge[1]);
        }
        System.out.println(g.BFS(1) - 1);
    }
}

class Graph {
    private int V; // 노드의 개수
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v + 1];
        for (int i = 1; i <= v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {adj[v].add(w);}

    int BFS(int s) {
        boolean visited[] = new boolean[V + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);
        int count = 0;
        while (queue.size() != 0) {
            s = queue.poll();
            count++;

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return count;
    }
}
