package com.google.android.gms.internal;

public abstract class do
        {
private final Runnable kW=new Runnable()
        {
public final void run()
        {
        do.a(do.this,Thread.currentThread());
        do.this.aY();
        }
        };
private volatile Thread qY;

public abstract void aY();

public final void cancel()
        {
        onStop();
        if(this.qY!=null){
        this.qY.interrupt();
        }
        }

public abstract void onStop();

public final void start()
        {
        dp.execute(this.kW);
        }
        }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */