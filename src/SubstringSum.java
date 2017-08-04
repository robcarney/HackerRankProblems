import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by robertcarney on 8/4/17.
 */
public class SubstringSum {

    static long intSubSum(String num)  {
        long result = 0;
        long[] tenPowTable = new long[num.length()];
        long toAdd = 1;
        long toMult = 1;
        int toMod = 1000000007;
        for (int k = 0; k < num.length(); k++)  {
            if (k != 0) {
                toAdd = (toAdd + toMult) % toMod;
            }
            toMult = (toMult * 10) % toMod;
            tenPowTable[k] = toAdd % toMod;
        }
        for (int i = 0; i < num.length(); i++)  {
            int curr = Integer.parseInt(num.substring(i,i+1));
            int tensInd = num.length() - i - 1;
            result += (curr * ((i + 1) * tenPowTable[tensInd])) % toMod;
        }
        return result % toMod;
    }

    public static void main(String[] args)  {
        System.out.println(intSubSum("960880276897"));
    }
}
