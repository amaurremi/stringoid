/*    */
package android.net.wifi.p2p;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class WifiP2pConfig implements android.os.Parcelable {
    public WifiP2pConfig() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public WifiP2pConfig(WifiP2pConfig source) {
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
/*    */   public String deviceAddress;
    /*    */   public android.net.wifi.WpsInfo wps;
    /*    */   public int groupOwnerIntent;
    /* 14 */   public static final android.os.Parcelable.Creator<WifiP2pConfig> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/p2p/WifiP2pConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */