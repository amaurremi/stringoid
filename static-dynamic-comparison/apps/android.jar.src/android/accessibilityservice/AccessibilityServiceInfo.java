/*    */
package android.accessibilityservice;
/*    */

import android.content.pm.PackageManager;

/*    */
/*    */ public class AccessibilityServiceInfo implements android.os.Parcelable {
    public static final int FEEDBACK_SPOKEN = 1;
    public static final int FEEDBACK_HAPTIC = 2;
    public static final int FEEDBACK_AUDIBLE = 4;
    public static final int FEEDBACK_VISUAL = 8;
    public static final int FEEDBACK_GENERIC = 16;

    /*  5 */
    public AccessibilityServiceInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getId() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public android.content.pm.ResolveInfo getResolveInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String getSettingsActivityName() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean getCanRetrieveWindowContent() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 11 */ public String getDescription() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String loadDescription(PackageManager packageManager) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void writeToParcel(android.os.Parcel parcel, int flagz) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static String feedbackTypeToString(int feedbackType) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static String flagToString(int flag) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public static final int FEEDBACK_ALL_MASK = -1;
    /*    */
/*    */   public static final int DEFAULT = 1;
    /*    */
/*    */   public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    /*    */
/*    */   public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    /*    */   public int eventTypes;
    /* 28 */   public String[] packageNames = null;
    /*    */
/*    */   public int feedbackType;
    /*    */   public long notificationTimeout;
    /*    */   public int flags;
    /* 33 */   public static final android.os.Parcelable.Creator<AccessibilityServiceInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/accessibilityservice/AccessibilityServiceInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */