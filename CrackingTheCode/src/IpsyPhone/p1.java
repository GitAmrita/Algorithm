package IpsyPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by amritachowdhury on 7/31/17.
 */
public class p1 {
List<String> result = new ArrayList<>();

    public void run() {
        int target = 14;
        List<Integer> input = new ArrayList<>();
        input.add(12); input.add(7); input.add(5); input.add(10);
        findAllCombinations(input);
        findTargetSolution(target);
    }

    private void findAllCombinations(List<Integer> input) {
        if (input.size() == 1) {
            result.add(String.valueOf(input.get(0))) ;
        } else {
            String firstNumber = String.valueOf(input.get(0));
            input.remove(0);
            findAllCombinations(input);
            List<String> temp = new ArrayList<>(result);
            for (String s : temp) {
                result.add( firstNumber + " + " + s);
                result.add( firstNumber + " - " + s);
                result.remove(s);
            }
        }
    }

    private void findTargetSolution(int target) {
        boolean foundAtLeastOne = false;
        for (String s : result) {
            int val = calculate(s);
            if (val == target) {
                foundAtLeastOne = true;
                System.out.println(s);
            }
        }
        if (!foundAtLeastOne) {
            System.out.println("no solution");
        }
    }

    private int calculate(String equation) {
        Stack<Integer> operand = new Stack<>();
        Stack<String> operator = new Stack<>();
        boolean isLastOperand = false;
        for (int i = 0; i < equation.length(); i++) {
            String p = equation.substring(i, i + 1);
            if (isOperand(p)) {
                if (isLastOperand) {
                    int popped = operand.pop();
                    operand.push(Integer.parseInt(String.valueOf(popped) + p));
                } else {
                    operand.push(Integer.parseInt(p));
                }
                isLastOperand = true;
            } else {
                if (p.equals("+") || p.equals("-")) {
                    operator.push(equation.substring(i, i + 1));
                }
                isLastOperand = false;
            }
        }
        while (!operator.isEmpty()) {
            int no1 = operand.pop();
            int no2 = operand.pop();
            String operatorSign = operator.pop();
            if (operatorSign.equals("+")) {
                operand.push(no1 + no2);
            } else {
                operand.push(no2 - no1);
            }
        }
        return operand.pop();
    }

    private boolean isOperand(String c) {
        try {
            Integer.parseInt(c);
            return true;

        } catch(Exception ex) {
            return false;
        }
    }
}
