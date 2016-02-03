/*    */
package android.net.sip;

/*    */
/*    */ public final class SipSession {
    public static class State {
        public static final int READY_TO_CALL = 0;
        /*    */     public static final int REGISTERING = 1;

        /*    */
/*  6 */     State() {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public static String toString(int state) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */     public static final int DEREGISTERING = 2;
        /*    */     public static final int INCOMING_CALL = 3;
        /*    */     public static final int INCOMING_CALL_ANSWERING = 4;
        /*    */     public static final int OUTGOING_CALL = 5;
        /*    */     public static final int OUTGOING_CALL_RING_BACK = 6;
        /*    */     public static final int OUTGOING_CALL_CANCELING = 7;
        /*    */     public static final int IN_CALL = 8;
        /*    */     public static final int PINGING = 9;
        /*    */     public static final int NOT_DEFINED = 101;
/*    */
    }

    /*    */
/*    */   public static class Listener {
        /* 22 */
        public Listener() {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public void onCalling(SipSession session) {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public void onRinging(SipSession session, SipProfile caller, String sessionDescription) {
            throw new RuntimeException("Stub!");
        }

        /* 25 */
        public void onRingingBack(SipSession session) {
            throw new RuntimeException("Stub!");
        }

        /* 26 */
        public void onCallEstablished(SipSession session, String sessionDescription) {
            throw new RuntimeException("Stub!");
        }

        /* 27 */
        public void onCallEnded(SipSession session) {
            throw new RuntimeException("Stub!");
        }

        /* 28 */
        public void onCallBusy(SipSession session) {
            throw new RuntimeException("Stub!");
        }

        /* 29 */
        public void onError(SipSession session, int errorCode, String errorMessage) {
            throw new RuntimeException("Stub!");
        }

        /* 30 */
        public void onCallChangeFailed(SipSession session, int errorCode, String errorMessage) {
            throw new RuntimeException("Stub!");
        }

        /* 31 */
        public void onRegistering(SipSession session) {
            throw new RuntimeException("Stub!");
        }

        /* 32 */
        public void onRegistrationDone(SipSession session, int duration) {
            throw new RuntimeException("Stub!");
        }

        /* 33 */
        public void onRegistrationFailed(SipSession session, int errorCode, String errorMessage) {
            throw new RuntimeException("Stub!");
        }

        /* 34 */
        public void onRegistrationTimeout(SipSession session) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 36 */   SipSession() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public String getLocalIp() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public SipProfile getLocalProfile() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public SipProfile getPeerProfile() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public int getState() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean isInCall() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public String getCallId() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void setListener(Listener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void register(int duration) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void unregister() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void makeCall(SipProfile callee, String sessionDescription, int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void answerCall(String sessionDescription, int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void endCall() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void changeCall(String sessionDescription, int timeout) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/sip/SipSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */