/*    */
package android.hardware.usb;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class UsbInterface implements android.os.Parcelable {
    UsbInterface() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getId() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getInterfaceClass() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getInterfaceSubclass() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getInterfaceProtocol() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getEndpointCount() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public UsbEndpoint getEndpoint(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 16 */   public static final android.os.Parcelable.Creator<UsbInterface> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/usb/UsbInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */