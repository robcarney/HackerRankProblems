import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * For the FullCountingSort problem on Hackerrank.
 * See: https://www.hackerrank.com/challenges/countingsort4/problem
 */
public class FullCountingSort {

  public static void main(String[] args) {boolean useFile = true;
    Scanner scanner;
    try {
      File file = new File("input.txt");
      scanner = new Scanner(file);
    } catch (FileNotFoundException ex)  {
      scanner = new Scanner(System.in);
    }
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    Map<Integer, List<String>> countToStrings = new HashMap<>();

    for (int nItr = 0; nItr < n; nItr++) {
      String[] xs = scanner.nextLine().split(" ");
      int x = Integer.parseInt(xs[0]);
      String s = nItr < n / 2 ? "-" : xs[1];
      countToStrings.putIfAbsent(x, new ArrayList<>());
      countToStrings.get(x).add(s);
    }

    List<Integer> sortedNums = new ArrayList<>(countToStrings.keySet().size());
    sortedNums.addAll(countToStrings.keySet());
    Collections.sort(sortedNums);
    StringBuilder result = new StringBuilder();
    for (Integer i : sortedNums) {
      List<String> currStrings = countToStrings.get(i);
      for (int j = 0; j < currStrings.size(); j++) {
        result.append(currStrings.get(j));
        result.append(" ");
      }
    }
    System.out.println(result.toString());
    scanner.close();
  }
}
