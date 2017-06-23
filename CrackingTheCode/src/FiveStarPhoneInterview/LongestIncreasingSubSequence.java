package FiveStarPhoneInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amritachowdhury on 6/8/17.
 */
//https://www.glassdoor.com/Interview/FiveStars-Software-Engineer-Interview-Questions-EI_IE447133.0,9_KO10,27.htm
// Find the longest increasing subset of a given list
//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class LongestIncreasingSubSequence {

    public void run() {
        int input[] = {2, 5, 3, 1, 2, 3, 4, 5, 6};
        List<Integer> longestIncreasingSubSequence = getLongestIncreasingSubSequence(input);
        System.out.println(Arrays.toString(longestIncreasingSubSequence.toArray()));
    }

    private List<Integer> getLongestIncreasingSubSequence(int [] input) {
        List<List<Integer>> activeList = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (isElementSmallestInActiveEndElements(input[i], activeList)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(input[i]);
                activeList.add(temp);
            } else if (isElementGreatestInActiveEndElements(input[i], activeList)) {
                List<Integer> greatestList = activeList.get(activeList.size() - 1);
                activeList.add(cloneAndExtendList(input[i], greatestList));
            } else {
                elementInMiddle(input[i], activeList);
            }
        }
        return activeList.get(activeList.size() - 1);
    }

    private boolean isElementSmallestInActiveEndElements(int val, List<List<Integer>> list ) {
        if (list.size() == 0) {
            return true;
        }
        List<Integer> smallestList = list.get(0);
        int smallestEndElement = smallestList.get(smallestList.size() - 1);
        return val < smallestEndElement;
    }

    private boolean isElementGreatestInActiveEndElements(int val, List<List<Integer>> list) {
        if (list.size() == 0) {
            return true;
        }
        List<Integer> greatestList = list.get(list.size() - 1);
        int greatestEndElement = greatestList.get(greatestList.size() - 1);
        return val > greatestEndElement;
    }

    private void elementInMiddle(int val, List<List<Integer>> list) {
        if (list.size() == 0) {
            return;
        }
        int greaterThanIndex = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            List<Integer> temp = list.get(i);
            int lastElementInList = temp.get(temp.size() - 1);
            if (val > lastElementInList) {
                greaterThanIndex = i;
                break;
            }
        }
        List<Integer> toBeCloned = list.get(greaterThanIndex);
        List<Integer> clonedAndExtendedList = cloneAndExtendList(val, toBeCloned);
        list.add(greaterThanIndex + 1, clonedAndExtendedList);
        for (int j = greaterThanIndex + 2; j < list.size(); j++) {
            List<Integer> temp = list.get(j);
            if (temp.size() == clonedAndExtendedList.size()) {
                list.remove(j);
            } else if (temp.size() > clonedAndExtendedList.size()) {
                break;
            }
        }
    }

    private List<Integer> cloneAndExtendList(int val, List<Integer> list) {
        ArrayList<Integer> clonedAndExtendedList = new ArrayList<>(list);
        clonedAndExtendedList.add(val);
        return clonedAndExtendedList;

    }

}
