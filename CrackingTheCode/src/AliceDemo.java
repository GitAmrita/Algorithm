
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by amritachowdhury on 7/20/17.
 */
public class AliceDemo {

    public void run() {
       // String result = getBinarySearch();
      //  System.out.println(result);
        int[] g = oddNumbers(1, 10);
        System.out.println(Arrays.toString(g));
    }

    private String getBinarySearch() {
        Scanner scan = new Scanner(System.in);
        int noOfElements = Integer.parseInt(scan.nextLine());
        int [] s = new int[noOfElements];
        for (int i = 0; i < noOfElements; i++) {
            s[i] = Integer.parseInt(scan.nextLine());
        }
        int target = Integer.parseInt(scan.nextLine());
        Arrays.sort(s);
        boolean found = binarySearch(s, target, 0, noOfElements - 1);
        return found ? "YES" : "NO";
    }

    public boolean binarySearch(int arr[], int x, int l, int r)
    {
        if (l < r)
        {
            int mid = (l + r - 1)/2;
            if (arr[mid] == x)
                return true;
            if (arr[mid] > x)
                return binarySearch(arr, x, l, mid - 1);
            return binarySearch(arr, x,mid + 1, r);
        }
        return false;
    }

    public int[] oddNumbers(int l, int r) {
       int[] odd = new int[(r - l) / 2 + 1];
       int m = 0;
        m = isOdd(l) ? l : l + 1;
        int count = 0;
       while ( m <= r) {
           odd[count] = m;
           m += 2;
           count ++;
       }
       return odd;
    }

    private boolean isOdd(int no) {
        return no % 2 == 1;
    }
}
