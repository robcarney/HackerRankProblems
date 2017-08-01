import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by robertcarney on 7/31/17.
 */
public class DFS {



    public static void main(String[] args)  {
        File file = new File("input1.txt");
        List<Long> costs = new ArrayList<>();
        try {
            Scanner in = new Scanner(file);
            int q = in.nextInt();
            for (int i = 0; i < q; i++)  {
                int n = in.nextInt();
                int m = in.nextInt();
                
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
