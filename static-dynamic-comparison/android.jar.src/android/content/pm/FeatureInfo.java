/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class FeatureInfo implements android.os.Parcelable {
    public FeatureInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public FeatureInfo(FeatureInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String getGlEsVersion() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public String name;
    /*    */   public static final int GL_ES_VERSION_UNDEFINED = 0;
    /*    */   public int reqGlEsVersion;
    /*    */   public static final int FLAG_REQUIRED = 1;
    /*    */   public int flags;
    /* 17 */   public static final android.os.Parcelable.Creator<FeatureInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/FeatureInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */