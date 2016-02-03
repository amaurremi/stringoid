package com.quoord.tapatalkpro.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 2;
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE + 1;
    private static final int TASK_QOS_PERIOD = 2;
    private static final int WORK_QUEUE_SIZE = 6;
    public static Runnable accessBufferThread = new Runnable() {
        public void run() {
            if (ThreadPoolManager.access$0()) {
                ThreadPoolManager.threadPool.execute((Runnable) ThreadPoolManager.taskQueue.poll());
            }
        }
    };
    public static RejectedExecutionHandler handler;
    private static ScheduledExecutorService scheduler;
    private static ScheduledFuture<?> taskHandler;
    public static Queue<Runnable> taskQueue = new LinkedList();
    public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue(6), handler);

    static {
        taskHandler = null;
        scheduler = Executors.newScheduledThreadPool(1);
        handler = new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor) {
                ThreadPoolManager.taskQueue.offer(paramAnonymousRunnable);
            }
        };
    }

    public static void addExecuteTask(Runnable paramRunnable) {
        if (threadPool == null) {
            threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue(6), handler);
        }
        if (paramRunnable != null) {
            threadPool.execute(paramRunnable);
        }
        initTaskHandler();
    }

    public static void clearTaskQueue() {
        if ((threadPool != null) && (threadPool.getQueue().size() > 0)) {
            threadPool.getQueue().clear();
        }
        if ((taskQueue != null) && (taskQueue.size() > 0)) {
            taskQueue.clear();
        }
    }

    private static boolean hasMoreAcquire() {
        return !taskQueue.isEmpty();
    }

    public static void initTaskHandler() {
        if (scheduler == null) {
            scheduler = Executors.newScheduledThreadPool(1);
        }
        if (taskHandler == null) {
            taskHandler = scheduler.scheduleAtFixedRate(accessBufferThread, 0L, 2L, TimeUnit.SECONDS);
        }
    }

    public static void stopThreadPoolMannager() {
        try {
            if (threadPool != null) {
                threadPool.shutdown();
            }
            threadPool = null;
            if (scheduler != null) {
                scheduler.shutdownNow();
            }
            scheduler = null;
            taskHandler = null;
            return;
        } catch (Exception localException) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ThreadPoolManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */