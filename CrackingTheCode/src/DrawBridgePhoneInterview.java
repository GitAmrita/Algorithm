import java.util.HashMap;
import java.util.Map;

/**
 * Created by amritachowdhury on 7/19/17.
 */
public class DrawBridgePhoneInterview {

    public void getSubArray(int[] a, int target) {
        int currSum = 0; int beginIdx = 0; int endIdx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];
            int remainingNo = currSum - target;
            if (currSum == target) {
                endIdx = i;
                break;
            } else if (map.get(remainingNo) != null) {
                beginIdx = map.get(remainingNo) + 1;
                endIdx = i;
                break;
            } else {
                map.put(currSum, i);
            }
        }
        if (beginIdx == endIdx) {
            System.out.println("No such subarray found");
        } else {
            System.out.println("subarray : " + beginIdx + ", " + endIdx);
        }
    }

    public void testCase() {
        int[] a = new int[] {-10, 5, 2, -2, -20, 10};
        int target = 0;
        getSubArray(a, target);
    }
}
