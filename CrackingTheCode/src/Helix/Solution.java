package Helix;

/**
 * Created by amritachowdhury on 8/19/17.
 */
public class Solution {
    public void test() {
        String s = "abc";
        String[] operations = new String[] {"0 0 L", "2 2 L", "0 2 R"};
        String res = rollingString(s, operations);
        System.out.println(res);
    }

    public String rollingString(String s, String[] operations) {
        for (String str : operations) {
            String[] subStr = str.split("\\s+");
            boolean rollRight = subStr[2].equals("R") ? true : false;
            s = rollChar(s, Integer.parseInt(subStr[0]), Integer.parseInt(subStr[1]), rollRight);
        }
        return s;
    }

    /*public String rollChar(String str, int i, int j, boolean rollRight) {
        StringBuffer sb = new StringBuffer(str.length());
        String toBeRolled = str.substring(i, j + 1);
        String remainSamePrev = str.substring(0, i) ;
        String remainSameAfter = str.substring(j + 1);
        if (!remainSamePrev.isEmpty()) {
            sb.append(remainSamePrev);
        }
        if (rollRight) {
            for (char s : toBeRolled.toCharArray()) {
                sb.append(rolledCharRight(s));
            }
        } else {
            for (char s : toBeRolled.toCharArray()) {
                sb.append(rolledCharLeft(s));
            }
        }

        if (!remainSameAfter.isEmpty()) {
            sb.append(remainSameAfter);
        }
        return sb.toString();
    }*/

    public String rollChar(String str, int i, int j, boolean rollRight) {
        StringBuffer sb = new StringBuffer(str.length());
        int index = 0;
        while (index < str.length()) {
            if(index < i || index > j) {
                sb.append(str.charAt(index));
                index++;
                continue;
            }
            if (rollRight) {
                sb.append(rolledCharRight(str.charAt(index)));

            } else {
                sb.append(rolledCharLeft(str.charAt(index)));
            }
            index++;
        }

        return sb.toString();
    }

    private char rolledCharRight(char c) {
        int ascii = (int) c;
        char rolledChar = (char) (ascii + 1);
        if (ascii == (int) 'z') {
            rolledChar = (int) 'a';
        }
        return rolledChar;
    }

    private char rolledCharLeft(char c) {
        int ascii = (int) c;
        char rolledChar = (char) (ascii - 1);
        if (ascii == (int) 'a') {
            rolledChar = (int) 'z';
        }
        return rolledChar;
    }
}
