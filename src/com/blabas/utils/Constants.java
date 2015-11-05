package com.blabas.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbook on 05.11.2015..
 */
public class Constants {
    private Constants(){}
    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 5;
    public static final int KEEP_ALIVE_TIME = 0;
    public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public static final int THREAD_TASKS = 10;
}
