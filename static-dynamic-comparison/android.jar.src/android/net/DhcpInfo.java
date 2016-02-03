/*   */
package android.net;
/*   */ 
/*   */

import android.os.Parcel;

/*   */
/* 5 */ public class DhcpInfo implements android.os.Parcelable {
    public DhcpInfo() {
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
/*   */   public int ipAddress;
    /*   */   public int gateway;
    /*   */   public int netmask;
    /*   */   public int dns1;
    /*   */   public int dns2;
    /*   */   public int serverAddress;
    /*   */   public int leaseDuration;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/DhcpInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */