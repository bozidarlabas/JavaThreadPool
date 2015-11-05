package com.blabas.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbook on 05.11.2015..
 */
public class Constants {
    private Constants(){}

    public static final int CORE_POOL_SIZE = 2;
    public static final int MAX_POOL_SIZE = 4;
    public static final int KEEP_ALIVE_TIME = 10;
    public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public static final int JOBS_NUM = 10;

    public static final int THREAD_SLEEP_TIME = 3000;

    public static final int THREAD_SLEEP_TIME_2 = 5000;
}
