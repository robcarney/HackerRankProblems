import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * For KnightL Hackerrank problem.
 * See: https://www.hackerrank.com/challenges/knightl-on-chessboard/problem
 */
public class KnightL {

  private int[][] runKnightL(int n)  {
    int[][] result = new int[n][n];
    for (int i = 0; i < n; i++)  {
      for (int j = 0; j < n; j++)  {
        int currBest = 0;
        result[i][j] = currBest;
        result[j][i] = currBest;
      }
    }
    return result;
  }

  private int doBfs(int i, int j, int n)  {
    if (n == 0) { return 0; }
    int[][] level = new int[n][n];
    boolean[][] seen = new boolean[n][n];
    Queue<Point> queue = new ArrayDeque<>();
    queue.add(new Point(0, 0));
    while (!queue.isEmpty())  {
      Point currentPoint = queue.poll();
      seen[currentPoint.x][currentPoint.y] = true;
      int currLevel = level[currentPoint.x][currentPoint.y];
      List<Point> validPoints = validPoints(currentPoint, n, i, j);
      for (Point point : validPoints)  {
        int currX = point.x;
        int currY = point.y;
        if (currX == n - 1 && currY == n - 1)  {
          return currLevel + 1;
        }
        if (!seen[currX][currY]) {
          queue.add(point);
          level[currX][currY] = currLevel + 1;
        }
      }
    }
    return -1;
  }

  private List<Point> validPoints(Point currentPoint, int limit, int i, int j) {
    List<Point> result = new ArrayList<>();
    int x = currentPoint.x;
    int y = currentPoint.y;
    int xiLess = x - i;
    int xjLess = x - j;
    int xiMore = x + i;
    int xjMore = x + j;
    int yiLess = y - i;
    int yjLess = y - j;
    int yiMore = y + i;
    int yjMore = y + j;
    if (xiMore < limit) {
      if (yjMore < limit)  {
        result.add(new Point(xiMore, yjMore));
      }
      if (yjLess >= 0) {
        result.add(new Point(xiMore, yjLess));
      }
    }
    if (xjMore < limit)  {
      if (yiMore < limit)  {
        result.add(new Point(xjMore, yiMore));
      }
      if (yiLess >= 0)  {
        result.add(new Point(xjMore, yiLess));
      }
    }
    if (xiLess >= 0)  {
      if (yjMore < limit)  {
        result.add(new Point(xiLess, yjMore));
      }
      if (yjLess >= 0)  {
        result.add(new Point(xiLess, yjLess));
      }
    }
    if (xjLess >= 0)  {
      if (yiMore < limit)  {
        result.add(new Point(xjLess, yiMore));
      }
      if (yiLess >= 0)  {
        result.add(new Point(xjLess, yiLess));
      }
    }
    return result;
  }


  public static void main(String[] args) {
    boolean useFile = true;
    Scanner scanner = new Scanner(System.in);
    if (useFile)  {
      try {
        File file = new File("input.txt");
        scanner = new Scanner(file);
      } catch (FileNotFoundException ex)  {
        System.exit(1);
      }
    }
    int n = scanner.nextInt();
    int[][] result = new KnightL().runKnightL(n);
    for (int i = 0; i < n; i++)  {
      StringBuilder toPrint = new StringBuilder("");
      for (int j = 0; j < n; j++) {
        toPrint.append(result[i][j]);
        toPrint.append(" ");
      }
      System.out.println(toPrint.toString());
    }
  }
}
