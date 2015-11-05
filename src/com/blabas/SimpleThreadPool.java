package com.blabas;

import com.blabas.utils.Constants;

import java.util.concurrent.*;

import static com.blabas.utils.Constants.THREAD_TASKS;

/**
 * Created by macbook on 05.11.2015..
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();

        //thread pool of size 5. So it can run 5 tasks at a time, Since 5 threads are reside in the pool.
        Executor executor = new ThreadPoolExecutor(
                Constants.CORE_POOL_SIZE,
                Constants.MAX_POOL_SIZE,
                Constants.KEEP_ALIVE_TIME,
                Constants.TIME_UNIT,
                workQueue);

        WorkerThread[] tasks = new WorkerThread[THREAD_TASKS];

        for (int i = 0; i < THREAD_TASKS; i++) {
            tasks[i] = new WorkerThread("task " + i);
            //Submit the tasks to the thread pool
            executor.execute(tasks[i]);
        }

    }
}
