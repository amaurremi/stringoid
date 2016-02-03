/*    */
package android.net.wifi;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class WpsInfo implements android.os.Parcelable {
    public WpsInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public WpsInfo(WpsInfo source) {
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
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int PBC = 0;
    /*    */   public static final int DISPLAY = 1;
    /*    */   public static final int KEYPAD = 2;
    /*    */   public static final int LABEL = 3;
    /*    */   public static final int INVALID = 4;
    /*    */   public int setup;
    /*    */   public String pin;
    /* 18 */   public static final android.os.Parcelable.Creator<WpsInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/WpsInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */