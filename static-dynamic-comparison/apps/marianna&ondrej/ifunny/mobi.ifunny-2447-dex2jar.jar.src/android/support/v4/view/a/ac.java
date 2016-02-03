package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

class ac {
    public static Object a() {
        return AccessibilityRecord.obtain();
    }

    public static void a(Object paramObject, int paramInt) {
        ((AccessibilityRecord) paramObject).setFromIndex(paramInt);
    }

    public static void a(Object paramObject, boolean paramBoolean) {
        ((AccessibilityRecord) paramObject).setScrollable(paramBoolean);
    }

    public static void b(Object paramObject, int paramInt) {
        ((AccessibilityRecord) paramObject).setItemCount(paramInt);
    }

    public static void c(Object paramObject, int paramInt) {
        ((AccessibilityRecord) paramObject).setToIndex(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */