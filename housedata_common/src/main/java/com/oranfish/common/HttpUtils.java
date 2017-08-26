package com.oranfish.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    private static String getPageContent(String url){
        String result = null;
        BufferedReader in = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder  sb = new StringBuilder ();
                String inputLine = null;
                while ((inputLine = in.readLine()) != null){
                    sb.append(inputLine);
                }
                result = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String getPageContentRepeatedly(String url){
        String htmlContent = null;
        for(int i = 0; i < 20; i ++){
            htmlContent = getPageContent(url);
            if(htmlContent == null){
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                break;
            }
        }
        return htmlContent;
    }
}
