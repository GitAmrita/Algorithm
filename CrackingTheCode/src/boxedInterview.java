import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by amritachowdhury on 7/8/17.
 */


public class boxedInterview {
    HashMap<String, Long> map = new HashMap<>();
    public int solution(String s) {
        int amountToPay = 0;
        char endOfLine = (char) 10;
        String[] linesInLog = s.split(String.valueOf(endOfLine));

        for (String line : linesInLog) {
            String[] value = line.split(",");
            String time = value[0];
            String phone = value[1];
            String[] v = getFormattedTime(time);
            String hour = v[0];
            String minute = v[1];
            String second = v[2];
            storePhoneDuration(phone, hour, minute, second);
        }
        String promotionPhoneNumber = getPhoneWithLongestTotalDuration();
        for (String line : linesInLog) {
            String[] value = line.split(",");
            String time = value[0];
            String phone = value[1];
            if (phone.equals(promotionPhoneNumber)) {
                continue;
            }
            String[] v = getFormattedTime(time);
            String hour = v[0];
            String minute = v[1];
            String second = v[2];

            amountToPay = amountToPay + calculateAmount(hour, minute, second);

        }
        return amountToPay;

    }

    private int calculateAmount(String hour, String minute, String second) {
        int moneyInCent = 0;
        if (Integer.parseInt(minute) < 5 && Integer.parseInt(hour) == 0) {
            int totalSec = Integer.parseInt(minute) * 60 + Integer.parseInt(second);
            moneyInCent = totalSec * 3;
        } else {
            int sec = Integer.parseInt(second) == 0 ? 0 : 1;
            int timeInMinute = Integer.parseInt(hour) * 60 + Integer.parseInt(minute) + sec ;
            moneyInCent = timeInMinute * 150;
        }
        return moneyInCent;
    }

    private String getPhoneWithLongestTotalDuration() {
        long max = 0; String phone = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                phone = key;
            } else if (map.get(key) == max) {
                phone = getFormattedPhone(phone) < getFormattedPhone(key) ? phone : key;
            }
        }
        return phone;
    }

    private void storePhoneDuration(String phoneNumber, String hour, String minute, String second) {
        long timeInSec = Integer.parseInt(hour) * 3600 + Integer.parseInt(minute) * 60 + Integer.parseInt(second);
        if ( map.get(phoneNumber) == null) {
            map.put(phoneNumber, timeInSec);
        } else {
            long lastTime = map.get(phoneNumber);
            map.put(phoneNumber, lastTime + timeInSec);
        }
    }

    private long getFormattedPhone(String phone) {
        String temp = phone.replace("-","");
        return Long.parseLong(temp);
    }

    private String[] getFormattedTime(String time) {
        String[] v = time.split(":");
       return v;
    }
}
