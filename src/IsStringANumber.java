

/**
 * Created by achowdhury on 7/9/2015.
 */
public class IsStringANumber {

    public void IsNumber(){
        String str = "0123456789";
        Boolean isFirstChar = true;
        Boolean decimal = false;
        Boolean isNumberFlag = true;
        for(int i = 0 ; i< str.trim().length(); i++){
            if(!isNumberFlag)
                break;
            char currChar = str.charAt(i);
            //ignore spaces
            if(currChar == ' ')
                continue;
            if(i > 0)
                isFirstChar = false;
            //first char can be - or $ or between 0 to 9 or decimal. Anything else should be not treated as number
            if(isFirstChar){
                switch(currChar){
                    case '-':case '$' :case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                        break;
                    case '.' :
                        decimal = true;
                        break;
                    default:
                        isNumberFlag = false;
                }
            }
            else{
                if(currChar == '$'){
                    //$ can only be 1st or 2nd char. In case it is 2nd char , the first char has to be -
                    if(i == 1 && str.charAt(0) == '-' )
                        continue;
                    else
                        isNumberFlag = false;
                }
                //. encountered
               else if(currChar == '.'){
                    //but we have already seen decimal earlier in the string so this is not a valid decimal point
                    if(decimal)
                        isNumberFlag = false;
                    //the number looks like is a decimal
                    else
                        decimal = true;
                }
                //char is between 0 to 9
                else if((int)currChar >= 48 && (int)currChar < 58)
                    continue;
                //something else encountered not a number
                else
                    isNumberFlag = false;
            }
        }
        if(isNumberFlag)
            System.out.println("this is a number");
        else
            System.out.println("this is not a number");

    }
}
