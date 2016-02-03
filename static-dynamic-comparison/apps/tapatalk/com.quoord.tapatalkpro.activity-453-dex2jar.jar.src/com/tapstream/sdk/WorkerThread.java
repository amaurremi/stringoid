package com.tapstream.sdk;

import java.util.concurrent.ThreadFactory;

import org.apache.http.impl.client.DefaultHttpClient;

public class WorkerThread
        extends Thread {
    public DefaultHttpClient client = new DefaultHttpClient();

    public WorkerThread(Runnable paramRunnable) {
        super(paramRunnable);
    }

    public static class Factory
            implements ThreadFactory {
        public Thread newThread(Runnable paramRunnable) {
            return new WorkerThread(paramRunnable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/WorkerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */