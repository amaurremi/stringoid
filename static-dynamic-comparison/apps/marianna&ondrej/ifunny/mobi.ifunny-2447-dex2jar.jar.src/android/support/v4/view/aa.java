package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class aa {
    static final ae a = new ab();

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new ad();
            return;
        }
    }

    public static boolean a(KeyEvent paramKeyEvent) {
        return a.b(paramKeyEvent.getMetaState());
    }

    public static boolean a(KeyEvent paramKeyEvent, int paramInt) {
        return a.a(paramKeyEvent.getMetaState(), paramInt);
    }

    public static void b(KeyEvent paramKeyEvent) {
        a.a(paramKeyEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */