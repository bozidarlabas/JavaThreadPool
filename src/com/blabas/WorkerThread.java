package com.blabas;

/**
 * Created by macbook on 05.11.2015..
 */
public class WorkerThread implements Runnable {
    String taskName;

    WorkerThread(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {

        try {
            Thread t1 = Thread.currentThread();
            System.out.println(t1.getName() + " executing the task " + taskName);
            t1.sleep(1000);
            System.out.println(t1.getName() + " completed the task " + taskName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
