import java.util.*;

/**
 * Created by amritachowdhury on 7/11/17.
 */

// input -> [(0, 4), (1, 3), (5, 8), (9, 12)
// output -> [(0,4), (5, 8), (9, 12)]
public class KiwiCrateInterview  {
    public class TestSteps implements Comparable<TestSteps> {
        int startStep, stopStep;
        public TestSteps(int startStep, int stopStep) {
            this.startStep = startStep;
            this.stopStep = stopStep;
        }

        @Override
        public int compareTo(TestSteps other) {
            if(this.startStep > other.startStep)
                return 1;
            else if (this.startStep == other.startStep)
                return 0 ;
            return -1 ;
        }
    }

    public void run() {
        TestSteps[] testSteps = createInput();
        List<TestSteps> output = minimizeTestCases(testSteps);
        for (int i = 0; i < output.size(); i++) {
            System.out.println("start : " + output.get(i).startStep + " stop : " + output.get(i).stopStep );
        }
    }

    private List<TestSteps> minimizeTestCases(TestSteps[] input) {
        Arrays.sort(input);
        List<TestSteps> output = new ArrayList<>() ;
        int outer = 0; int inner = outer + 1;
        while (inner < input.length) {
            if (input[outer].stopStep >= input[inner].stopStep) {
                output.add(input[outer]);
                inner ++;
            } else {
                if (input[outer].stopStep < input[inner].startStep) {
                    output.add(input[inner]);
                } else {
                    output.remove(output.size() - 1);
                    output.add(new TestSteps(input[outer].startStep, input[inner].stopStep));
                }
                outer = inner;
                inner = outer + 1;
            }
        }
        return output;

    }

    private TestSteps[] createInput() {
        TestSteps[] testCases = new TestSteps[4];
        TestSteps t1 = new TestSteps(0, 4);
        TestSteps t2 = new TestSteps(1, 3);
        TestSteps t3 = new TestSteps(5, 8);
        TestSteps t4 = new TestSteps(9, 12);
        testCases[0] = t4; testCases[1] = t2; testCases[2] = t1; testCases[3] = t3;
        return testCases;
    }
}