import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by robertcarney on 7/17/17.
 */
public class MiniMaxSum {
  public static void main(String[] args)  {
    List<BigInteger> nums = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    while (in.hasNext())  {
      nums.add(BigInteger.valueOf(Long.parseLong(in.next())));
    }
    /*
    for (String s : args)  {
      nums.add(Integer.parseInt(s));
    }
    */
    BigInteger max = nums.get(0);
    BigInteger min = nums.get(0);
    BigInteger sum = BigInteger.ZERO;
    for (BigInteger i : nums)  {
      if (i.compareTo(min) < 0)  { min = i; }
      if (i.compareTo(max) > 0)  { max = i; }
      sum = sum.add(i);
    }
    String maxSum = sum.subtract(min).toString();
    String minSum = sum.subtract(max).toString();
    System.out.println(minSum + " " + maxSum);
  }

}
