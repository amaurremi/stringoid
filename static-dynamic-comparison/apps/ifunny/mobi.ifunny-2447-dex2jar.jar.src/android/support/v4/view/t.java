package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

class t
        extends Handler {
    t(s params) {
    }

    t(s params, Handler paramHandler) {
        super(paramHandler.getLooper());
    }

    public void handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
            default:
                throw new RuntimeException("Unknown message " + paramMessage);
            case 1:
                s.b(this.a).onShowPress(s.a(this.a));
        }
        do {
            return;
            s.c(this.a);
            return;
        } while (s.d(this.a) == null);
        if (!s.e(this.a)) {
            s.d(this.a).onSingleTapConfirmed(s.a(this.a));
            return;
        }
        s.a(this.a, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */