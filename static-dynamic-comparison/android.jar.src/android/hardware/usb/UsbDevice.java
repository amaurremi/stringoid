/*    */
package android.hardware.usb;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class UsbDevice implements android.os.Parcelable {
    UsbDevice() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getDeviceName() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getDeviceId() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getVendorId() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getProductId() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getDeviceClass() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getDeviceSubclass() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getDeviceProtocol() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getInterfaceCount() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public UsbInterface getInterface(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static int getDeviceId(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static String getDeviceName(int id) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 23 */   public static final android.os.Parcelable.Creator<UsbDevice> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/usb/UsbDevice.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */