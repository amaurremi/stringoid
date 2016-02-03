package android.support.v4.view;

import android.os.Build.VERSION;

public class v {
    static final w a = new x();

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            a = new y();
            return;
        }
    }

    public static int a(int paramInt1, int paramInt2) {
        return a.a(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */