package org.example.home;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {
        String stringUrl = new StringBuilder(Utils.START_URL).append(code).append(Utils.EXTENSION).toString();
        HttpURLConnection connection = (HttpURLConnection) new URL(stringUrl).openConnection();
        int responceCode = connection.getResponseCode();
        if(responceCode == 404){
            throw new FileNotFoundException(String.format("There is not image for HTTP status %s", code));
        } else {
            return stringUrl;
        }
    }
}
