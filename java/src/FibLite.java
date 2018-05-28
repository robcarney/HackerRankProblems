import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by robertcarney on 9/30/17.
 */
public class FibLite {

    public static void main(String[] args) {
        File f = new File("input.txt");
        try  {
            BigInteger[] memo = new BigInteger[101];
            Scanner sc = new Scanner(f);
            memo[0] = BigInteger.ZERO;
            memo[1] = BigInteger.ONE;
            for (int i = 2; i <= 100; i++)  {
                memo[i] = memo[i-1].add(memo[i-2]);
            }
            while (sc.hasNextInt())  {
                System.out.println(memo[sc.nextInt()]);
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
