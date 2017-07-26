import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by robertcarney on 7/24/17.
 */
public class CriticsScore {


  public static void main(String[] args)  {
    File f = new File("");
    Scanner sc;
    try {
      sc = new Scanner(f);
    } catch (FileNotFoundException ex)  {
      System.out.println("file not found");
    }



  }

}
