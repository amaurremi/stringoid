/*    */
package android.net.wifi.p2p;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class WifiP2pGroup implements android.os.Parcelable {
    public WifiP2pGroup() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public WifiP2pGroup(WifiP2pGroup source) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getNetworkName() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean isGroupOwner() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public WifiP2pDevice getOwner() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public java.util.Collection<WifiP2pDevice> getClientList() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String getPassphrase() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String getInterface() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 17 */   public static final android.os.Parcelable.Creator<WifiP2pGroup> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/p2p/WifiP2pGroup.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */