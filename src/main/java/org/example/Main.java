package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

///////////////////////////////////////////////////////////////////////////////////////////////1
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        try {
            String imageUrl200 = httpStatusChecker.getStatusImage(418);
            System.out.println("Image for code: =   " + imageUrl200);
        } catch (Exception e) {
            e.printStackTrace();
        }


///////////////////////////////////////////////////////////////////////////////////////////////2
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        try {
            httpStatusImageDownloader.downloadStatusImage(418);
        } catch (Exception e) {
            e.printStackTrace();
        }




        ///////////////////////////////////////////////////////////////////////////////////////////////3
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();


    }
}