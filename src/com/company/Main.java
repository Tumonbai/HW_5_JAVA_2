package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        // write your code here
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(10);
        Semaphore sem = new Semaphore(3);
        Uploader uploader=new Uploader(cdl);
        uploader.start();
        try {
            cdl.await();
            for (int i = 1; i <=10; i++) {
                Downloaders dl = new Downloaders(sem,cdl2,i);
                dl.start();
            }
            cdl2.await();
            System.out.println("Файл удален из сервера");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
