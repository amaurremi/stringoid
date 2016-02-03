/*    */
package android.hardware.usb;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class UsbEndpoint implements android.os.Parcelable {
    UsbEndpoint() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getAddress() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getEndpointNumber() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getDirection() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getAttributes() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getType() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getMaxPacketSize() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getInterval() {
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
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 17 */   public static final android.os.Parcelable.Creator<UsbEndpoint> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/usb/UsbEndpoint.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */