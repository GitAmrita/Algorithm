/**
 * Created by achowdhury on 6/18/2015.
 */
//google : http://www.careercup.com/question?id=5647476964982784
public class NoFrequency {

    public void FindBounds() {
        int[] a = new int[]{1, 1, 2, 3, 3, 3,3,3,3,3,3,3,3 ,4, 5};
        int beg = 0;
        int end = a.length - 1;
        int val = 1;
        // searching upper bound
        while(beg < end) {
            int mid = (beg + end) / 2;
            if(val >= a[mid]) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }
        int upper_bnd = beg;

        //searching lower bound
        beg = 0;
        end = a.length-1;
        while(beg < end) {
            int mid = (beg + end)/2;
            if(a[mid] < val) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }
        int lower_bnd = beg;

        System.out.println(upper_bnd-lower_bnd);
    }
}
