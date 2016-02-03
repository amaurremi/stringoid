package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class k {
    public static Object a(m paramm) {
        return new l(paramm);
    }

    public static Object a(Object paramObject, View paramView) {
        return ((View.AccessibilityDelegate) paramObject).getAccessibilityNodeProvider(paramView);
    }

    public static boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle) {
        return ((View.AccessibilityDelegate) paramObject).performAccessibilityAction(paramView, paramInt, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */