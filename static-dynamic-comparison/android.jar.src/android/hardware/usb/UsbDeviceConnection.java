/*    */
package android.hardware.usb;

/*    */
/*    */ public class UsbDeviceConnection {
    /*  4 */   UsbDeviceConnection() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getFileDescriptor() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public byte[] getRawDescriptors() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean claimInterface(UsbInterface intf, boolean force) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean releaseInterface(UsbInterface intf) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int controlTransfer(int requestType, int request, int value, int index, byte[] buffer, int length, int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public UsbRequest requestWait() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String getSerial() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/usb/UsbDeviceConnection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */