package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityEventCompatIcs {
    public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject) {
        paramAccessibilityEvent.appendRecord((AccessibilityRecord) paramObject);
    }

    public static Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt) {
        return paramAccessibilityEvent.getRecord(paramInt);
    }

    public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent) {
        return paramAccessibilityEvent.getRecordCount();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/android/support/v4/view/accessibility/AccessibilityEventCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */