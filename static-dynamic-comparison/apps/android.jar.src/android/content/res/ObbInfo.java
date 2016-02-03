/*    */
package android.content.res;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class ObbInfo implements android.os.Parcelable {
    ObbInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int OBB_OVERLAY = 1;
    /*    */   public String filename;
    /*    */   public String packageName;
    /*    */   public int version;
    /*    */   public int flags;
    /* 15 */   public static final android.os.Parcelable.Creator<ObbInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/res/ObbInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */