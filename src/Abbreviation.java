import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/4/17.
 */
public class Abbreviation {


    static boolean isAbb(String str, String target)  {
        List<String> targets = new ArrayList<>();
        targets.add(target);
        for (int i = 0; i < str.length(); i++)  {
            String curr = str.substring(i,i+1);
            boolean uppercase = !curr.toLowerCase().equals(curr);
            for (int j = targets.size() - 1; j >= 0; j--)  {
                String s = targets.get(j);
                String letter = s.substring(0,1);
                if (letter.equalsIgnoreCase(curr))  {
                    if (s.length() == 1)  {
                        System.out.println("YES");
                        return true;
                    }
                    targets.add(s.substring(1,s.length()));
                }
                else if (uppercase) {
                    targets.remove(j);
                }
            }
        }
        System.out.println("NO");
        return false;
    }


    public static void main(String[] args)  {
        System.out.println(isAbb("daBcd", "ACB"));
    }

}
