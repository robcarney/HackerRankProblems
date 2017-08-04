import java.util.ArrayList;

/**
 * Created by robertcarney on 8/4/17.
 */
public class SubstringSum {

    static int substringSum(String num)  {
        int result = 0;
        ArrayList<String> workingList = new ArrayList<>();
        for (int i = 0; i < num.length(); i++)  {
            for (String str : workingList)  {
                result += Integer.parseInt(str);
            }
            String s = num.substring(i, i+1);
            for (int j = 0; j < workingList.size(); j++)  {
                workingList.set(j, s + workingList.get(j));
            }
            workingList.add(s);
        }
        for (String str : workingList)  {
            result += Integer.parseInt(str);
        }
        return result;
    }

    public static void main(String[] args)  {
        System.out.println(substringSum("123"));
    }
}
