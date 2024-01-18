package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException {

        String imageUrl = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
        connection.setRequestMethod("GET");
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        try {

                try (InputStream inputStream = connection.getInputStream()) {
                    String fileName = "ImageDownloaded" + code + ".jpg";
                    try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                        byte[] buffer = new byte[17 * 60];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
    }
}
