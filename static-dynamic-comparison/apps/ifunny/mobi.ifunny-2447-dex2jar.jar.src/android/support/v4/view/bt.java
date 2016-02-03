package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class bt {
    static final bw a = new bu();

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new bv();
            return;
        }
    }

    public static int a(ViewConfiguration paramViewConfiguration) {
        return a.a(paramViewConfiguration);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */