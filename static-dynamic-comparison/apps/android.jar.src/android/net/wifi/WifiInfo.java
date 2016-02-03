/*    */
package android.net.wifi;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class WifiInfo implements android.os.Parcelable {
    WifiInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getSSID() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getBSSID() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getRssi() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getLinkSpeed() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String getMacAddress() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getNetworkId() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public SupplicantState getSupplicantState() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getIpAddress() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean getHiddenSSID() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static android.net.NetworkInfo.DetailedState getDetailedStateOf(SupplicantState suppState) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String LINK_SPEED_UNITS = "Mbps";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/WifiInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */