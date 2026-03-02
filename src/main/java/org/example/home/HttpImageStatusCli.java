package org.example.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void main(String[] args) {
        askStatus();
    }

    public static void askStatus(){

        try {
            String strCode;
            int validCode;
            System.out.print("Enter HTTP status code: ");

            while (true){
                strCode = br.readLine();
                if(!strCode.matches("\\d{3}")){
                    System.out.println("Please enter valid number!");
                } else {
                    validCode = Integer.parseInt(strCode);
                    break;
                }
            }

            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            downloader.downloadStatusImage(validCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
