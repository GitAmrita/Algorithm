package GE;

/**
 * Created by amritachowdhury on 8/3/17.
 */
public class Solution1 {

    public void run() {
      int[] roll = new int[] {3, 2, 1};
      String result = rollTheString("abc", roll);
      System.out.println(result);
    }

    private String rollTheString(String s, int[] roll) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        StringBuffer sa = new StringBuffer();
        for(int i = 0; i < roll.length; i++) {
            int noOfCharsToBeChanged = roll[i];
            sa.append(getRolledString(s.toLowerCase(), noOfCharsToBeChanged));
        }
        return sa.delete(0, sa.toString().length() - s.length()).toString();
    }

    private String getRolledString(String s, int no) {
        if (s.length() < no) {
            return "";
        }
        StringBuffer sb = new StringBuffer(s.length());
        int i = 0;
        while(i < no) {
            char c = rolledChar(s.charAt(i));
            sb.append(c);
            i++;
        }
        sb.append(s.substring(i));
        return sb.toString();
    }

    private char rolledChar(char c) {
        int ascii = (int) c;
        char rolledChar = (char) (ascii + 1);
        if (ascii == (int) 'z') {
            rolledChar = (int) 'a';
        }
        return rolledChar;
    }
}
