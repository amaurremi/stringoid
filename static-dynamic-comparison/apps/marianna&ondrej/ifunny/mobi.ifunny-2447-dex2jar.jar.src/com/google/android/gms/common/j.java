package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class j
        implements ServiceConnection {
    boolean a = false;
    private final BlockingQueue<IBinder> b = new LinkedBlockingQueue();

    public IBinder a() {
        if (this.a) {
            throw new IllegalStateException();
        }
        this.a = true;
        return (IBinder) this.b.take();
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        this.b.add(paramIBinder);
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */