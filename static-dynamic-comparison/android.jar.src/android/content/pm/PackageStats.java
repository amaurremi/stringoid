/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class PackageStats implements android.os.Parcelable {
    public PackageStats(String pkgName) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public PackageStats(Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public PackageStats(PackageStats pStats) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public String packageName;
    /*    */   public long codeSize;
    /*    */   public long dataSize;
    /*    */   public long cacheSize;
    /*    */   public long externalCodeSize;
    /*    */   public long externalDataSize;
    /*    */   public long externalCacheSize;
    /*    */   public long externalMediaSize;
    /*    */   public long externalObbSize;
    /* 21 */   public static final android.os.Parcelable.Creator<PackageStats> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/PackageStats.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */