package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {

    CountDownLatch countDownLatch;

    public Uploader (CountDownLatch latch) {
        this.countDownLatch=latch;
    }

    @Override
    public void run() {
        System.out.println("Загрузка файла на сервер");
        for (int i = 1; i <=5; i++) {
            System.out.print(".");
            try {
                sleep(1000);
               countDownLatch.countDown();
            } catch (InterruptedException f){
                f.printStackTrace();
            }
        }
        System.out.println("\nЗагрузка завершена!");
        super.run();
    }
}
