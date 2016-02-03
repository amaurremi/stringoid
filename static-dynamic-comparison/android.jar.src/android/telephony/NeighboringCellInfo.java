/*    */
package android.telephony;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class NeighboringCellInfo implements android.os.Parcelable {
    @Deprecated
/*  6 */ public NeighboringCellInfo() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  8 */ public NeighboringCellInfo(int rssi, int cid) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public NeighboringCellInfo(int rssi, String location, int radioType) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public NeighboringCellInfo(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getRssi() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getLac() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getCid() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getPsc() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getNetworkType() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 17 */ public void setCid(int cid) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 19 */ public void setRssi(int rssi) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int UNKNOWN_RSSI = 99;
    /*    */   public static final int UNKNOWN_CID = -1;
    /* 26 */   public static final android.os.Parcelable.Creator<NeighboringCellInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/telephony/NeighboringCellInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */