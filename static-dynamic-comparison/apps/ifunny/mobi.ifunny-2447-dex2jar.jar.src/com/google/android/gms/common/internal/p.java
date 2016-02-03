package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

import java.util.HashMap;

public final class p
        implements Handler.Callback {
    private static final Object a = new Object();
    private static p b;
    private final Context c;
    private final HashMap<String, q> d = new HashMap();
    private final Handler e = new Handler(paramContext.getMainLooper(), this);

    private p(Context paramContext) {
        this.c = paramContext.getApplicationContext();
    }

    public static p a(Context paramContext) {
        synchronized (a) {
            if (b == null) {
                b = new p(paramContext.getApplicationContext());
            }
            return b;
        }
    }

    public boolean a(String paramString, e<?>.j parame) {
        for (; ; ) {
            q localq;
            synchronized (this.d) {
                localq = (q) this.d.get(paramString);
                if (localq == null) {
                    localq = new q(this, paramString);
                    localq.a(parame);
                    parame = new Intent(paramString).setPackage("com.google.android.gms");
                    localq.a(this.c.bindService(parame, localq.a(), 129));
                    this.d.put(paramString, localq);
                    paramString = localq;
                    boolean bool = paramString.c();
                    return bool;
                }
                this.e.removeMessages(0, localq);
                if (localq.c(parame)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
                }
            }
            localq.a(parame);
            switch (localq.d()) {
                case 1:
                    parame.onServiceConnected(localq.g(), localq.f());
                    paramString = localq;
                    break;
                case 2:
                    paramString = new Intent(paramString).setPackage("com.google.android.gms");
                    localq.a(this.c.bindService(paramString, localq.a(), 129));
                    paramString = localq;
                    break;
                default:
                    paramString = localq;
            }
        }
    }

    public void b(String paramString, e<?>.j parame) {
        q localq;
        synchronized (this.d) {
            localq = (q) this.d.get(paramString);
            if (localq == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
            }
        }
        if (!localq.c(parame)) {
            throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
        }
        localq.b(parame);
        if (localq.e()) {
            paramString = this.e.obtainMessage(0, localq);
            this.e.sendMessageDelayed(paramString, 5000L);
        }
    }

    public boolean handleMessage(Message arg1) {
        switch (???.what)
        {
            default:
                return false;
        }
        q localq = (q) ???.obj;
        synchronized (this.d) {
            if (localq.e()) {
                this.c.unbindService(localq.a());
                this.d.remove(localq.b());
            }
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */