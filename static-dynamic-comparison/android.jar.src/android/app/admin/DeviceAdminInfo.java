/*    */
package android.app.admin;
/*    */ 
/*    */

import android.content.pm.PackageManager;

/*    */
/*  5 */ public final class DeviceAdminInfo implements android.os.Parcelable {
    public DeviceAdminInfo(android.content.Context context, android.content.pm.ResolveInfo receiver) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getPackageName() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getReceiverName() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public android.content.pm.ActivityInfo getActivityInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public android.content.ComponentName getComponent() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public CharSequence loadLabel(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public CharSequence loadDescription(PackageManager pm) throws android.content.res.Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public android.graphics.drawable.Drawable loadIcon(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isVisible() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean usesPolicy(int policyIdent) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String getTagForPolicy(int policyIdent) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void dump(android.util.Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    /*    */   public static final int USES_POLICY_WATCH_LOGIN = 1;
    /*    */   public static final int USES_POLICY_RESET_PASSWORD = 2;
    /*    */   public static final int USES_POLICY_FORCE_LOCK = 3;
    /*    */   public static final int USES_POLICY_WIPE_DATA = 4;
    /*    */   public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    /*    */   public static final int USES_ENCRYPTED_STORAGE = 7;
    /*    */   public static final int USES_POLICY_DISABLE_CAMERA = 8;
    /* 29 */   public static final android.os.Parcelable.Creator<DeviceAdminInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/admin/DeviceAdminInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */