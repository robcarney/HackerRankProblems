import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by robertcarney on 8/4/17.
 */
public class SubstringSum {

    static BigInteger substringSum(String num)  {
        BigInteger result = BigInteger.ZERO;
        ArrayList<String> workingList = new ArrayList<>();
        BigInteger toMod = new BigInteger("1000000007");
        /*
        for (int i = num.length() - 1; i >= 0; i--)  {
            for (String str : workingList)  {
                result = result.add(new BigInteger(str));
            }
            String s = num.substring(i, i+1);
            for (int j = 0; j < workingList.size(); j++)  {
                workingList.set(j, s + workingList.get(j));
            }
            workingList.add(s);
        }
        for (String str : workingList)  {
            result = result.add(new BigInteger(str));
        }*/
        for (int i = num.length() - 1; i >= 0; i--)  {
            String curr = num.substring(i,num.length());
            for (int j = 1; j <= curr.length(); j++)  {
                BigInteger toAdd = new BigInteger(curr.substring(0, j));
                result = result.add(toAdd);
            }
        }
        return result.mod(toMod);
    }

    public static void main(String[] args)  {
        System.out.println(substringSum("123"));
    }
}
