/*   */
package android.bluetooth;
/*   */

import android.os.ParcelFileDescriptor;

/*   */
/* 4 */ public abstract class BluetoothHealthCallback {
    public BluetoothHealthCallback() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration config, int status) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void onHealthChannelStateChange(BluetoothHealthAppConfiguration config, BluetoothDevice device, int prevState, int newState, ParcelFileDescriptor fd, int channelId) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/bluetooth/BluetoothHealthCallback.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */