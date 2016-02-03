/*    */
package android.net.wifi.p2p;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.net.wifi.p2p.nsd.WifiP2pServiceInfo;
/*    */ import android.net.wifi.p2p.nsd.WifiP2pServiceRequest;
/*    */ import android.os.Looper;
/*    */ import java.util.List;
/*    */ import java.util.Map;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WifiP2pManager
/*    */ {
    /*    */   public static final String WIFI_P2P_STATE_CHANGED_ACTION = "android.net.wifi.p2p.STATE_CHANGED";
    /*    */   public static final String EXTRA_WIFI_STATE = "wifi_p2p_state";
    /*    */   public static final int WIFI_P2P_STATE_DISABLED = 1;
    /*    */   public static final int WIFI_P2P_STATE_ENABLED = 2;
    /*    */   public static final String WIFI_P2P_CONNECTION_CHANGED_ACTION = "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";
    /*    */   public static final String EXTRA_WIFI_P2P_INFO = "wifiP2pInfo";
    /*    */   public static final String EXTRA_NETWORK_INFO = "networkInfo";
    /*    */   public static final String WIFI_P2P_PEERS_CHANGED_ACTION = "android.net.wifi.p2p.PEERS_CHANGED";
    /*    */   public static final String WIFI_P2P_DISCOVERY_CHANGED_ACTION = "android.net.wifi.p2p.DISCOVERY_STATE_CHANGE";
    /*    */   public static final String EXTRA_DISCOVERY_STATE = "discoveryState";
    /*    */   public static final int WIFI_P2P_DISCOVERY_STOPPED = 1;
    /*    */   public static final int WIFI_P2P_DISCOVERY_STARTED = 2;
    /*    */   public static final String WIFI_P2P_THIS_DEVICE_CHANGED_ACTION = "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
    /*    */   public static final String EXTRA_WIFI_P2P_DEVICE = "wifiP2pDevice";
    /*    */   public static final int ERROR = 0;
    /*    */   public static final int P2P_UNSUPPORTED = 1;
    /*    */   public static final int BUSY = 2;
    /*    */   public static final int NO_SERVICE_REQUESTS = 3;

    /*    */
/*    */   public static class Channel
/*    */ {
        /* 43 */     Channel() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 45 */   WifiP2pManager() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public Channel initialize(Context srcContext, Looper srcLooper, ChannelListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void discoverPeers(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void stopPeerDiscovery(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void connect(Channel c, WifiP2pConfig config, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void cancelConnect(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void createGroup(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void removeGroup(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void addLocalService(Channel c, WifiP2pServiceInfo servInfo, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void removeLocalService(Channel c, WifiP2pServiceInfo servInfo, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void clearLocalServices(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void setServiceResponseListener(Channel c, ServiceResponseListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void setDnsSdResponseListeners(Channel c, DnsSdServiceResponseListener servListener, DnsSdTxtRecordListener txtListener) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void setUpnpServiceResponseListener(Channel c, UpnpServiceResponseListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public void discoverServices(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public void addServiceRequest(Channel c, WifiP2pServiceRequest req, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void removeServiceRequest(Channel c, WifiP2pServiceRequest req, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void clearServiceRequests(Channel c, ActionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public void requestPeers(Channel c, PeerListListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void requestConnectionInfo(Channel c, ConnectionInfoListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void requestGroupInfo(Channel c, GroupInfoListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface UpnpServiceResponseListener
/*    */ {
        /*    */
        public abstract void onUpnpServiceAvailable(List<String> paramList, WifiP2pDevice paramWifiP2pDevice);
/*    */
    }

    /*    */
/*    */   public static abstract interface DnsSdTxtRecordListener
/*    */ {
        /*    */
        public abstract void onDnsSdTxtRecordAvailable(String paramString, Map<String, String> paramMap, WifiP2pDevice paramWifiP2pDevice);
/*    */
    }

    /*    */
/*    */   public static abstract interface DnsSdServiceResponseListener
/*    */ {
        /*    */
        public abstract void onDnsSdServiceAvailable(String paramString1, String paramString2, WifiP2pDevice paramWifiP2pDevice);
/*    */
    }

    /*    */
/*    */   public static abstract interface ServiceResponseListener
/*    */ {
        /*    */
        public abstract void onServiceAvailable(int paramInt, byte[] paramArrayOfByte, WifiP2pDevice paramWifiP2pDevice);
/*    */
    }

    /*    */
/*    */   public static abstract interface GroupInfoListener
/*    */ {
        /*    */
        public abstract void onGroupInfoAvailable(WifiP2pGroup paramWifiP2pGroup);
/*    */
    }

    /*    */
/*    */   public static abstract interface ConnectionInfoListener
/*    */ {
        /*    */
        public abstract void onConnectionInfoAvailable(WifiP2pInfo paramWifiP2pInfo);
/*    */
    }

    /*    */
/*    */   public static abstract interface PeerListListener
/*    */ {
        /*    */
        public abstract void onPeersAvailable(WifiP2pDeviceList paramWifiP2pDeviceList);
/*    */
    }

    /*    */
/*    */   public static abstract interface ActionListener
/*    */ {
        /*    */
        public abstract void onSuccess();

        /*    */
/*    */
        public abstract void onFailure(int paramInt);
/*    */
    }

    /*    */
/*    */   public static abstract interface ChannelListener
/*    */ {
        /*    */
        public abstract void onChannelDisconnected();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/p2p/WifiP2pManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */