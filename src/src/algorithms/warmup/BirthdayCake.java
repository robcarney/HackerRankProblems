package algorithms.warmup;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayCake {

  static int birthdayCakeCandles(int n, int[] ar) {
    HashMap<Integer,Integer> freqs = new HashMap<>();
    int max = 0;
    for (int i : ar)  {
      if (i > max) { max = i; }
      int curr = 0;
      if (freqs.get(i) != null) { curr = freqs.get(i); }
      freqs.put(i,curr+1);
    }
    return freqs.get(max);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for(int ar_i = 0; ar_i < n; ar_i++){
      ar[ar_i] = in.nextInt();
    }
    int result = birthdayCakeCandles(n, ar);
    System.out.println(result);
  }
}
