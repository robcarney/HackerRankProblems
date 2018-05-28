import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by robertcarney on 8/3/17.
 */
public class Kruskals {

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
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
            if (!explored[curr]) {
                explored[curr] = true;
                for (int i : adj.get(curr)) {
                    s.push(i);
                }
            }
        }
        return false;
    }

    public static int kruskals(PriorityQueue<Edge> edges, int numNodes)  {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++)  {
            adj.add(new ArrayList<>());
        }
        int numEdgesInTree = 0;
        int totalWeight = 0;
        while (numEdgesInTree != numNodes - 1)  {
            Edge curr = edges.poll();
            int s = curr.start;
            int e = curr.end;
            if (!hasPath(adj, s, e))  {
                System.out.print("Adding: ");
                System.out.print(s);
                System.out.print(" ");
                System.out.print(e);
                System.out.print(" ");
                System.out.println(curr.weight);
                adj.get(s).add(e);
                adj.get(e).add(s);
                totalWeight += curr.weight;
                numEdgesInTree++;
            }
            else  {
                System.out.print("Not adding: ");
                System.out.print(s);
                System.out.print(" ");
                System.out.print(e);
                System.out.print(" ");
                System.out.println(curr.weight);
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
                int s = in.nextInt() - 1;
                int e = in.nextInt() - 1;
                int w = in.nextInt();
                Edge curr = new Edge(s,e, w);
                edges.add(curr);
            }/*
            for (int i = 0; i < m; i++)  {
                Edge curr = edges.poll();
                System.out.println(curr.start + " " + curr.end + " " + curr.weight);
            }*/
            System.out.println(kruskals(edges,n));
        } catch (Exception ex)  {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
