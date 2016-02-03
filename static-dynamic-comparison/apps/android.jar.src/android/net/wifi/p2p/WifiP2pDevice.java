/*    */
package android.net.wifi.p2p;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class WifiP2pDevice implements android.os.Parcelable {
    public WifiP2pDevice() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public WifiP2pDevice(WifiP2pDevice source) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean wpsPbcSupported() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean wpsKeypadSupported() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean wpsDisplaySupported() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isServiceDiscoveryCapable() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean isGroupOwner() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean equals(Object obj) {
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
/*    */   public String deviceName;
    /*    */   public String deviceAddress;
    /*    */   public String primaryDeviceType;
    /*    */   public String secondaryDeviceType;
    /*    */   public static final int CONNECTED = 0;
    /*    */   public static final int INVITED = 1;
    /*    */   public static final int FAILED = 2;
    /*    */   public static final int AVAILABLE = 3;
    /*    */   public static final int UNAVAILABLE = 4;
    /*    */   public int status;
    /* 27 */   public static final android.os.Parcelable.Creator<WifiP2pDevice> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/p2p/WifiP2pDevice.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */