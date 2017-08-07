import java.io.File;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/6/17.
 */
public class EqualCandies {

    static int numOperations(int[] nums)  {
        int min = 10000;
        for (int x : nums)  {
            if (x<min)  {
                min = x;
            }
        }
        int minOps = 0;
        int min1Ops = 0;
        int min2Ops = 0;
        for (int i : nums)  {
            boolean cond = i == 0;
            if (cond)  {
                //System.out.println(minOps);
            }
            int target = i - min;
            minOps += target / 5;
            target = target % 5;
            minOps += target / 2;
            target = target % 2;
            minOps += target;
            int min1 = i - min + 1;
            int min2 = i - min + 2;
            min1 = (min1 >= 0) ? min1 : 0;
            min2 = (min2 >= 0) ? min2 : 0;
            min1Ops += min1 / 5;
            min1 = min1 % 5;
            min1Ops += min1 / 2;
            min1 = min1 % 2;
            min1Ops += min1;
            min2Ops += min2 / 5;
            min2 = min2 % 5;
            min2Ops += min2 / 2;
            min2 = min2 % 2;
            min2Ops += min2;
            if (cond)  {
                //System.out.println(minOps);
            }
        }/*
        System.out.println(minOps);
        System.out.println(min1Ops);
*/
        if (min2Ops < min1Ops && min2Ops < minOps)  {
            return min2Ops;
        }
        return (min1Ops < minOps) ? min1Ops : minOps;
    }


    public static void main(String[] args) {
        File f = new File("input.txt");
        try  {
            Scanner sc = new Scanner(f);
            int q = sc.nextInt();
            for (int i = 0; i < q; i++)  {
                int n = sc.nextInt();
                int[] nums = new int[n];
                for (int j = 0; j < n; j++)  {
                    nums[j] = sc.nextInt();
                }
                System.out.println(numOperations(nums));
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
