import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RoadsAndLibraries {

  public static class Graph  {
    HashMap<Integer, List<Integer>> adj;
    int v;

    public Graph(HashMap<Integer, List<Integer>> adj) {
      this.v = 0;
      this.adj = adj;
    }

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
      int result = 1;
      List<Integer> iter = new ArrayList<>(this.adj.keySet());
      for (int k : iter) {
        if (adj.get(k).size() == 0)  {
          this.adj.remove(k);
          result++;
        }
      }
      List<Integer> connected = this.depthFirstSearch();
      for (int j : connected)  {
        this.adj.remove(j);
      }
      while (!this.adj.keySet().isEmpty())  {
        result++;
        connected = this.depthFirstSearch();
        for (int j : connected)  {
          this.adj.remove(j);
        }
      }
      return result;
    }

    List<Integer> depthFirstSearch()  {
      ArrayList<Integer> result = new ArrayList<>();
      if (adj.keySet().size() == 0)  {
        return result;
      }
      if (adj.keySet().size() == 1)  {
        for (int i : adj.keySet())  {
          result.add(i);
        }
        return result;
      }
      int start = -1;
      for (int i : adj.keySet())  {
        if (adj.get(i).isEmpty())  { continue; }
        else  {
          start = i;
          break;
        }
      }
      if (start == -1)  {
        for (int i : adj.keySet())  {
          result.add(i);
          return result;
        }
      }
      HashMap<Integer,Boolean> explored = new HashMap<>();
      for (int i : adj.keySet())  {
        explored.put(i,false);
      }
      Stack<Integer> stack = new Stack<>();
      stack.push(start);
      while (!stack.empty())  {
        int curr = stack.pop();
        if (!explored.get(curr)) {
          explored.put(curr, true);
          for (int i : adj.get(curr))  {
            stack.push(i);
          }
          result.add(curr);
        }
      }
      return result;
    }

  }

  public static long cost(long cLib, long cRoad, Graph g, int gSize)  {
    if (cLib <= cRoad)  {
      return cLib * (long) gSize;
    }
    int discon = g.numDisconnected();
    return (cRoad * (gSize - discon)) + (cLib * discon);
  }


  public static void main(String[] args) {
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
        for(int a1 = 0; a1 < m; a1++){
          int city_1 = in.nextInt() - 1;
          int city_2 = in.nextInt() - 1;
          g.addEdge(city_1,city_2);
        }
        costs.add(cost(x,y,g,n));
      }
    } catch (Exception ex)  {
      ex.printStackTrace();
      System.exit(0);
    }
    for (long l : costs)  {
      System.out.println(l);
    }
    /*
    Graph g = new Graph(9);
    g.addEdge(7,1);
    g.addEdge(1,8);*/
  }
}
