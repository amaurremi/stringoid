/*   */
package android.bluetooth;
/*   */ 
/*   */

import java.util.List;

/*   */
/* 5 */ public final class BluetoothA2dp implements BluetoothProfile {
    BluetoothA2dp() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public List<BluetoothDevice> getConnectedDevices() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public int getConnectionState(BluetoothDevice device) {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public boolean isA2dpPlaying(BluetoothDevice device) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    /*   */   public static final String ACTION_PLAYING_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED";
    /*   */   public static final int STATE_PLAYING = 10;
    /*   */   public static final int STATE_NOT_PLAYING = 11;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/bluetooth/BluetoothA2dp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */