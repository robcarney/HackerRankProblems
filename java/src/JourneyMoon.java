import java.math.BigInteger;
import java.util.ArrayList;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by robertcarney on 7/26/17.
 */
public class JourneyMoon {


  static List<Integer> numDisconnected(List<ArrayList<Integer>> adj) {
    List<Integer> result = new ArrayList<>();
    HashSet<Integer> explored = new HashSet<>();


    for (int i = 0; i < adj.size(); i++)  {
      if (!explored.contains(i)) {
        int currCount = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
          int curr = stack.pop();
          if (!explored.contains(curr)) {
            explored.add(curr);
            currCount++;
            for (int j : adj.get(curr)) {
              if (!explored.contains(j)) {
                stack.push(j);
              }
            }
          }
        }
        result.add(currCount);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    File file = new File("input.txt");
    List<Long> costs = new ArrayList<>();
    try {
      Scanner in = new Scanner(file);
      int numAstronauts = in.nextInt();
      int edges = in.nextInt();
      List<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < numAstronauts; i++)  {
        adj.add(new ArrayList<>());
      }
      for (int i = 0; i < edges; i++)  {
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        adj.get(a1).add(a2);
        adj.get(a2).add(a1);
      }
      BigInteger bigNA = new BigInteger(Integer.toString(numAstronauts));
      BigInteger result = bigNA.multiply(bigNA.subtract(BigInteger.ONE)).divide(BigInteger.ONE.add(BigInteger.ONE));
      for (int i : numDisconnected(adj))  {
        if (i > 1) {
          int toSub = (i * (i - 1)) / 2;
          BigInteger bigSub = new BigInteger(Integer.toString(toSub));
          result = result.subtract(bigSub);
        }
      }
      System.out.println(result);
    } catch (Exception ex)  {
      ex.printStackTrace();
      System.exit(0);
    }

    long elapsedTime = System.nanoTime() - startTime;
    System.out.println((double) elapsedTime / 1000000000.0);

  }
}
