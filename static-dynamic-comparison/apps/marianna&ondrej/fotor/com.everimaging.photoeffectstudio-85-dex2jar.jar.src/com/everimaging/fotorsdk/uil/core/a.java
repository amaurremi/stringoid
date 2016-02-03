package com.everimaging.fotorsdk.uil.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.everimaging.fotorsdk.uil.cache.disc.impl.c;
import com.everimaging.fotorsdk.uil.core.assist.QueueProcessingType;
import com.everimaging.fotorsdk.uil.core.assist.deque.LIFOLinkedBlockingDeque;
import com.everimaging.fotorsdk.uil.core.download.ImageDownloader;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    public static com.everimaging.fotorsdk.uil.cache.disc.b a(Context paramContext, com.everimaging.fotorsdk.uil.cache.disc.naming.a parama, int paramInt1, int paramInt2) {
        if (paramInt1 > 0) {
            return new com.everimaging.fotorsdk.uil.cache.disc.impl.b(com.everimaging.fotorsdk.uil.utils.d.b(paramContext), parama, paramInt1);
        }
        if (paramInt2 > 0) {
            return new com.everimaging.fotorsdk.uil.cache.disc.impl.a(com.everimaging.fotorsdk.uil.utils.d.b(paramContext), parama, paramInt2);
        }
        return new c(com.everimaging.fotorsdk.uil.utils.d.a(paramContext), parama);
    }

    public static com.everimaging.fotorsdk.uil.cache.disc.b a(File paramFile) {
        File localFile = new File(paramFile, "uil-images");
        if ((localFile.exists()) || (localFile.mkdir())) {
            paramFile = localFile;
        }
        return new com.everimaging.fotorsdk.uil.cache.disc.impl.b(paramFile, 2097152);
    }

    public static com.everimaging.fotorsdk.uil.cache.disc.naming.a a() {
        return new com.everimaging.fotorsdk.uil.cache.disc.naming.b();
    }

    public static com.everimaging.fotorsdk.uil.cache.memory.a<String, Bitmap> a(int paramInt) {
        int i = paramInt;
        if (paramInt == 0) {
            i = (int) (Runtime.getRuntime().maxMemory() / 8L);
        }
        return new com.everimaging.fotorsdk.uil.cache.memory.impl.b(i);
    }

    public static com.everimaging.fotorsdk.uil.core.decode.b a(boolean paramBoolean) {
        return new com.everimaging.fotorsdk.uil.core.decode.a(paramBoolean);
    }

    public static ImageDownloader a(Context paramContext) {
        return new com.everimaging.fotorsdk.uil.core.download.a(paramContext);
    }

    public static Executor a(int paramInt1, int paramInt2, QueueProcessingType paramQueueProcessingType) {
        int i;
        if (paramQueueProcessingType == QueueProcessingType.LIFO) {
            i = 1;
            if (i == 0) {
                break label50;
            }
        }
        label50:
        for (paramQueueProcessingType = new LIFOLinkedBlockingDeque(); ; paramQueueProcessingType = new LinkedBlockingQueue()) {
            paramQueueProcessingType = (BlockingQueue) paramQueueProcessingType;
            return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, paramQueueProcessingType, b(paramInt2));
            i = 0;
            break;
        }
    }

    public static com.everimaging.fotorsdk.uil.core.display.a b() {
        return new com.everimaging.fotorsdk.uil.core.display.d();
    }

    private static ThreadFactory b(int paramInt) {
        return new a(paramInt);
    }

    private static class a
            implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;
        private final int e;

        a(int paramInt) {
            this.e = paramInt;
            Object localObject = System.getSecurityManager();
            if (localObject != null) {
            }
            for (localObject = ((SecurityManager) localObject).getThreadGroup(); ; localObject = Thread.currentThread().getThreadGroup()) {
                this.b = ((ThreadGroup) localObject);
                this.d = ("uil-pool-" + a.getAndIncrement() + "-thread-");
                return;
            }
        }

        public Thread newThread(Runnable paramRunnable) {
            paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
            if (paramRunnable.isDaemon()) {
                paramRunnable.setDaemon(false);
            }
            paramRunnable.setPriority(this.e);
            return paramRunnable;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */