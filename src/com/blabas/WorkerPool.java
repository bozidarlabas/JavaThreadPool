package com.blabas;

import com.blabas.utils.Constants;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadPool implementation
 */
public class WorkerPool {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //Creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(
                Constants.CORE_POOL_SIZE,
                Constants.MAX_POOL_SIZE,
                Constants.KEEP_ALIVE_TIME,
                Constants.TIME_UNIT,
                new ArrayBlockingQueue<Runnable>(2),
                threadFactory,
                rejectionHandler);

        //Initialize and start monitor thread
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        //Submit work to the thread pool
        for (int i = 0; i < Constants.JOBS_NUM; i++) {
            executorPool.execute(new WorkerThread(i + ""));
        }

        Thread.sleep(Constants.THREAD_SLEEP_TIME);
        //Shut down the pool
        executorPool.shutdown();
        Thread.sleep(Constants.THREAD_SLEEP_TIME_2);
        //Shut down the monitor thread
        monitor.shutdown();
    }
}
