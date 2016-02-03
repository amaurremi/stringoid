package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;

final class n
        extends Handler {
    public n(m paramm, Looper paramLooper) {
        super(paramLooper);
    }

    public void handleMessage(Message paramMessage) {
        if (paramMessage.what == 1) {
            synchronized (m.a(this.a)) {
                if ((m.b(this.a).c_()) && (m.b(this.a).c()) && (m.a(this.a).contains(paramMessage.obj))) {
                    Bundle localBundle = m.b(this.a).b_();
                    ((com.google.android.gms.common.api.m) paramMessage.obj).a(localBundle);
                }
                return;
            }
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */