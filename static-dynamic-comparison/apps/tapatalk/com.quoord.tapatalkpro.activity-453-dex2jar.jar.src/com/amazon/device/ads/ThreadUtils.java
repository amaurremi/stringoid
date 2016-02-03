package com.amazon.device.ads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    private static RunnableExecutor runnableExecutor = new ThreadPoolRunnableExecutor();

    public static final <T> void executeAsyncTask(AsyncTask<T, ?, ?> paramAsyncTask, final T... paramVarArgs) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AndroidTargetUtils.executeAsyncTask(paramAsyncTask, paramVarArgs);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AndroidTargetUtils.executeAsyncTask(this.val$task, paramVarArgs);
            }
        });
    }

    public static void executeRunnable(Runnable paramRunnable) {
        runnableExecutor.execute(paramRunnable);
    }

    public static boolean isOnMainThread() {
        return ThreadVerify.getInstance().isOnMainThread();
    }

    static void setRunnableExecutor(RunnableExecutor paramRunnableExecutor) {
        runnableExecutor = paramRunnableExecutor;
    }

    static class MainThreadRunnableExecutor
            implements ThreadUtils.RunnableExecutor {
        public void execute(Runnable paramRunnable) {
            new Handler(Looper.getMainLooper()).post(paramRunnable);
        }
    }

    static abstract interface RunnableExecutor {
        public abstract void execute(Runnable paramRunnable);
    }

    static class ThreadPoolRunnableExecutor
            implements ThreadUtils.RunnableExecutor {
        private static final int keepAliveTimeSeconds = 30;
        private static final int maxNumberThreads = 3;
        private static final int numberThreads = 1;
        private ExecutorService executorService = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());

        public void execute(Runnable paramRunnable) {
            this.executorService.submit(paramRunnable);
        }
    }

    static class ThreadVerify {
        private static ThreadVerify instance = new ThreadVerify();

        static ThreadVerify getInstance() {
            return instance;
        }

        static void setInstance(ThreadVerify paramThreadVerify) {
            instance = paramThreadVerify;
        }

        boolean isOnMainThread() {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */