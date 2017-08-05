import java.io.File;
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
            if (targets.isEmpty())  {
                System.out.println("NO");
                return false;
            }
            String curr = str.substring(i,i+1);
            boolean uppercase = !curr.toLowerCase().equals(curr);
            for (int j = targets.size() - 1; j >= 0; j--)  {
                String s = targets.get(j);
                String letter = "";
                if (s.length() > 0)  {
                    letter = s.substring(0,1);
                }
                if (letter.equalsIgnoreCase(curr))  {
                    targets.add(s.substring(1,s.length()));
                }
                else if (uppercase) {
                    targets.remove(j);
                }
            }
        }
        for (String s : targets)  {
            if (s.length() == 0)  {
                System.out.println("YES");
                return true;
            }
        }
        System.out.println("NO");
        return false;
    }


    public static void main(String[] args)  {
        File f = new File("input.txt");
        try {
            Scanner sc = new Scanner(f);
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                isAbb(sc.next(), sc.next());
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }

}
