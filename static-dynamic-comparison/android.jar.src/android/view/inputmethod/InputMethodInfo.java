/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.content.pm.PackageManager;

/*    */
/*  5 */ public final class InputMethodInfo implements android.os.Parcelable {
    public InputMethodInfo(android.content.Context context, android.content.pm.ResolveInfo service) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public InputMethodInfo(String packageName, String className, CharSequence label, String settingsActivity) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getId() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String getPackageName() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String getServiceName() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public android.content.pm.ServiceInfo getServiceInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.content.ComponentName getComponent() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public CharSequence loadLabel(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public android.graphics.drawable.Drawable loadIcon(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String getSettingsActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getSubtypeCount() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public InputMethodSubtype getSubtypeAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getIsDefaultResourceId() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void dump(android.util.Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 25 */   public static final android.os.Parcelable.Creator<InputMethodInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/InputMethodInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */