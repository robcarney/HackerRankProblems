import java.io.File;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/5/17.
 */
public class BotPrincess1 {

    public static void main(String[] args)  {
        File f = new File("input.txt");
        try  {
            Scanner s = new Scanner(f);
            int n = Integer.parseInt(s.nextLine());
            int botX = 0;
            int botY = 0;
            int princessX = 0;
            int princessY = 0;
            for (int i = 0; i < n; i++)  {
                String curr = s.nextLine();
                if (curr.contains("m"))  {
                    botX = curr.indexOf("m");
                    botY = i;
                }
                if (curr.contains("p"))  {
                    princessX = curr.indexOf("p");
                    princessY = i;
                }
            }
            while (botX != princessX || botY != princessY)  {
                int xDiff = botX - princessX;
                int yDiff = botY - princessY;
                if (xDiff > 0)  {
                    System.out.println("LEFT");
                    botX--;
                }
                if (xDiff < 0)  {
                    System.out.println("RIGHT");
                    botX++;
                }
                if (yDiff > 0)  {
                    System.out.println("UP");
                    botY--;
                }
                if (yDiff < 0)  {
                    System.out.println("DOWN");
                    botY++;
                }
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
