/*    */
package android.hardware.usb;
/*    */

import java.nio.ByteBuffer;

/*    */
/*  4 */ public class UsbRequest {
    public UsbRequest() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public boolean initialize(UsbDeviceConnection connection, UsbEndpoint endpoint) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public UsbEndpoint getEndpoint() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Object getClientData() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setClientData(Object data) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean queue(ByteBuffer buffer, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean cancel() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/usb/UsbRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */