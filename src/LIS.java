import java.io.File;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/26/17.
 */
public class LIS {

    static int longestIS(ArrayList<Integer> seq)  {
        if (seq.isEmpty())  {
            return 0;
        }
        ArrayList<ArrayList<Integer>> memo = new ArrayList<>();
        memo.add(new ArrayList<>());
        memo.get(0).add(seq.get(0));
        for (int i = 1; i < seq.size(); i++)  {
            int curr = seq.get(i);
            ArrayList<Integer> workingList = new ArrayList<>();
            int listToUse = -1;
            int listSize = 0;
            for (int j = 0; j < i; j++)  {
                ArrayList<Integer> currList = memo.get(j);
                if (curr < currList.get(currList.size() - 1) && currList.size() >= listSize)  {
                    listToUse = j;
                    listSize = currList.size();
                }
            }
            if (listToUse == -1)  {
                workingList.add(curr);
            }
            else {
                ArrayList<Integer> toCopy = memo.get(listToUse);
                for (int x : toCopy)  {
                    workingList.add(x);
                }
                workingList.add(curr);
            }
            memo.add(workingList);
        }
        int maxSize = 0;
        for (ArrayList<Integer> list : memo)  {
            if (list.size() > maxSize)  {
                maxSize = list.size();
            }
        }
        return maxSize;
    }


    public static void main(String[] args)  {
        File f = new File("input.txt");
        try  {
            Scanner sc = new Scanner(f);
            int n = sc.nextInt();
            ArrayList<Integer> seq = new ArrayList<>();
            for (int i = 0; i < n; i++)  {
                seq.add(sc.nextInt());
            }
            System.out.println(longestIS(seq));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
