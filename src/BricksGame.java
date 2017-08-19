import java.io.File;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/11/17.
 */
public class BricksGame {


    static long playBrickGame(int[] bricks)  {
        long result = 0;
        long[] memo = new long[bricks.length];
        long[] sums = new long[bricks.length];
        int[] revArray = new int[bricks.length];
        for (int i = 0; i < bricks.length; i++)  {
            
        }
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
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
