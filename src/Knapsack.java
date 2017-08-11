import java.io.File;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/11/17.
 */
public class Knapsack {

    static int knapsack(int[] weights, int maxSum)  {
        if (maxSum == 0)  {
            return 0;
        }

        int[][] bestUpTo = new int[maxSum+1][weights.length+1];
        for (int i = 0; i <= maxSum; i++)  {
            bestUpTo[i][0] = 0;
        }
        for (int i = 0; i <= weights.length; i++)  {
            bestUpTo[0][i] = 0;
        }

        for (int i = 1; i <= weights.length; i++)  {
            int currWeight = weights[i-1];
            for (int j = 1; j <= maxSum; j++)  {
                int sumWithout = bestUpTo[j][i-1];
                if (currWeight > j)  {
                    bestUpTo[j][i] = sumWithout;
                } else {
                    int sumWith = bestUpTo[j - currWeight][i];
                    bestUpTo[j][i] = (sumWith > sumWithout) ? sumWith : sumWithout;
                }
            }
        }
        return bestUpTo[maxSum][weights.length];
    }

    public static void main(String[] args)  {
        File f = new File("input.txt");
        try  {
            Scanner sc = new Scanner(f);
            int q = sc.nextInt();
            for (int i = 0; i < q; i++)  {
                int n = sc.nextInt();
                int maxSum = sc.nextInt();
                int[] weights = new int[n];
                for (int j = 0; j < n; j++)  {
                    weights[j] = sc.nextInt();
                }
                System.out.println(knapsack(weights,maxSum));
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }

}
