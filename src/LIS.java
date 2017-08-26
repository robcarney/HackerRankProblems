import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/26/17.
 */
public class LIS {

    static int longestIS(int[] seq)  {
        ArrayList<ArrayList<Integer>> memo = new ArrayList<>();
        
    }


    public static void main(String[] args)  {
        File f = new File("input.txt");
        try  {
            Scanner sc = new Scanner(f);
            int n = sc.nextInt();
            int[] seq = new int[n];
            for (int i = 0; i < n; i++)  {
                seq[i] = sc.nextInt();
            }
        } catch (Exception ex) {

        }
    }
}
