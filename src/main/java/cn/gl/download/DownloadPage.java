package cn.gl.download;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadPage {
    public String getPage(String url){
        try {
            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String temp = null;
            StringBuilder sb = new StringBuilder();
            while ((temp = br.readLine()) != null){
                sb.append(temp);
            }
            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
