/*    */
package android.net;
/*    */ 
/*    */

import java.net.InetAddress;

/*    */
/*    */ public class VpnService extends android.app.Service {
    public static final String SERVICE_INTERFACE = "android.net.VpnService";

    /*    */
/*  7 */   public class Builder {
        public Builder() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public Builder setSession(String session) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public Builder setConfigureIntent(android.app.PendingIntent intent) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public Builder setMtu(int mtu) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public Builder addAddress(InetAddress address, int prefixLength) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public Builder addAddress(String address, int prefixLength) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public Builder addRoute(InetAddress address, int prefixLength) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public Builder addRoute(String address, int prefixLength) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public Builder addDnsServer(InetAddress address) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public Builder addDnsServer(String address) {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public Builder addSearchDomain(String domain) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public android.os.ParcelFileDescriptor establish() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 20 */
    public VpnService() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static android.content.Intent prepare(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean protect(int socket) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean protect(java.net.Socket socket) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean protect(java.net.DatagramSocket socket) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public android.os.IBinder onBind(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void onRevoke() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/VpnService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */