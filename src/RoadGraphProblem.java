import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RoadGraphProblem {

  public static class Graph  {
    int v; // Number of nodes
    List<LinkedList<Integer>> adj;

    Graph(int v)  {
      this.v = v;
      this.adj = new ArrayList<>();
      for (int i = 0; i < v; i++)  {
        adj.add(new LinkedList<>());
      }
    }

    void addEdge(int start, int end)  {
      adj.get(start).add(end);
      adj.get(end).add(start);
    }

    void removeEdge(int start, int end)  {
      int endInd = adj.get(start).indexOf(end);
      int startInd = adj.get(end).indexOf(start);
      adj.get(start).remove(endInd);
      adj.get(end).remove(startInd);
    }

    int numEdges()  {
      int sum = 0;
      for (LinkedList l : this.adj)  {
        sum += l.size();
      }
      return sum / 2;
    }

    @Override
    public String toString()  {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < v; i++)  {
        result.append("Node " + Integer.toString(i) + ":\n");
        for (int j : adj.get(i))  {
          result.append("   " + Integer.toString(j) + "\n");
        }
      }
      return result.toString();
    }

    public int getHighestDegreeNeighborHelp(int node, List<Integer> seen)  {
      int bestNode = -1;
      LinkedList<Integer> neighbors = adj.get(node);
      for (int i : neighbors)  {
      }
      return bestNode;
    }

    public int getHighestDegreeNeighbor(int node, boolean repeat)  {
      int best = 0;
      int bestNode = -1;
      LinkedList<Integer> neighbors = adj.get(node);
      for (int i : neighbors)  {
        if (adj.get(i).size() > best)  {
          best = adj.get(i).size();
          bestNode = i;
        }
        if (adj.get(i).size() == best && repeat && bestNode != -1)  {
          if (node == 3)  {
            System.out.println("Got here");
          }
          int iDegreeNeighbor = getHighestDegreeNeighbor(i, false);
          int degreeNeighbor = getHighestDegreeNeighbor(bestNode, false);
          if (iDegreeNeighbor > degreeNeighbor)  {
            bestNode = i;
          }
        }
      }
      return bestNode;
    }

    public void removeEdgesForNode(int node)  {
      LinkedList<Integer> l = new LinkedList<>();
      for (int x : adj.get(node))  {
        l.add(x);
      }
      for (int i : l)  {
        if (this.adj.get(i).size() < 2)  this.removeEdge(node,i);
      }
    }

    int getLowestPositiveNode()  {
      int bestInd = -1;
      int best = 10000;
      for (int i = 0; i < adj.size(); i++)  {
        int size = adj.get(i).size();
        if (size != 0 && size < best)  {
          bestInd = i;
          best = size;
        }
        else if (size == best && bestInd != -1)  {
          int iBestNeighbor = adj.get(getHighestDegreeNeighbor(i, true)).size();
          int bestNeighbor = adj.get(getHighestDegreeNeighbor(bestInd, true)).size();
          if (iBestNeighbor < bestNeighbor) {
            bestInd = i;
          }
        }
      }
      return bestInd;
    }
  }

  public static List<Integer> getCycle(Graph g)  {
    Boolean[] visited = new Boolean[g.v];
    for (int c = 0; c < g.v; c++)  {
      visited[c] = false;
    }

    for (int i = 0; i < g.v; i++)  {
      if (!visited[i])  {
        List<Integer> curr = getCycleUtil(g, i, visited, -1);
        if (curr.size() != 0)  {
          return curr;
        }
      }
    }
    return new ArrayList<>();
  }

  public static Boolean[] genBoolArray(int n)  {
    Boolean[] result = new Boolean[n];
    for (int i = 0; i < n; i++)  {
      result[i] = false;
    }
    return result;
  }

  public static List<Integer> getCycleUtil(Graph g, int ind, Boolean[] visited, int parent)  {
    visited[ind] = true;
    Integer i;
    Iterator<Integer> iter = g.adj.get(ind).iterator();
    while (iter.hasNext())  {
      i = iter.next();

      if (!visited[i])  {
        List<Integer> recur = getCycleUtil(g, i, visited, ind);
        if (recur.size() != 0)  {
          recur.add(ind);
          return recur;
        }
      }

      else if (i != parent)  {
        List<Integer> result = new ArrayList<>();
        result.add(ind);
        return result;
      }
    }
    return new ArrayList<Integer>();
  }

  // NOTE: Returns however many cycles were
  public static int removeCycles(Graph g)  {
    List<Integer> cycle = getCycle(g);
    int disconnected = 0;
    while (cycle.size() != 0)  {
      for (int i = 0; i < cycle.size(); i++)  {
        int curr = cycle.get(i);
        if (i == 0)  {
          g.removeEdge(curr, cycle.get(cycle.size() - 1));
        }
        else  {
          g.removeEdge(curr, cycle.get(i - 1));
        }
      }
      cycle = getCycle(g);
    }
    return disconnected;
  }

  public static int numRobots(Graph g)  {
    //removeCycles(g);
    int robots = 0;
    while (g.numEdges() > 0)  {
      int ind = g.getLowestPositiveNode();
      while (true)  {
        int bestNeighbor = g.getHighestDegreeNeighbor(ind, true);
        if (bestNeighbor == -1)  { break; }
        g.removeEdge(ind, bestNeighbor);
        ind = bestNeighbor;
      }
      System.out.println("Break");
      robots++;
    }
    return robots;
  }

  static Graph[] scanInput()  {
    Scanner sc = new Scanner(System.in);
    int first = Integer.parseInt(sc.nextLine().trim());
    int count = -1;
    Graph[] result = new Graph[first];
    while (sc.hasNextLine())  {
      String[] line = sc.nextLine().split(" ");
      if (line.length == 1)  {
        count++;
        result[count] = new Graph(Integer.parseInt(line[0]));
      }
      else  {
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);
        result[count].addEdge(start,end);
      }
    }
    return result;
  }

  public static void main(String[] args)  {
/*
    Graph[] input = scanInput();
    for (Graph g : input)  {
      System.out.println(numRobots(g));
    }
    */
    Graph g = new Graph(7);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(3,2);
    g.addEdge(1,3);
    g.addEdge(3,4);
    g.addEdge(3,5);
    g.addEdge(4,6);
    g.addEdge(5,6);
    System.out.println(numRobots(g));

  }
}
