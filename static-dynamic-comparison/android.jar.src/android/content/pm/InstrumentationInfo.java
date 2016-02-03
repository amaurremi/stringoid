/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class InstrumentationInfo extends PackageItemInfo implements android.os.Parcelable {
    /*  6 */
    public InstrumentationInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public InstrumentationInfo(InstrumentationInfo orig) {
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
/*    */   public String targetPackage;
    /*    */   public String sourceDir;
    /*    */   public String publicSourceDir;
    /*    */   public String dataDir;
    /*    */   public boolean handleProfiling;
    /*    */   public boolean functionalTest;
    /* 18 */   public static final android.os.Parcelable.Creator<InstrumentationInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/InstrumentationInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */