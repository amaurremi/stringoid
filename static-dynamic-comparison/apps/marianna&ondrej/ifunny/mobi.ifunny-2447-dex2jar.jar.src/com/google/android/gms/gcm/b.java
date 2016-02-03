package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.concurrent.BlockingQueue;

class b
        extends Handler {
    b(a parama, Looper paramLooper) {
        super(paramLooper);
    }

    public void handleMessage(Message paramMessage) {
        paramMessage = (Intent) paramMessage.obj;
        this.a.b.add(paramMessage);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/gcm/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */