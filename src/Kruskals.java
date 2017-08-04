import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by robertcarney on 8/3/17.
 */
public class Kruskals {

    static class Edge  {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static boolean hasPath(ArrayList<ArrayList<Integer>> adj, int start, int end)  {
        boolean[] explored = new boolean[adj.size()];
        Stack<Integer> s = new Stack<>();
        s.push(start);
        while (!s.isEmpty())  {
            int curr = s.pop();
            if (curr == end)  {
                return true;
            }
            for (int i : adj.get(curr))  {
                s.push(i);
            }
        }
        return false;
    }

    public static int kruskals(PriorityQueue<Edge> edges, int numNodes)  {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++)  {
            adj.set(i, new ArrayList<>());
        }
        int numEdgesInTree = 0;
        int totalWeight = 0;
        while (numEdgesInTree != numNodes - 1)  {
            Edge curr = edges.poll();
            int s = curr.start;
            int e = curr.end;
            if (!hasPath(adj, s, e))  {
                adj.get(s).add(e);
                adj.get(e).add(s);
                totalWeight += curr.weight;
                numEdgesInTree++;
            }
        }
        return totalWeight;
    }



    public static void main(String[] args) {
        File file = new File("input.txt");
        try  {
            Scanner in = new Scanner(file);
            int n = in.nextInt();
            int m = in.nextInt();
            PriorityQueue<Edge> edges = new PriorityQueue<>(m);
            for (int i = 0; i < m; i++)  {
                int s = in.nextInt();
                int e = in.nextInt();
                int w = in.nextInt();
                Edge curr = new Edge(s,e, w);
                edges.add(curr);
            }
        } catch (Exception ex)  {
            System.exit(0);
        }
    }
}
