package android.support.v4.a;

import android.os.Handler;
import android.os.Message;

class x
        extends Handler {
    public void handleMessage(Message paramMessage) {
        w localw = (w) paramMessage.obj;
        switch (paramMessage.what) {
            default:
                return;
            case 1:
                r.c(localw.a, localw.b[0]);
                return;
        }
        localw.a.b(localw.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */