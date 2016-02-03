/*    */
package android.bluetooth;
/*    */

import java.util.UUID;

/*    */
/*  4 */ public final class BluetoothAdapter {
    BluetoothAdapter() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static synchronized BluetoothAdapter getDefaultAdapter() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public BluetoothDevice getRemoteDevice(String address) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public BluetoothDevice getRemoteDevice(byte[] address) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getState() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean enable() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean disable() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String getAddress() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean setName(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getScanMode() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean startDiscovery() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean cancelDiscovery() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean isDiscovering() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public java.util.Set<BluetoothDevice> getBondedDevices() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getProfileConnectionState(int profile) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public BluetoothServerSocket listenUsingRfcommWithServiceRecord(String name, UUID uuid) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(String name, UUID uuid) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean getProfileProxy(android.content.Context context, BluetoothProfile.ServiceListener listener, int profile) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void closeProfileProxy(int profile, BluetoothProfile proxy) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static boolean checkBluetoothAddress(String address) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ERROR = Integer.MIN_VALUE;
    /*    */   public static final String ACTION_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
    /*    */   public static final String EXTRA_STATE = "android.bluetooth.adapter.extra.STATE";
    /*    */   public static final String EXTRA_PREVIOUS_STATE = "android.bluetooth.adapter.extra.PREVIOUS_STATE";
    /*    */   public static final int STATE_OFF = 10;
    /*    */   public static final int STATE_TURNING_ON = 11;
    /*    */   public static final int STATE_ON = 12;
    /*    */   public static final int STATE_TURNING_OFF = 13;
    /*    */   public static final String ACTION_REQUEST_DISCOVERABLE = "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE";
    /*    */   public static final String EXTRA_DISCOVERABLE_DURATION = "android.bluetooth.adapter.extra.DISCOVERABLE_DURATION";
    /*    */   public static final String ACTION_REQUEST_ENABLE = "android.bluetooth.adapter.action.REQUEST_ENABLE";
    /*    */   public static final String ACTION_SCAN_MODE_CHANGED = "android.bluetooth.adapter.action.SCAN_MODE_CHANGED";
    /*    */   public static final String EXTRA_SCAN_MODE = "android.bluetooth.adapter.extra.SCAN_MODE";
    /*    */   public static final String EXTRA_PREVIOUS_SCAN_MODE = "android.bluetooth.adapter.extra.PREVIOUS_SCAN_MODE";
    /*    */   public static final int SCAN_MODE_NONE = 20;
    /*    */   public static final int SCAN_MODE_CONNECTABLE = 21;
    /*    */   public static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE = 23;
    /*    */   public static final String ACTION_DISCOVERY_STARTED = "android.bluetooth.adapter.action.DISCOVERY_STARTED";
    /*    */   public static final String ACTION_DISCOVERY_FINISHED = "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
    /*    */   public static final String ACTION_LOCAL_NAME_CHANGED = "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED";
    /*    */   public static final String EXTRA_LOCAL_NAME = "android.bluetooth.adapter.extra.LOCAL_NAME";
    /*    */   public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
    /*    */   public static final String EXTRA_CONNECTION_STATE = "android.bluetooth.adapter.extra.CONNECTION_STATE";
    /*    */   public static final String EXTRA_PREVIOUS_CONNECTION_STATE = "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
    /*    */   public static final int STATE_DISCONNECTED = 0;
    /*    */   public static final int STATE_CONNECTING = 1;
    /*    */   public static final int STATE_CONNECTED = 2;
    /*    */   public static final int STATE_DISCONNECTING = 3;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/bluetooth/BluetoothAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */