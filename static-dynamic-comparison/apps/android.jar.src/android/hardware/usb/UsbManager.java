/*    */
package android.hardware.usb;
/*    */

import android.app.PendingIntent;

/*    */
/*  4 */ public class UsbManager {
    UsbManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public java.util.HashMap<String, UsbDevice> getDeviceList() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public UsbDeviceConnection openDevice(UsbDevice device) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public UsbAccessory[] getAccessoryList() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public android.os.ParcelFileDescriptor openAccessory(UsbAccessory accessory) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean hasPermission(UsbDevice device) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean hasPermission(UsbAccessory accessory) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void requestPermission(UsbDevice device, PendingIntent pi) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void requestPermission(UsbAccessory accessory, PendingIntent pi) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String ACTION_USB_DEVICE_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    /*    */   public static final String ACTION_USB_DEVICE_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";
    /*    */   public static final String ACTION_USB_ACCESSORY_ATTACHED = "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";
    /*    */   public static final String ACTION_USB_ACCESSORY_DETACHED = "android.hardware.usb.action.USB_ACCESSORY_DETACHED";
    /*    */   public static final String EXTRA_DEVICE = "device";
    /*    */   public static final String EXTRA_ACCESSORY = "accessory";
    /*    */   public static final String EXTRA_PERMISSION_GRANTED = "permission";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/usb/UsbManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */