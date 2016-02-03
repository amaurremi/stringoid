/*    */
package android.net.sip;
/*    */

import android.content.Intent;

/*    */
/*  4 */ public class SipManager {
    SipManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static SipManager newInstance(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static boolean isApiSupported(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static boolean isVoipSupported(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static boolean isSipWifiOnly(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void open(SipProfile localProfile) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void open(SipProfile localProfile, android.app.PendingIntent incomingCallPendingIntent, SipRegistrationListener listener) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setRegistrationListener(String localProfileUri, SipRegistrationListener listener) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void close(String localProfileUri) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isOpened(String localProfileUri) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean isRegistered(String localProfileUri) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public SipAudioCall makeAudioCall(SipProfile localProfile, SipProfile peerProfile, SipAudioCall.Listener listener, int timeout) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public SipAudioCall makeAudioCall(String localProfileUri, String peerProfileUri, SipAudioCall.Listener listener, int timeout) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public SipAudioCall takeAudioCall(Intent incomingCallIntent, SipAudioCall.Listener listener) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static boolean isIncomingCallIntent(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static String getCallId(Intent incomingCallIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static String getOfferSessionDescription(Intent incomingCallIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void register(SipProfile localProfile, int expiryTime, SipRegistrationListener listener) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void unregister(SipProfile localProfile, SipRegistrationListener listener) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public SipSession getSessionFor(Intent incomingCallIntent) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public SipSession createSipSession(SipProfile localProfile, SipSession.Listener listener) throws SipException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int INCOMING_CALL_RESULT_CODE = 101;
    /*    */   public static final String EXTRA_CALL_ID = "android:sipCallID";
    /*    */   public static final String EXTRA_OFFER_SD = "android:sipOfferSD";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/sip/SipManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */