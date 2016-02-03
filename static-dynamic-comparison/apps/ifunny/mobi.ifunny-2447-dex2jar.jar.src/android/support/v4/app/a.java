package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;

public class a
        extends android.support.v4.a.c {
    public static void a(Activity paramActivity) {
        if (Build.VERSION.SDK_INT >= 16) {
            c.a(paramActivity);
            return;
        }
        paramActivity.finish();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */