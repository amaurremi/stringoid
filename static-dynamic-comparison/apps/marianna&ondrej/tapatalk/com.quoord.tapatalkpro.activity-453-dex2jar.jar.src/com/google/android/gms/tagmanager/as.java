package com.google.android.gms.tagmanager;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as
        extends Thread
        implements ar {
    private static as Ya;
    private final LinkedBlockingQueue<Runnable> XZ = new LinkedBlockingQueue();
    private volatile at Yb;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean tx = false;

    private as(Context paramContext) {
        super("GAThread");
        if (paramContext != null) {
        }
        for (this.mContext = paramContext.getApplicationContext(); ; this.mContext = paramContext) {
            start();
            return;
        }
    }

    static as H(Context paramContext) {
        if (Ya == null) {
            Ya = new as(paramContext);
        }
        return Ya;
    }

    private String a(Throwable paramThrowable) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
        paramThrowable.printStackTrace(localPrintStream);
        localPrintStream.flush();
        return new String(localByteArrayOutputStream.toByteArray());
    }

    public void a(Runnable paramRunnable) {
        this.XZ.add(paramRunnable);
    }

    void b(String paramString, final long paramLong) {
        a(new Runnable() {
            public void run() {
                if (as.a(as.this) == null) {
                    cx localcx = cx.lG();
                    localcx.a(as.b(as.this), jdField_this);
                    as.a(as.this, localcx.lH());
                }
                as.a(as.this).e(paramLong, this.Ye);
            }
        });
    }

    public void bC(String paramString) {
        b(paramString, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable localRunnable = (Runnable) this.XZ.take();
                if (!this.tx) {
                    localRunnable.run();
                }
            } catch (InterruptedException localInterruptedException) {
                bh.x(localInterruptedException.toString());
            } catch (Throwable localThrowable) {
                bh.w("Error on GAThread: " + a(localThrowable));
                bh.w("Google Analytics is shutting down.");
                this.tx = true;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */