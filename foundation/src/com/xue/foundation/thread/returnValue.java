package com.xue.foundation.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class returnValue implements Callable {
    @Override
    public Object call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return "aa";
    }
}
