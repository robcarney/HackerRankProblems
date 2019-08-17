import java.util.ArrayList;

public class LongestPalindrome {
    static String longestPalindrome(String str) {
        int bestLength = 0;
        int bestStart = 0;
        int bestEnd = 0;
        for (int i = 0; i < str.length(); i++) {
            int currLength = 1;
            int currStart = i;
            int currEnd = i+1;
            int j = 1;
            while ((i-j >= 0) && (i+j < str.length()) && 
                   (str.charAt(i-j) == str.charAt(i+j))) {
                currLength += 2;
                currStart--;
                currEnd++;
                j++;
            }
            if (currLength > bestLength)  {
                bestLength = currLength;
                bestStart = currStart;
                bestEnd = currEnd;
            }
        }
        for (int i = 0; i < str.length() - 1; i++)  {
            if (str.charAt(i) != str.charAt(i+1))  {
                continue;
            }
            int currLength = 2;
            int currStart = i;
            int currEnd = i+2;
            int j = 1;
            while ((i-j >= 0) && (i+j+1 < str.length()) && 
                   (str.charAt(i-j) == str.charAt(i+j+1))) {
                currLength += 2;
                currStart--;
                currEnd++;
                j++;
            }
            if (currLength > bestLength)  {
                bestLength = currLength;
                bestStart = currStart;
                bestEnd = currEnd;
            }
        }
        return str.substring(bestStart, bestEnd);
    }

    public static void main(String[] args)  {
        String result = longestPalindrome("aaaabbaa");
        System.out.println(result);
    }
}
