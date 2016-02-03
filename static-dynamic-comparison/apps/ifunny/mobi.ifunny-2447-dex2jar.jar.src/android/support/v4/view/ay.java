package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class ay {
    static final bb a = new az();

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new ba();
            return;
        }
    }

    public static float a(VelocityTracker paramVelocityTracker, int paramInt) {
        return a.a(paramVelocityTracker, paramInt);
    }

    public static float b(VelocityTracker paramVelocityTracker, int paramInt) {
        return a.b(paramVelocityTracker, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */