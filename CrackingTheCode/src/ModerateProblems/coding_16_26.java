package ModerateProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by amritachowdhury on 7/6/17.
 */
public class coding_16_26 {
    Map<String, Integer> priorityMap = new HashMap<>();

    public void run() {
        setPriorityOfOperators();
        String equation = "5 * 10 + 8 - 4 / 2";
        double result = calculateEquation(equation);
        System.out.println(result);
    }

    private double calculateEquation(String equation) {
        String[] operandsAndOperators = equation.split("\\s+");
        Stack<Double> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        for (int i = 0; i < operandsAndOperators.length; i++ ) {
            if (operandsAndOperators[i].isEmpty()) {continue;}
            if (isOperand(operandsAndOperators[i])) {
                operandStack.push(Double.parseDouble(operandsAndOperators[i]));
            } else if ( operatorStack.empty() || isHigherPriority(operandsAndOperators[i], operatorStack.peek())) {
                operatorStack.push(operandsAndOperators[i]);
            } else {
                double no2 = operandStack.pop();
                double no1 = operandStack.pop();
                String operator = operatorStack.pop();
                double result = calculate(no1, no2, operator);
                operandStack.push(result);
                operatorStack.push(operandsAndOperators[i]);
            }
        }
        while (!operatorStack.empty()) {
            double no2 = operandStack.pop();
            double no1 = operandStack.pop();
            String operator = operatorStack.pop();
            double result = calculate(no1, no2, operator);
            operandStack.push(result);
        }
        return operandStack.pop();
    }

    private boolean isOperand(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isHigherPriority(String value, String topOfStack) {
       int priorityOfCurrent = priorityMap.get(value);
       int priorityOfTopOfStack = priorityMap.get(topOfStack);
       return priorityOfCurrent > priorityOfTopOfStack;
    }

    private void setPriorityOfOperators() {
        priorityMap.put("/", 2); priorityMap.put("*", 2); priorityMap.put("-", 1); priorityMap.put("+", 1);
    }

    private double calculate(double no1, double no2, String operator) {
        switch (operator) {
            case "/" : return no1 / no2;
            case "*" : return no1 * no2;
            case "-" : return no1 - no2;
            case "+" : return no1 + no2;
            default : return 0;
        }
    }
}
