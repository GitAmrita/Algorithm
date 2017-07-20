/**
 * Created by amritachowdhury on 7/18/17.
 */
public class FacebookPhoneInterview {
    public void run() {
        int[] a = new int [] {1, 0, -5, 0, 7};
        int[] result = reArrange(a);
        System.out.println(result.length);
    }

    private int[] reArrange(int[] a) {
        int begin = 0; int end = a.length - 1;
        if (a.length == 0) {
            return null;
        }
        while (begin < end) {
            if (a[begin] != 0) {
                begin++;
            } else {
                if (a[end] == 0) {
                    end --;
                } else {
                    a = swap(begin, end, a);
                    begin++;
                    end--;
                }
            }
        }
        System.out.println("number of non zero numbers : " + begin);
        return a;
    }

    private int[] swap(int begin, int end, int[]a) {
        int temp = a[begin];
        a[begin] = a[end];
        a[end] = temp;
        return a;
    }
}
