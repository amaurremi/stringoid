/*   */
package android.net.wifi.p2p.nsd;
/*   */ 
/*   */

import android.os.Parcel;

/*   */
/* 5 */ public class WifiP2pServiceInfo implements android.os.Parcelable {
    WifiP2pServiceInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int SERVICE_TYPE_ALL = 0;
    /*   */   public static final int SERVICE_TYPE_BONJOUR = 1;
    /*   */   public static final int SERVICE_TYPE_UPNP = 2;
    /*   */   public static final int SERVICE_TYPE_VENDOR_SPECIFIC = 255;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/p2p/nsd/WifiP2pServiceInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */