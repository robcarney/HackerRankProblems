import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  public static class Graph  {
    List<Road> graph;

    public Graph() {
      this.graph = new ArrayList<>();
    }
  }


  public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);
    Graph[] cases = new Graph[Integer.parseInt(sc.nextLine())];
    int count = -1;
    int curr = 0;
    while (sc.hasNextLine())  {
      String[] line = sc.nextLine().split(" ");
      if (line.length == 1)  {
        curr = Integer.parseInt(line[0]);
        Graph graph = new Graph();
        count += 1;
      }
      else  {
        
      }
    }
  }

}
