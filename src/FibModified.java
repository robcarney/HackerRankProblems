import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/4/17.
 */
public class FibModified {

    public static BigInteger runFib(BigInteger n1, BigInteger n2, int end)  {
        BigInteger[] memo = new BigInteger[end];
        if (end == 1)  {
            return n1;
        }
        if (end == 2)  {
            return n2;
        }
        memo[0] = n1;
        memo[1] = n2;
        for (int i = 2; i < end; i++)  {
            BigInteger first = memo[i-2];
            BigInteger second = memo[i-1];
            memo[i] = first.add(second.multiply(second));
        }
        return memo[end - 1];
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        BigInteger t1 = new BigInteger(sc.next());
        BigInteger t2 = new BigInteger(sc.next());
        int n = sc.nextInt();
        System.out.println(runFib(t1, t2, n));
    }
}
