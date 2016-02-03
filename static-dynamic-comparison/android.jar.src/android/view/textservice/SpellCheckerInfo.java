/*    */
package android.view.textservice;
/*    */ 
/*    */

import android.content.pm.PackageManager;

/*    */
/*  5 */ public final class SpellCheckerInfo implements android.os.Parcelable {
    SpellCheckerInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getId() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public android.content.ComponentName getComponent() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String getPackageName() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public CharSequence loadLabel(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.graphics.drawable.Drawable loadIcon(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public android.content.pm.ServiceInfo getServiceInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String getSettingsActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getSubtypeCount() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public SpellCheckerSubtype getSubtypeAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 18 */   public static final android.os.Parcelable.Creator<SpellCheckerInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/textservice/SpellCheckerInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */