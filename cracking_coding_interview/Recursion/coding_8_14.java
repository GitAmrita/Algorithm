package Recursion;

/**
 * Created by amritachowdhury on 5/7/17.
 */
public class coding_8_14 {
    int ways = 0;
    public void getCount() {
        String expression = "1^0|0|1";
        getCount(expression);
        System.out.println(ways);
    }

    private boolean getCount(String s) {
        if (s.length() <= 3) {
            if (s.length() == 1) {
                return s.charAt(0) == '1';
            } else if (s.length() == 2) {
                return s.charAt(1) == '1';
            } else {
                return eval(s.charAt(0) == '1', s.charAt(2) == '1', s.charAt(1));
            }
        }
        else {
            boolean result = false;
            for (int i = 0; i < s.length() - 2 ; i = i+2) {
                String left = s.substring(0, i + 1);
                String right = s.substring(i + 2);
                boolean leftR = getCount(left);
                boolean rightR = getCount(right);
                char operator = s.charAt(i + 1);
                result = eval(leftR, rightR, operator);
                if (result != true && s.length() == 7) {
                    ways++;
                }
            }
            return result;
        }
    }

    private boolean eval(boolean left, boolean right, char operator) {
        switch (operator) {
            case '&' :
                return left && right;
            case '|':
                return left || right;
            case '^':
                return !(left || right);
            default :
                return true;
        }
    }
}
