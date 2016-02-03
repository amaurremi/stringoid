/*    */
package android.net.nsd;

/*    */
/*    */ 
/*    */ 
/*    */ public final class NsdManager
/*    */ {
    /*    */   public static final String ACTION_NSD_STATE_CHANGED = "android.net.nsd.STATE_CHANGED";
    /*    */
/*    */ 
/*    */   public static final String EXTRA_NSD_STATE = "nsd_state";
    /*    */
/*    */   public static final int NSD_STATE_DISABLED = 1;
    /*    */
/*    */   public static final int NSD_STATE_ENABLED = 2;
    /*    */
/*    */   public static final int PROTOCOL_DNS_SD = 1;
    /*    */
/*    */   public static final int FAILURE_INTERNAL_ERROR = 0;
    /*    */
/*    */   public static final int FAILURE_ALREADY_ACTIVE = 3;
    /*    */
/*    */   public static final int FAILURE_MAX_LIMIT = 4;

    /*    */
/*    */ 
/* 25 */   NsdManager() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void registerService(NsdServiceInfo serviceInfo, int protocolType, RegistrationListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void unregisterService(RegistrationListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void discoverServices(String serviceType, int protocolType, DiscoveryListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void stopServiceDiscovery(DiscoveryListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void resolveService(NsdServiceInfo serviceInfo, ResolveListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface ResolveListener
/*    */ {
        /*    */
        public abstract void onResolveFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt);

        /*    */
/*    */
        public abstract void onServiceResolved(NsdServiceInfo paramNsdServiceInfo);
/*    */
    }

    /*    */
/*    */   public static abstract interface RegistrationListener
/*    */ {
        /*    */
        public abstract void onRegistrationFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt);

        /*    */
/*    */
        public abstract void onUnregistrationFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt);

        /*    */
/*    */
        public abstract void onServiceRegistered(NsdServiceInfo paramNsdServiceInfo);

        /*    */
/*    */
        public abstract void onServiceUnregistered(NsdServiceInfo paramNsdServiceInfo);
/*    */
    }

    /*    */
/*    */   public static abstract interface DiscoveryListener
/*    */ {
        /*    */
        public abstract void onStartDiscoveryFailed(String paramString, int paramInt);

        /*    */
/*    */
        public abstract void onStopDiscoveryFailed(String paramString, int paramInt);

        /*    */
/*    */
        public abstract void onDiscoveryStarted(String paramString);

        /*    */
/*    */
        public abstract void onDiscoveryStopped(String paramString);

        /*    */
/*    */
        public abstract void onServiceFound(NsdServiceInfo paramNsdServiceInfo);

        /*    */
/*    */
        public abstract void onServiceLost(NsdServiceInfo paramNsdServiceInfo);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/nsd/NsdManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */