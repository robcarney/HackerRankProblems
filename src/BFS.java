import java.io.File;
import java.util.*;

/**
 * Created by robertcarney on 7/31/17.
 */
public class BFS {


    static List<Integer> breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int startNode)  {
        List<Integer> result = new ArrayList<>(adj.size());
        for (int j = 0; j < adj.size(); j++)  {
            result.add(-1);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> prev = new HashMap<>();
        prev.put(startNode, -1);
        boolean[] explored = new boolean[adj.size()];
        queue.add(startNode);
        while (!queue.isEmpty())  {
            int curr = queue.poll();
            if (!explored[curr])  {
                explored[curr] = true;
                int prevNode = prev.get(curr);
                if (prevNode == -1)  {
                    result.set(curr, 0);
                } else {
                    int prevDist = result.get(prevNode) + 6;
                    result.set(curr, prevDist);
                }
                for (int n : adj.get(curr))  {
                    if (prev.get(n) == null) {
                        prev.put(n, curr);
                    }
                    queue.add(n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args)  {
        File file = new File("input.txt");
        List<Long> costs = new ArrayList<>();
        try {
            Scanner in = new Scanner(file);
            int q = in.nextInt();
            for (int i = 0; i < q; i++)  {
                int n = in.nextInt();
                int m = in.nextInt();
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
                for (int k = 0; k < n; k++)  {
                    adj.add(new ArrayList<>());
                }
                for (int j = 0; j < m; j++)  {
                    int start = in.nextInt() - 1;
                    int end = in.nextInt() - 1;
                    adj.get(start).add(end);
                    adj.get(end).add(start);
                }
                int startNode = in.nextInt() - 1;
                List<Integer> bfs = breadthFirstSearch(adj, startNode);
                for (int x = 0; x < bfs.size(); x++)  {
                    if (x != startNode)  {
                        System.out.print(bfs.get(x));
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
