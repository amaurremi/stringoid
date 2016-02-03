package com.amazon.device.ads;

import android.util.SparseArray;

abstract class StartUpWaiter
        implements Configuration.ConfigurationListener, Settings.SettingsListener {
    static final int CALLBACK_ON_MAIN_THREAD = 0;
    static final int DEFAULT = 1;
    private static final SparseArray<ThreadUtils.RunnableExecutor> executors = new SparseArray();
    private int callbackType = 1;

    static {
        putRunnableExecutor(0, new ThreadUtils.MainThreadRunnableExecutor());
        putRunnableExecutor(1, new ThreadUtils.ThreadPoolRunnableExecutor());
    }

    private static ThreadUtils.RunnableExecutor getExecutor(int paramInt) {
        return (ThreadUtils.RunnableExecutor) executors.get(paramInt, executors.get(1));
    }

    private void onFinished(Runnable paramRunnable) {
        getExecutor(this.callbackType).execute(paramRunnable);
    }

    static void putRunnableExecutor(int paramInt, ThreadUtils.RunnableExecutor paramRunnableExecutor) {
        if (paramRunnableExecutor == null) {
            executors.remove(paramInt);
            return;
        }
        executors.put(paramInt, paramRunnableExecutor);
    }

    public void onConfigurationFailure() {
        onFinished(new Runnable() {
            public void run() {
                StartUpWaiter.this.startUpFailed();
            }
        });
    }

    public void onConfigurationReady() {
        onFinished(new Runnable() {
            public void run() {
                StartUpWaiter.this.startUpReady();
            }
        });
    }

    public void settingsLoaded() {
        Configuration.getInstance().queueConfigurationListener(this);
    }

    public void start() {
        Settings.getInstance().listenForSettings(this);
    }

    public void startAndCallbackOnMainThread() {
        this.callbackType = 0;
        start();
    }

    protected abstract void startUpFailed();

    protected abstract void startUpReady();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/StartUpWaiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */