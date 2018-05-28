import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by robertcarney on 9/30/17.
 */
public class MthToLastElement {


    public static void main(String[] args) {
        File f = new File("input.txt");
        try  {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            LinkedList<Integer> l = new LinkedList<>();
            int n = Integer.parseInt(sc.readLine());
            String[] strings = sc.readLine().split(" ");
            int i = strings.length;
            if (i < n)  {
                System.out.println("NIL");
                return;
            }
            System.out.println(strings[i-n]);
            /*
            for (String str : strings)  {
                l.add(Integer.parseInt(str));
            }
            int count = 1;
            while (count < n)  {
                l.pollLast();
                count++;
            }
            System.out.println(l.getLast());*/
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
