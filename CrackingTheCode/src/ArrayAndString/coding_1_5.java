package ArrayAndString;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_1_5 {

    public void run() {
        String originalString = "pale";
        String modifiedString = "bake";
        boolean isOneEditAway = isOneAway(originalString, modifiedString);
        System.out.println(isOneEditAway);
    }

    private boolean isOneAway(String originalString, String modifiedString) {
        if (originalString.equals(modifiedString)) {
            return true;
        }
        if (originalString.length() == modifiedString.length()) {
            return isReplaceCharacter(originalString.toLowerCase().toCharArray(),
                    modifiedString.toLowerCase().toCharArray());
        } else if (originalString.length() > modifiedString.length()) {
            return isRemoveCharacter(originalString.toLowerCase().toCharArray(),
                    modifiedString.toLowerCase().toCharArray());
        } else {
            return isInsertCharacter(originalString.toLowerCase().toCharArray(),
                    modifiedString.toLowerCase().toCharArray());
        }
    }

    private boolean isRemoveCharacter(char [] originalString, char [] modifiedString) {
        int originalCounter = 0; int modifiedCounter = 0; boolean isCharRemoved = false;
        if (originalString.length - modifiedString.length > 1 || originalString.length <= modifiedString.length) {
            return false;
        }
        while (modifiedCounter < modifiedString.length) {
            if (originalString[originalCounter] != modifiedString[modifiedCounter]) {
                if (!isCharRemoved) {
                    isCharRemoved = true;
                    originalCounter ++;
                    continue;
                }
                else {
                    return false;
                }
            }
            originalCounter ++;
            modifiedCounter ++;
        }
        return true;
    }

    private boolean isReplaceCharacter(char [] originalString, char [] modifiedString) {
        boolean isCharReplaced = false;
        if (originalString.length != modifiedString.length) {
            return false;
        }
        for (int i = 0; i < modifiedString.length; i++) {
            if (originalString[i] != modifiedString[i]) {
                if (!isCharReplaced) {
                    isCharReplaced = true;
                }
                return false;
            }
        }
        return true;
    }

    private boolean isInsertCharacter(char [] originalString, char [] modifiedString) {
        int originalCounter = 0; int modifiedCounter = 0; boolean isCharInserted = false;
        if (modifiedString.length - originalString.length > 1 || modifiedString.length <= originalString.length) {
            return false;
        }
        while (modifiedCounter < modifiedString.length) {
            if (modifiedString[modifiedCounter] != originalString[originalCounter]) {
                if (!isCharInserted) {
                    isCharInserted = true;
                    modifiedCounter ++;
                } else {
                    return false;
                }
            }
            originalCounter ++;
            modifiedCounter ++;
        }
        return true;
    }
}
