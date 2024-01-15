package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    private HttpStatusImageDownloader imageDownloader;

    public HttpImageStatusCli() {
        this.imageDownloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter HTTP status code: ");
            int statusCode = scanner.nextInt();

            if (statusCode > 100) {  // Але можна зробити щоб зразу виходило з if якщо int більше чим кількість помилок / statusCode >= 100 && statusCode <= 599
                try {
                    imageDownloader.downloadStatusImage(statusCode);
                    System.out.println("Image downloaded");
                } catch (RuntimeException e) {
                    System.out.println("There is no image for HTTP status " + statusCode);
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Please enter valid code");
            }
        } catch (Exception e) {
            System.out.println("Please enter valid number.");
        }
        scanner.close();
    }
}