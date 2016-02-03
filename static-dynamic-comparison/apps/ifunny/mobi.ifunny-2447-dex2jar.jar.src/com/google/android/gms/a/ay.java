package com.google.android.gms.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class ay
        implements Handler.Callback {
    ay(aw paramaw) {
    }

    public boolean handleMessage(Message paramMessage) {
        if ((1 == paramMessage.what) && (aw.f().equals(paramMessage.obj))) {
            bl.a().a(true);
            this.a.a();
            bl.a().a(false);
            if ((aw.b(this.a) > 0) && (!aw.c(this.a))) {
                aw.d(this.a).sendMessageDelayed(aw.d(this.a).obtainMessage(1, aw.f()), aw.b(this.a) * 1000);
            }
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */