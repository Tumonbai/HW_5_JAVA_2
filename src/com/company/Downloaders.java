package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    int id;
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    public Downloaders(Semaphore semaphore,CountDownLatch countDownLatch,int id){
        this.semaphore=semaphore;
        this.countDownLatch=countDownLatch;
        this.id=id;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Пользователь: " +id + " начал загрузку");
        try {
            sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
            System.out.println("Пользователь: " + id + " загрузил ");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        semaphore.release();
        countDownLatch.countDown();
        super.run();
    }
}
