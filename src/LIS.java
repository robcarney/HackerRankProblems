import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/26/17.
 */
public class LIS {
    static int longestIS(int[] seq)  {
        int sLength = seq.length;
        if (sLength == 0)  {
            return 0;
        }
        int[][] memoSeq = new int[sLength][sLength];
        int[] memoLengths = new int[sLength];
        int[] first = new int[sLength];
        first[0] = seq[0];
        memoSeq[0] = first;
        memoLengths[0] = 1;
        for (int i = 1; i < sLength; i++)  {
            int curr = seq[i];
            int[] workingList = new int[sLength];
            int listToUse = -1;
            int listSize = 0;
            for (int j = 0; j < i; j++)  {
                if (curr > seq[j] && memoLengths[j] >= listSize)  {
                    listToUse = j;
                    listSize = memoLengths[j];
                }
            }
            if (listToUse == -1)  {
                workingList[0] = curr;
            }
            else {
                int[] toCopy = memoSeq[listToUse];
                for (int x = 0; x < listSize; x++)  {
                    workingList[x] = toCopy[x];
                }
                workingList[listSize] = curr;
            }
            memoSeq[i] = workingList;
            memoLengths[i] = listSize + 1;
        }
        int maxSize = 0;
        for (int k = 0; k < sLength; k++)  {
            if (memoLengths[k] > maxSize)  {
                maxSize = memoLengths[k];
            }
        }
        return maxSize;
    }

    public static void main(String[] args)  {
        File f = new File("input.txt");
        try  {
            Scanner sc = new Scanner(f);
            int n = sc.nextInt();
            int[] seq = new int[n];
            for (int i = 0; i < n; i++)  {
                seq[i] = sc.nextInt();
            }
            System.out.println(longestIS(seq));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
