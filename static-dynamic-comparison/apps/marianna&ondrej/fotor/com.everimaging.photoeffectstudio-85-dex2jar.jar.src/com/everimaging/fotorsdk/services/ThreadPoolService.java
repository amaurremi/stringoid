package com.everimaging.fotorsdk.services;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolService
        extends BaseService {
    private static final String b = ThreadPoolService.class.getSimpleName();
    private static final FotorLoggerFactory.c c = FotorLoggerFactory.a(b, FotorLoggerFactory.LoggerType.CONSOLE);
    private static final b e = new b(null);
    private final ThreadPoolExecutor d = new ThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("thread-pool-service", 0));

    public ThreadPoolService(Context paramContext) {
        super(paramContext);
    }

    public <I, O> Future<O> a(a<I, O> parama, a<O> parama1, I paramI) {
        parama = new d(parama, parama1, paramI);
        this.d.execute(parama);
        return parama;
    }

    public static abstract class a<Params, Result> {
        protected abstract Result a(Context paramContext, Params paramParams);
    }

    private static class b
            extends Handler {
        public void handleMessage(Message paramMessage) {
            switch (paramMessage.what) {
            }
            do {
                return;
                paramMessage = (ThreadPoolService.d) paramMessage.obj;
            } while (paramMessage == null);
            paramMessage.a(paramMessage.get());
        }
    }

    class c
            implements ThreadFactory {
        private final int b;
        private final AtomicInteger c = new AtomicInteger();
        private final String d;

        public c(String paramString, int paramInt) {
            this.d = paramString;
            this.b = paramInt;
        }

        public Thread newThread(Runnable paramRunnable) {
            new Thread(paramRunnable, this.d + '-' + this.c.getAndIncrement()) {
                public void run() {
                    Process.setThreadPriority(ThreadPoolService.c.a(ThreadPoolService.c.this));
                    super.run();
                }
            };
        }
    }

    class d<I, O>
            implements Runnable, Future<O> {
        ThreadPoolService.a<I, O> a;
        a<O> b;
        O c;
        I d;
        boolean e;
        boolean f;

        public d(a<O> parama, I paramI) {
            this.a = parama;
            this.b = paramI;
            Object localObject;
            this.d = localObject;
        }

        public void a(O paramO) {
            if (this.b != null) {
                this.b.a(paramO);
            }
        }

        /* Error */
        public boolean cancel(boolean paramBoolean) {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: aload_0
            //   3: getfield 53	com/everimaging/fotorsdk/services/ThreadPoolService$d:f	Z
            //   6: istore_1
            //   7: iload_1
            //   8: ifeq +7 -> 15
            //   11: aload_0
            //   12: monitorexit
            //   13: iconst_0
            //   14: ireturn
            //   15: aload_0
            //   16: iconst_1
            //   17: putfield 53	com/everimaging/fotorsdk/services/ThreadPoolService$d:f	Z
            //   20: goto -9 -> 11
            //   23: astore_2
            //   24: aload_0
            //   25: monitorexit
            //   26: aload_2
            //   27: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	28	0	this	d
            //   0	28	1	paramBoolean	boolean
            //   23	4	2	localObject	Object
            // Exception table:
            //   from	to	target	type
            //   2	7	23	finally
            //   15	20	23	finally
        }

        public O get() {
            try {
                for (; ; ) {
                    boolean bool = this.e;
                    if (bool) {
                        break;
                    }
                    try {
                        wait();
                    } catch (Throwable localThrowable) {
                    }
                    if (FotorLoggerFactory.a) {
                        ThreadPoolService.c().e(new Object[]{localThrowable});
                    }
                }
                localObject2 = this.c;
            } finally {
            }
            Object localObject2;
            return (O) localObject2;
        }

        public O get(long paramLong, TimeUnit paramTimeUnit)
                throws InterruptedException, ExecutionException, TimeoutException {
            throw new TimeoutException("non implemented");
        }

        public boolean isCancelled() {
            return this.f;
        }

        public boolean isDone() {
            return this.e;
        }

        public void run() {
            Object localObject1 = null;
            try {
                Object localObject3 = this.a.a(ThreadPoolService.this.a(), this.d);
                localObject1 = localObject3;
            } catch (Exception localException) {
                for (; ; ) {
                    try {
                        this.c = localObject1;
                        this.e = true;
                        notifyAll();
                        ThreadPoolService.c().c(new Object[]{"completion task call:" + ThreadPoolService.b().getLooper()});
                        ThreadPoolService.b().obtainMessage(1, this).sendToTarget();
                        return;
                    } finally {
                    }
                    localException = localException;
                    localException.printStackTrace();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/services/ThreadPoolService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */