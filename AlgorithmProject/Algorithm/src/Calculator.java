import java.util.Stack;
//calculator operation
/**
 * Created by achowdhury on 7/11/2015.
 */
//infix to postfix conversion:
    /*
    * 1. Loop the string and Add any operand to the output string
    * 2. For the 1st operator encountered push it to the stack
    * 3. For all other operators check if the top of stack operator has greater or equal precedence, in that case
    * pop the higher precedence operators and append to the output string. Push the latest operator to the stack
    * 4. Any bracket encountered just push them in stack
    * 5.When the string length is reached append the stack remains to the string
    * 6.This is the postfix string , ignore any bracket in the string
    * */
    //postfix to calculate value
    /*
    1.Read each character and push it to stack if it is a operand
    2.When operator is encountered pop the stack twice , the deeper level operand is the first operand, and implement the operator
     and push back the result in the stack
    3.Keep doing till the last character
    4. The last value in the stack is the result
    * */
 public class Calculator {
    private int PrecedenceChart(char a){
        switch(a){
            case '^' :
                return 4;
            case  '/' :
                return 3;
            case  '*' :
                return 2;
            case  '+' :
                return 1;
            case  '-' :
                return  1;
            default :
                return 1;
        }
    }
    private Boolean isGreaterPrecedence(char a, char b){
        if(a == '(' || a == ')')
            return false ;
        return PrecedenceChart(a) >= PrecedenceChart(b);
    }
    private Boolean isOperator(char val){
        if(val == '^' || val == '+' || val == '-' || val == '*' || val == '/')
            return true;
        else return false;
    }
    private Boolean isBracket(char val){
        if(val == '(' || val == ')')
            return true;
        else return false;
    }
    private String ConvertToPostFix(String infix){
        Stack<Character> st = new Stack<Character>();
        String postFix = "";
        for(int i = 0; i < infix.length(); i++){
            char thisChar = infix.charAt(i);
            if(thisChar == ' ')//ignore spaces in between
                continue;
            if(! isOperator(thisChar)  &&  ! isBracket(thisChar))//this is an operand add to postFix string
                postFix = postFix + thisChar;
            else if(isOperator(thisChar)){//this is an operator
                if(st.isEmpty()) // first operator encountered just push to stack
                    st.push(thisChar);
                else{ // all operators having higher precedence than thisChar gets added to postfix string
                    while( ! st.isEmpty()){
                        if(isGreaterPrecedence(st.peek(), thisChar))
                            postFix = postFix + st.pop();
                        else break;
                    }
                    st.push(thisChar);
                }
            }
            else // push the bracket in the stack
                st.push(thisChar);
        }//end of for loop
        while(! st.isEmpty()){//empty the bracket in the postfix string
            char c = st.pop();
            if( ! isBracket(c))
                postFix = postFix + c;
        }
        return postFix ;
    }
    private int Compute(int firstOperand, int secondOperand, char operator){
        switch(operator){
            case '^' :
                double f = (double) firstOperand;
                double s = (double) secondOperand;
                return(int) Math.pow(f,s) ;
            case '/' :
                return firstOperand / secondOperand ;
            case '*' :
                return firstOperand * secondOperand ;
            case '+' :
                return firstOperand + secondOperand ;
            case '-' :
                return firstOperand - secondOperand ;
            default :
                return 0 ;
        }
    }
    private int CalculateValue(String postFix){
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0 ; i < postFix.length(); i++){
            char thisChar = postFix.charAt(i);
            if(! isOperator(thisChar))
                st.push(Integer.parseInt(Character.toString(thisChar)));
            else{
                int secondOperand = st.pop();
                int firstOperand = st.pop();
                int result = Compute(firstOperand, secondOperand, thisChar);
                st.push(result);
            }
        }
        return st.pop();
    }
    public void CalculateEquation(){
        String infix = "4^2*3-3+8/4/(1+1)";
        String postFix = ConvertToPostFix(infix);
        System.out.println("POSTFIX EXPRESSION : " + postFix);
        int result = CalculateValue(postFix);
        System.out.println("RESULT : " +  result);
    }
}
