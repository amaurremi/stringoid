package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatKitKat {
    public static int getLiveRegion(Object paramObject) {
        return ((AccessibilityNodeInfo) paramObject).getLiveRegion();
    }

    public static void setLiveRegion(Object paramObject, int paramInt) {
        ((AccessibilityNodeInfo) paramObject).setLiveRegion(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/view/accessibility/AccessibilityNodeInfoCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */