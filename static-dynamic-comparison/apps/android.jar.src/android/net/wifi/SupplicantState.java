/*    */
package android.net.wifi;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public enum SupplicantState implements android.os.Parcelable {
    ASSOCIATED,
    /*  6 */   ASSOCIATING,
    /*  7 */   AUTHENTICATING,
    /*  8 */   COMPLETED,
    /*  9 */   DISCONNECTED,
    /* 10 */   DORMANT,
    /* 11 */   FOUR_WAY_HANDSHAKE,
    /* 12 */   GROUP_HANDSHAKE,
    /* 13 */   INACTIVE,
    /* 14 */   INTERFACE_DISABLED,
    /* 15 */   INVALID,
    /* 16 */   SCANNING,
    /* 17 */   UNINITIALIZED;

    /* 18 */
    private SupplicantState() {
    }

    public static boolean isValidState(SupplicantState state) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/SupplicantState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */