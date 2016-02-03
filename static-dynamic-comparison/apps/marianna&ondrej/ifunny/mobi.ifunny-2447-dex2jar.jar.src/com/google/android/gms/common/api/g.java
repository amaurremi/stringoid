package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

public class g<R extends r>
        extends Handler {
    public g() {
        this(Looper.getMainLooper());
    }

    public g(Looper paramLooper) {
        super(paramLooper);
    }

    public void a() {
        removeMessages(2);
    }

    public void a(s<R> params, R paramR) {
        sendMessage(obtainMessage(1, new Pair(params, paramR)));
    }

    protected void b(s<R> params, R paramR) {
        try {
            params.a(paramR);
            return;
        } catch (RuntimeException params) {
            e.a(paramR);
            throw params;
        }
    }

    public void handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
            default:
                Log.wtf("GoogleApi", "Don't know how to handle this message.");
                return;
            case 1:
                paramMessage = (Pair) paramMessage.obj;
                b((s) paramMessage.first, (r) paramMessage.second);
                return;
        }
        f.a((f) paramMessage.obj);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */