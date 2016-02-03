package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

final class j
        implements ServiceConnection {
    j(e parame) {
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        this.a.b(paramIBinder);
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        this.a.a.sendMessage(this.a.a.obtainMessage(4, Integer.valueOf(1)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */