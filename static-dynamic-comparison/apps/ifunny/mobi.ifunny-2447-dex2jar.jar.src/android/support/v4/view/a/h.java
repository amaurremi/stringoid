package android.support.v4.view.a;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class h {
    public static int a(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).getActions();
    }

    public static void a(Object paramObject, int paramInt) {
        ((AccessibilityNodeInfo) paramObject).addAction(paramInt);
    }

    public static void a(Object paramObject, Rect paramRect) {
        ((AccessibilityNodeInfo) paramObject).getBoundsInParent(paramRect);
    }

    public static void a(Object paramObject, View paramView) {
        ((AccessibilityNodeInfo) paramObject).setParent(paramView);
    }

    public static void a(Object paramObject, CharSequence paramCharSequence) {
        ((AccessibilityNodeInfo) paramObject).setClassName(paramCharSequence);
    }

    public static void a(Object paramObject, boolean paramBoolean) {
        ((AccessibilityNodeInfo) paramObject).setScrollable(paramBoolean);
    }

    public static CharSequence b(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).getClassName();
    }

    public static void b(Object paramObject, Rect paramRect) {
        ((AccessibilityNodeInfo) paramObject).getBoundsInScreen(paramRect);
    }

    public static CharSequence c(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).getContentDescription();
    }

    public static CharSequence d(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).getPackageName();
    }

    public static CharSequence e(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).getText();
    }

    public static boolean f(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isCheckable();
    }

    public static boolean g(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isChecked();
    }

    public static boolean h(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isClickable();
    }

    public static boolean i(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isEnabled();
    }

    public static boolean j(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isFocusable();
    }

    public static boolean k(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isFocused();
    }

    public static boolean l(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isLongClickable();
    }

    public static boolean m(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isPassword();
    }

    public static boolean n(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isScrollable();
    }

    public static boolean o(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).isSelected();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */