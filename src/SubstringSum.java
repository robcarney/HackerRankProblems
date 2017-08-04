import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by robertcarney on 8/4/17.
 */
public class SubstringSum {

    static BigInteger substringSum(String num)  {
        BigInteger result = BigInteger.ZERO;
        ArrayList<String> workingList = new ArrayList<>();
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
        }
        BigInteger toMod = new BigInteger("7000000000");
        return result.mod(toMod);
    }

    public static void main(String[] args)  {
        System.out.println(substringSum("16543"));
    }
}
