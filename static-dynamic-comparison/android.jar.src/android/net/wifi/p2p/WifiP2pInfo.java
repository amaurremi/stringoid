/*    */
package android.net.wifi.p2p;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class WifiP2pInfo implements android.os.Parcelable {
    public WifiP2pInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public WifiP2pInfo(WifiP2pInfo source) {
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
/*    */   public boolean groupFormed;
    /*    */   public boolean isGroupOwner;
    /*    */   public java.net.InetAddress groupOwnerAddress;
    /* 14 */   public static final android.os.Parcelable.Creator<WifiP2pInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/p2p/WifiP2pInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */