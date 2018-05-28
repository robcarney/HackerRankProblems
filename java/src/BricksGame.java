import java.io.File;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/11/17.
 */
public class BricksGame {


    static long playBrickGame(int[] bricks)  {
        long result = 0;
        int blength = bricks.length;
        long[] memo = new long[blength];
        long[] sums = new long[blength];
        int[] revArray = new int[blength];
        for (int i = 0; i < blength; i++)  {
            revArray[blength-i-1] = bricks[i];
        }
        long curr = 0;
        for (int i = 0; i < blength; i++)  {
            curr += revArray[i];
            sums[i] = curr;
        }
        if (blength < 4)  {
            return sums[blength-1];
        }
        memo[0] = sums[0];
        memo[1] = sums[1];
        memo[2] = sums[2];
        for (int i = 3; i < blength; i++)  {
            long one = memo[i-3];
            long two = memo[i-2];
            long three = memo[i-1];
            if (one <= two && one <= three)  {
                memo[i] = sums[i] - one;
            }
            else if (two <= one && two <= three)  {
                memo[i] = sums[i] - two;
            }
            else  {
                memo[i] = sums[i] - three;
            }
        }
        return memo[blength - 1];
    }


    public static void main(String[] args)  {
        File f = new File("input.txt");
        try  {
            Scanner sc = new Scanner(f);
            int q = sc.nextInt();
            for (int i = 0; i < q; i++)  {
                int n = sc.nextInt();
                int[] bricks = new int[n];
                for (int j = 0; j < n; j++)  {
                    bricks[j] = sc.nextInt();
                }
                System.out.println(playBrickGame(bricks));
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
