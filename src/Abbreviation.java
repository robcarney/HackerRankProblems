import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/4/17.
 */
public class Abbreviation {


    static boolean isAbb(String str, String target)  {
        boolean[][] memo = new boolean[str.length()+1][target.length()+1];
        memo[0][0] = true;
        int strSize = str.length();
        int tSize = target.length();
        for (int i = strSize; i > 0; i--)  {
            String curr = str.substring(i-1,strSize);
            if (curr.equals(curr.toLowerCase()))  {
                memo[strSize - i + 1][0] = true;
            }
        }
        for (int i = strSize; i > 0; i--)  {
            int iIndex = strSize - i + 1;
            String currS = str.substring(i-1,i);
            boolean uppercase = !currS.equals(currS.toLowerCase());
            for (int j = tSize; j > 0; j--)  {
                int jIndex = tSize - j + 1;
                String currT = target.substring(j-1,j);
                if (currS.equalsIgnoreCase(currT))  {
                    if (uppercase)  {
                        memo[iIndex][jIndex] = memo[iIndex-1][jIndex-1];
                    }
                    else {
                        memo[iIndex][jIndex] = (memo[iIndex - 1][jIndex - 1] || memo[iIndex - 1][jIndex]);
                    }
                }
                else if (uppercase)  {
                    memo[iIndex][jIndex] = false;
                }
                else  {
                    memo[iIndex][jIndex] = memo[iIndex-1][jIndex];
                }
            }
        }
        if (memo[strSize][tSize])  {
            System.out.println("YES");
            return true;
        }
        System.out.println("NO");
        return false;
    }


    static void printBoolArray(boolean[][] arr)  {
        for (boolean[] x : arr)  {
            for (boolean b : x)  {
                String curr = (b) ? "1 " : "0 ";
                System.out.print(curr);
            }
            System.out.println();
        }
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
