import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by robertcarney on 7/26/17.
 */
public class JourneyMoon {



  public static void main(String[] args) {
    long startTime = System.nanoTime();
    File file = new File("input1.txt");
    List<Long> costs = new ArrayList<>();
    try {
      Scanner in = new Scanner(file);
      int numAstronauts = in.nextInt();
      int edges = in.nextInt();
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < numAstronauts; i++)  {
        adj.add(new ArrayList<>());
      }
      for (int i = 0; i < edges; i++)  {
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        adj.get(a1).add(a2);
        adj.get(a2).add(a1);
      }
    } catch (Exception ex)  {
      ex.printStackTrace();
      System.exit(0);
    }
    long elapsedTime = System.nanoTime() - startTime;
    System.out.println((double) elapsedTime / 1000000000.0);

  }
}
