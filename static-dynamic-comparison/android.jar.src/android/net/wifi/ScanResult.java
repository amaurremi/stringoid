/*   */
package android.net.wifi;
/*   */ 
/*   */

import android.os.Parcel;

/*   */
/* 5 */ public class ScanResult implements android.os.Parcelable {
    ScanResult() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public String SSID;
    /*   */   public String BSSID;
    /*   */   public String capabilities;
    /*   */   public int level;
    /*   */   public int frequency;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/ScanResult.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */