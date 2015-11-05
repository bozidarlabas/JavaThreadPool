package com.blabas;

import com.blabas.utils.Constants;

/**
 * Created by Bozidar on 05.11.2015..
 */
public class WorkerThread implements Runnable{

    private String command;

    public WorkerThread(String command){
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + this.command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(Constants.THREAD_SLEEP_TIME_2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
