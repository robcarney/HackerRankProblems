import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/26/17.
 */
public class LIS {

    static int binarySearch(int[] seq, int[] tI, int r, int l, int key)  {
        while (r - l > 1)  {
            int m = (l+r)/2;
            if (seq[tI[m]] >= key)  {
                r = m;
            }  else  {
                l = m;
            }
        }
        return r;
    }

    static int longestIS(int[] seq)  {
        int n = seq.length;
        int[] tI = new int[n];
        Arrays.fill(tI,0);
        int[] pI = new int[n];
        Arrays.fill(pI,-1);
        int len = 1;
        for (int i = 1; i < n; i++)  {
            if (seq[i] < seq[tI[0]])  {
                tI[0] = i;
            } else if (seq[i] > seq[tI[len-1]])  {
                pI[i] = tI[len-1];
                tI[len++] = i;
            }  else  {
                int pos = binarySearch(seq, tI, len - 1, -1, seq[i]);
                tI[pos] = i;
                pI[i] = (pos!=0) ? tI[pos - 1] : -1;
            }
        }
        int count = 0;
        for (int i = tI[len-1]; i >= 0; i = pI[i])  {
            count++;
        }
        return count;
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
