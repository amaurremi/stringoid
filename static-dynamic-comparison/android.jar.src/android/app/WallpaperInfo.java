/*    */
package android.app;
/*    */ 
/*    */

import android.content.pm.PackageManager;

/*    */
/*  5 */ public final class WallpaperInfo implements android.os.Parcelable {
    public WallpaperInfo(android.content.Context context, android.content.pm.ResolveInfo service) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getPackageName() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getServiceName() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public android.content.pm.ServiceInfo getServiceInfo() {
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
    public android.graphics.drawable.Drawable loadIcon(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public android.graphics.drawable.Drawable loadThumbnail(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public CharSequence loadAuthor(PackageManager pm) throws android.content.res.Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public CharSequence loadDescription(PackageManager pm) throws android.content.res.Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String getSettingsActivity() {
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
/* 21 */   public static final android.os.Parcelable.Creator<WallpaperInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/WallpaperInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */