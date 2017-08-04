import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by robertcarney on 8/4/17.
 */
public class QuickSort {

    public static int partition(ArrayList<Integer> list, int lo, int hi)  {
        for (int i : list)  {
            System.out.print(i);
        }
        System.out.println("");
        int pivot = list.get(hi);
        int i = lo - 1;
        for (int j = lo; j < hi; j++)  {
            if (list.get(j) < pivot)  {
                i++;
                int ph = list.get(j);
                list.set(j, list.get(i));
                list.set(i, ph);
            }
        }
        if (list.get(hi) < list.get(i+1))  {
            int ph = list.get(hi);
            list.set(hi, list.get(i+1));
            list.set(i+1, ph);
        }
        return i + 1;
    }

    public static void quicksort(ArrayList<Integer> list, int hi, int low)  {
        if (low < hi)  {
            int p = partition(list, low, hi);
            quicksort(list, p-1, low);
            quicksort(list, hi, p+1);
        }
    }


    public static void main(String[] args)  {
        int[] list = new int[] {1, 5, 3, 4, 2, 3, 12, 9, 5, 2, 3, 4, 2, 6,4 ,3};
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)  {
            arrayList.add(in.nextInt());
        }
        quicksort(arrayList, arrayList.size() - 1, 0);
    }
}
