import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by robertcarney on 7/17/17.
 */
public class RepairRoads {

  public static class Road  {
    int start;
    int end;

    public Road(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static class Network  {
    int num;
    List<Road> roads;

    public Network(int n) {
      this.num = n;
      this.roads = new ArrayList<>();
    }

    public void addRoad(Road r)  {
      this.roads.add(r);
    }
  }

  public static class Node  {
    int id;
    List<Integer> neighbors;

    Node(int id, List<Integer> neighbors) {
      this.id = id;
      this.neighbors = neighbors;
    }

    void addNeightbor(int n)  {
      if (neighbors.contains(n))  {
        return;
      }
      neighbors.add(n);
    }
  }


  public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);
    Network[] cases = new Network[Integer.parseInt(sc.nextLine())];
    int count = -1;
    while (sc.hasNextLine())  {
      String[] line = sc.nextLine().split(" ");
      if (line.length == 1)  {
        int curr = Integer.parseInt(line[0]);
        count += 1;
        cases[count] = new Network(curr);
      }
      else  {
        Road r = new Road(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        cases[count].addRoad(r);
      }
    }
  }

  private static int getNumRobots(Network network)  {
    HashMap<Integer, Node> adjacencyList = getAdjacencyList(network);
    HashMap<Integer, Boolean> visited = new HashMap<>();
    Queue<Integer> toVisit = new LinkedList<>();
    PriorityQueue<Integer> notSeen = new PriorityQueue<>(adjacencyList.keySet());
    List<List<Road>> allPaths = new ArrayList<>();
    boolean stop = false;
    int numRobots = 0;
    while (notSeen.size() != 0)  {
      Node n = adjacencyList.get(notSeen.poll());
      for (int i : n.neighbors)  {

      }
    }

    return numRobots;
  }

  private static HashMap<Integer, Node> getAdjacencyList(Network n)  {
    HashMap<Integer,Node> map = new HashMap<>();
    for (Road r : n.roads)  {
      int i = r.start;
      int j = r.end;
      if (map.get(i) == null)  {
        map.put(i,new Node(i,new ArrayList<>()));
      }
      if (map.get(j) == null)  {
        map.put(j,new Node(j,new ArrayList<>()));
      }
      map.get(i).addNeightbor(j);
      map.get(j).addNeightbor(i);
    }
    return map;
  }

}
