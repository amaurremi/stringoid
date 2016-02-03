/*    */
package android.view.accessibility;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public final class AccessibilityEvent extends AccessibilityRecord implements android.os.Parcelable {
    /*  6 */   AccessibilityEvent() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getRecordCount() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void appendRecord(AccessibilityRecord record) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public AccessibilityRecord getRecord(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getEventType() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setEventType(int eventType) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public long getEventTime() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setEventTime(long eventTime) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public CharSequence getPackageName() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setPackageName(CharSequence packageName) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setMovementGranularity(int granularity) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getMovementGranularity() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setAction(int action) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getAction() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static AccessibilityEvent obtain(int eventType) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static AccessibilityEvent obtain(AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static AccessibilityEvent obtain() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void recycle() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void initFromParcel(Parcel parcel) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public static String eventTypeToString(int eventType) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int INVALID_POSITION = -1;
    /*    */
    @Deprecated
/*    */ public static final int MAX_TEXT_LENGTH = 500;
    /*    */   public static final int TYPE_VIEW_CLICKED = 1;
    /*    */   public static final int TYPE_VIEW_LONG_CLICKED = 2;
    /*    */   public static final int TYPE_VIEW_SELECTED = 4;
    /*    */   public static final int TYPE_VIEW_FOCUSED = 8;
    /*    */   public static final int TYPE_VIEW_TEXT_CHANGED = 16;
    /*    */   public static final int TYPE_WINDOW_STATE_CHANGED = 32;
    /*    */   public static final int TYPE_NOTIFICATION_STATE_CHANGED = 64;
    /*    */   public static final int TYPE_VIEW_HOVER_ENTER = 128;
    /*    */   public static final int TYPE_VIEW_HOVER_EXIT = 256;
    /*    */   public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    /*    */   public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    /*    */   public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
    /*    */   public static final int TYPE_VIEW_SCROLLED = 4096;
    /*    */   public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    /*    */   public static final int TYPE_ANNOUNCEMENT = 16384;
    /*    */   public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    /*    */   public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    /*    */   public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    /*    */   public static final int TYPES_ALL_MASK = -1;
    /* 52 */   public static final android.os.Parcelable.Creator<AccessibilityEvent> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/accessibility/AccessibilityEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */