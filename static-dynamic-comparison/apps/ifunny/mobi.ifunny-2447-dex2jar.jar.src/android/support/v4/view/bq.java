package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class bq {
    public static void a(View paramView, Object paramObject) {
        paramView.setAccessibilityDelegate((View.AccessibilityDelegate) paramObject);
    }

    public static boolean a(View paramView, int paramInt) {
        return paramView.canScrollHorizontally(paramInt);
    }

    public static boolean b(View paramView, int paramInt) {
        return paramView.canScrollVertically(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */