package Moderate;

/**
 * Created by amritachowdhury on 7/24/17.
 */
public class p5 {
    Integer left = -1; Integer right = -1;
    public void run() {
        int [] nums = new int[] {8};
        binarySearch(0, nums.length - 1, nums, 98);
        System.out.println(left);
        System.out.println(right);
    }
    public void binarySearch(int start, int end, int[]nums, int target) {
        if (start > end) {
            return;
        } else {
            int mid = (start + end) / 2;
            left = mid; right = mid;
            if (nums[mid] == target) {
                left = mid; right = mid;
                int i = mid;
                while (i >= start && nums[i] == target) {
                    left = i;
                    i--;
                }

                i = mid;
                while (i <= end && nums[i] == target) {
                    right = i;
                    i++;
                }

            } else if (nums[mid] < target) {
                binarySearch(mid + 1, end, nums, target);
            } else {
                binarySearch(mid - 1, end, nums, target);
            }
        }
    }
}
