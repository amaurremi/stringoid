package uk.co.a.a.b.b;

import android.os.Build.VERSION;
import android.view.View;

public class a {
    public static void a(View paramView, float paramFloat) {
        if (Build.VERSION.SDK_INT >= 11) {
            c.a(paramView, paramFloat);
            return;
        }
        b.a(paramView, paramFloat);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */