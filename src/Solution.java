import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import javafx.util.Pair;

/**
 * Created by robertcarney on 7/25/17.
 */
public class Solution {


  static int numDisconnected(ArrayList<List<Integer>> adj) {
    int result = 0;
    HashSet<Integer> explored = new HashSet<>();

    for (int i = 0; i < adj.size(); i++)  {
      if (!explored.contains(i)) {
        result++;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
          int curr = stack.pop();
          if (!explored.contains(curr)) {
            explored.add(curr);
            for (int j : adj.get(curr)) {
              if (!explored.contains(j)) {
                stack.push(j);
              }
            }
          }
        }
      }
    }
    return result;
  }


  static long cost(long cLib, long cRoad, ArrayList<List<Integer>> g, int gSize)  {
    if (cLib <= cRoad)  {
      return cLib * (long) gSize;
    }
    int discon = numDisconnected(g);
    return (cRoad * (gSize - discon)) + (cLib * discon);
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
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)  {
          adj.add(new ArrayList<>());
        }
        int m = in.nextInt();
        long x = in.nextLong();
        long y = in.nextLong();
        if (x < y && a0 == q - 1)  {
          in.close();
          break;
        }
        for (int a1 = 0; a1 < m; a1++) {
          int city_1 = in.nextInt() - 1;
          int city_2 = in.nextInt() - 1;
          adj.get(city_1).add(city_2);
          adj.get(city_2).add(city_1);
        }
        costs.add(cost(x, y, adj, n));
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
