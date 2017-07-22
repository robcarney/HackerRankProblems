import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RoadsAndLibraries {

  public static class Graph  {
    HashMap<Integer, List<Integer>> adj;
    int v;

    public Graph(int v)  {
      this.v = v;
      this.adj = new HashMap<>();
      for (int i = 0; i < v; i++)  {
        this.adj.put(i,new ArrayList<>());
      }
    }

    public void addEdge(int start, int end)  {
      this.adj.get(start).add(end);
      this.adj.get(end).add(start);
    }

    public int numDisconnected()  {
      int result = 0;
      List<Integer> iter = new ArrayList<>(this.adj.keySet());
      for (int k : iter) {
        if (adj.get(k).size() == 0)  {
          this.adj.remove(k);
          result++;
        }
      }
      HashMap<Integer,Boolean> explored = new HashMap<>();
      for (int i : adj.keySet())  {
        explored.put(i,false);
      }
      while (!this.adj.keySet().isEmpty())  {
        result++;
        this.depthFirstSearch(explored);
      }
      return result;
    }

    void depthFirstSearch(HashMap<Integer,Boolean> explored)  {
      if (adj.keySet().size() == 0)  {
        this.adj = new HashMap<>();
        return;
      }
      int start = adj.keySet().iterator().next();
      Stack<Integer> stack = new Stack<>();
      stack.push(start);
      while (!stack.empty())  {
        int curr = stack.pop();
        if (!explored.get(curr)) {
          explored.put(curr, true);
          for (int i : adj.get(curr))  {
            stack.push(i);
          }
          this.adj.remove(curr);
        }
      }
    }
  }

  public static long cost(long cLib, long cRoad, Graph g, int gSize)  {
    if (cLib <= cRoad)  {
      return cLib * (long) gSize;
    }
    int discon = g.numDisconnected();
    return (cRoad * (gSize - discon)) + (cLib * discon);
  }

  static void depthFirstSearch(HashMap<Integer,List<Integer>> adj, HashMap<Integer,Boolean> explored)  {
    if (adj.keySet().size() == 0)  {
      adj = new HashMap<>();
      return;
    }
    int start = adj.keySet().iterator().next();
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    while (!stack.empty())  {
      int curr = stack.pop();
      if (!explored.get(curr)) {
        explored.put(curr, true);
        for (int i : adj.get(curr))  {
          stack.push(i);
        }
        adj.remove(curr);
      }
    }
  }


  public static void main(String[] args) {
    long startTime = System.nanoTime();
    File file = new File("input1.txt");
    List<Long> costs = new ArrayList<>();
    try {
      Scanner in = new Scanner(file);
      int q = in.nextInt();
      for(int a0 = 0; a0 < q; a0++){
        int n = in.nextInt();
        Graph g = new Graph(n);
        int m = in.nextInt();
        long x = in.nextLong();
        long y = in.nextLong();
        for (int a1 = 0; a1 < m; a1++) {
          int city_1 = in.nextInt() - 1;
          int city_2 = in.nextInt() - 1;
          g.addEdge(city_1, city_2);
        }
        costs.add(cost(x, y, g, n));
      }
    } catch (Exception ex)  {
      ex.printStackTrace();
      System.exit(0);
    }
    for (long l : costs)  {
      System.out.println(l);
    }
    long elapsedTime = System.nanoTime() - startTime;
    System.out.println((double) elapsedTime / 1000000000.0);
  }
}
