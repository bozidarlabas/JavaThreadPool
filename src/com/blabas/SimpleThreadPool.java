package com.blabas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.blabas.utils.Constants.*;
import static com.blabas.utils.Constants.THREAD_NUMBER;

/**
 * Created by macbook on 05.11.2015..
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        //Fixed size thread pool of 5 worker threads
        //Executors class provide simple implementation of ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);

        //Submitting 10 jobs to pool
        for (int i = 0; i < JOBS_NUMBER; i++) {
            Runnable worker = new WorkerThread(i + "");
            executor.execute(worker);
        }
        executor.shutdown();
        while(!executor.isTerminated()){}

        System.out.println("All threads finished");

    }
}
