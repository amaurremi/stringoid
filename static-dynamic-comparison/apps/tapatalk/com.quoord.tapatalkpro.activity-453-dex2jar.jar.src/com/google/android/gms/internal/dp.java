package com.google.android.gms.internal;

import android.os.Process;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class dp {
    private static final ThreadFactory ra = new ThreadFactory() {
        private final AtomicInteger rd = new AtomicInteger(1);

        public Thread newThread(Runnable paramAnonymousRunnable) {
            return new Thread(paramAnonymousRunnable, "AdWorker #" + this.rd.getAndIncrement());
        }
    };
    private static final ThreadPoolExecutor rb = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), ra);

    public static void execute(Runnable paramRunnable) {
        try {
            rb.execute(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    this.rc.run();
                }
            });
            return;
        } catch (RejectedExecutionException paramRunnable) {
            dw.c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), paramRunnable);
        }
    }

    public static int getPoolSize() {
        return rb.getPoolSize();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */