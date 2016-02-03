package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.a;

final class f
        extends Handler {
    public f(e parame, Looper paramLooper) {
        super(paramLooper);
    }

    public void handleMessage(Message paramMessage) {
        if ((paramMessage.what == 1) && (!this.a.i())) {
            paramMessage = (g) paramMessage.obj;
            paramMessage.a();
            paramMessage.c();
            return;
        }
        if (paramMessage.what == 3) {
            e.a(this.a).a(new a(((Integer) paramMessage.obj).intValue(), null));
            return;
        }
        if (paramMessage.what == 4) {
            e.a(this.a, 1);
            e.a(this.a, null);
            e.a(this.a).a(((Integer) paramMessage.obj).intValue());
            return;
        }
        if ((paramMessage.what == 2) && (!this.a.c())) {
            paramMessage = (g) paramMessage.obj;
            paramMessage.a();
            paramMessage.c();
            return;
        }
        if ((paramMessage.what == 2) || (paramMessage.what == 1)) {
            ((g) paramMessage.obj).b();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */