package Helix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




/**
 * Created by amritachowdhury on 8/19/17.
 */
public class Solution1 {

    public static final String BASE_URL = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=";

    public void run() {
        int h = 9;//getTopicCount("pizza");
    }

   /* private int getTopicCount(String topic)  {
        try {
            String url = BASE_URL + topic;
            String dump = getHTML(url);
            System.out.println(dump.length());
            return 0;
        } catch(Exception e) {
            return 0;

        }

    }

    private String getText(String response) {
        JSONObject jObject = new JSONObject(response);

    }



    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }*/

}
