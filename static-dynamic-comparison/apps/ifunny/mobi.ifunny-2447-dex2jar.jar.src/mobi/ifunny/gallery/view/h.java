package mobi.ifunny.gallery.view;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnGestureListener;

class h
        extends Handler {
    h(g paramg) {
    }

    public void handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
            default:
                throw new RuntimeException("Unknown message " + paramMessage);
            case 1:
                g.b(this.a).onShowPress(g.a(this.a));
        }
        do {
            do {
                do {
                    do {
                        return;
                        g.c(this.a);
                        return;
                    } while (g.d(this.a) == null);
                    if (g.e(this.a) == 1) {
                        g.a(this.a, g.a(this.a));
                        return;
                    }
                    if (g.e(this.a) != 2) {
                        break;
                    }
                    g.b(this.a, g.a(this.a));
                } while (!g.f(this.a));
                g.a(this.a, true);
                return;
            } while (g.e(this.a) != 3);
            g.c(this.a, g.a(this.a));
        } while (!g.f(this.a));
        g.a(this.a, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */