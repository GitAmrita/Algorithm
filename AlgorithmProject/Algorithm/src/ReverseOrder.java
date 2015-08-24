/**
 * Created by achowdhury on 7/17/2015.
 */
public class ReverseOrder {
    public char[] Swap(char[] text, int low, int high){
        while(low < high){
            char tempL = text[low];
            char tempH = text[high];
            text[low] = tempH;
            text[high] = tempL;
            low ++ ; high --;
        }
        return text;
    }

    public void ReverseWordOrder(){
        String str = "hello to this beautiful world";
        char[] str1 = str.toCharArray();
        int low = 0;
        int high = str1.length-1;
        //swap the sentence word by word
        str1 = Swap(str1,low,high);
        System.out.println(str1);
        int i = 0;
        for(int p = 0 ; p < str1.length; p++){
            if(str1[p] == ' '){
                //only re swap words to get the actual word
                Swap(str1, i, p-1);
                //takes care of multiple space in between words
                do{
                    p ++;
                }while(str1[p] == ' ');
                i = p ;
            }
        }
        //swaps the last word since there isn't any space after that so not taken care in the loop
        Swap(str1, i, str1.length-1);
        System.out.println(str1);
    }
}
