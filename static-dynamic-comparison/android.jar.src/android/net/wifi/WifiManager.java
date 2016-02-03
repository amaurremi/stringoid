/*    */
package android.net.wifi;
/*    */ 
/*    */

import android.os.WorkSource;

/*    */
/*    */ public class WifiManager {
    /*  6 */   public class WifiLock {
        WifiLock() {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public void acquire() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public void release() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public void setReferenceCounted(boolean refCounted) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public boolean isHeld() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public void setWorkSource(WorkSource ws) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        protected void finalize() throws Throwable {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/*    */   public static final int ERROR_AUTHENTICATING = 1;

    /*    */
/* 17 */   public class MulticastLock {
        MulticastLock() {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public void acquire() {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public void release() {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public void setReferenceCounted(boolean refCounted) {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public boolean isHeld() {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        protected void finalize() throws Throwable {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 25 */   public static final String WIFI_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";

    WifiManager() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public java.util.List<WifiConfiguration> getConfiguredNetworks() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int addNetwork(WifiConfiguration config) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public int updateNetwork(WifiConfiguration config) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean removeNetwork(int netId) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean enableNetwork(int netId, boolean disableOthers) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean disableNetwork(int netId) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean disconnect() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean reconnect() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public boolean reassociate() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean pingSupplicant() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean startScan() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public WifiInfo getConnectionInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public java.util.List<ScanResult> getScanResults() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean saveConfiguration() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public android.net.DhcpInfo getDhcpInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean setWifiEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int getWifiState() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean isWifiEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public static int calculateSignalLevel(int rssi, int numLevels) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public static int compareSignalLevel(int rssiA, int rssiB) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public WifiLock createWifiLock(int lockType, String tag) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public WifiLock createWifiLock(String tag) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public MulticastLock createMulticastLock(String tag) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String EXTRA_WIFI_STATE = "wifi_state";
    /*    */   public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
    /*    */   public static final int WIFI_STATE_DISABLING = 0;
    /*    */   public static final int WIFI_STATE_DISABLED = 1;
    /*    */   public static final int WIFI_STATE_ENABLING = 2;
    /*    */   public static final int WIFI_STATE_ENABLED = 3;
    /*    */   public static final int WIFI_STATE_UNKNOWN = 4;
    /*    */   public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION = "android.net.wifi.supplicant.CONNECTION_CHANGE";
    /*    */   public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    /*    */   public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    /*    */   public static final String EXTRA_NETWORK_INFO = "networkInfo";
    /*    */   public static final String EXTRA_BSSID = "bssid";
    /*    */   public static final String EXTRA_WIFI_INFO = "wifiInfo";
    /*    */   public static final String SUPPLICANT_STATE_CHANGED_ACTION = "android.net.wifi.supplicant.STATE_CHANGE";
    /*    */   public static final String EXTRA_NEW_STATE = "newState";
    /*    */   public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    /*    */   public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    /*    */   public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    /*    */   public static final String EXTRA_NEW_RSSI = "newRssi";
    /*    */   public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    /*    */   public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
    /*    */   public static final int WIFI_MODE_FULL = 1;
    /*    */   public static final int WIFI_MODE_SCAN_ONLY = 2;
    /*    */   public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/WifiManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */