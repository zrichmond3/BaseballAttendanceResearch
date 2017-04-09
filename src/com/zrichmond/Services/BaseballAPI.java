package com.zrichmond.Services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * Created by zacharyrichmond on 4/9/17.
 */
public class BaseballAPI {
    public void GetData(){
        try {
            URL url = new URL ("https://www.mysportsfeeds.com/api/feed/pull/mlb/2016-playoff/game_boxscore.json?gameid=20161007-LAD-WAS&teamstats=none&playerstats=none");
            byte[] encodedBytes = Base64.getEncoder().encode("Zachary.T.Richmond:Ztr092190".getBytes());
            System.out.println("encodedBytes " + new String(encodedBytes));
//            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
//            System.out.println("decodedBytes " + new String(decodedBytes));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + new String(encodedBytes));
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   = new BufferedReader (new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    };

}