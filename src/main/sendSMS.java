package main;

/**
 * Created by chidgana on 05-04-18.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sendSMS {
    private String Sender;
    private String Number;
    private String Message;


    public sendSMS(String sender, String number, String message) {
        this.Number = number;
        this.Message = message;
        this.Sender = sender;

    }

    public String sendSms() {

        try {
            // Construct data
            String apiKey = "apikey=" + "n+Kcjg77GLw-PrVUs8rQHbNkwJG1tbQRgE4Ed1wtTZ";
            String message = "&message=" + Message;
            String sender = "&sender=" + Sender;
            String numbers = "&numbers=" + Number;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS " + e);
            return "Error " + e;

        }
    }


}
