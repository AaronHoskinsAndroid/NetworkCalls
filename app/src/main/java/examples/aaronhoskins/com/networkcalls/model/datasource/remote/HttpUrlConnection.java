package examples.aaronhoskins.com.networkcalls.model.datasource.remote;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnection {
    public String getJsonFromRandomUser() {
        String jsonResult = "";
        HttpURLConnection httpUrlConnection = null;
        try {
            URL randomMeURL = new URL("https://randomuser.me/api/?results=5");
            httpUrlConnection = (HttpURLConnection)randomMeURL.openConnection();
            InputStream inputStream = httpUrlConnection.getInputStream();
            int currentReadCharAsciiValue = inputStream.read();
            while(currentReadCharAsciiValue != -1) {
                char currentChar = (char)currentReadCharAsciiValue;
                currentReadCharAsciiValue = inputStream.read();
                jsonResult = jsonResult + currentChar;
            }

        } catch(Exception e) {
            Log.e("TAG", "ERROR IN HTTPURLCONNECTION - " , e);
        } finally {
            if(httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
        }
        return jsonResult;
    }
}
