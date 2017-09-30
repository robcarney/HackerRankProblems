import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by robertcarney on 9/30/17.
 */
public class MthToLastElement {


    public static void main(String[] args) {
        File f = new File("input.txt");
        try  {
            Scanner sc = new Scanner(f);
            LinkedList<Integer> l = new LinkedList<>();
            int n = sc.nextInt();
            while (sc.hasNextInt())  {
                l.add(sc.nextInt());
            }
            int count = 1;
            while (count < n)  {
                l.pollLast();
                count++;
            }
            System.out.println(l.getLast());
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
