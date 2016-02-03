package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

@ii
public final class ls {
    private static final ThreadFactory a = new lv();
    private static final ExecutorService b = Executors.newFixedThreadPool(10, a);

    public static Future<Void> a(Runnable paramRunnable) {
        return a(new lt(paramRunnable));
    }

    public static <T> Future<T> a(Callable<T> paramCallable) {
        try {
            paramCallable = b.submit(new lu(paramCallable));
            return paramCallable;
        } catch (RejectedExecutionException paramCallable) {
            mx.d("Thread execution is rejected.", paramCallable);
        }
        return new mc(null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */