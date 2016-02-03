/*    */
package android.nfc;
/*    */ 
/*    */

import android.app.Activity;

/*    */
/*    */ 
/*    */ 
/*    */ public final class NfcAdapter
/*    */ {
    /*    */   public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    /*    */   public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
    /*    */   public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
    /*    */   public static final String EXTRA_TAG = "android.nfc.extra.TAG";
    /*    */   public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
    /*    */   public static final String EXTRA_ID = "android.nfc.extra.ID";

    /*    */
/* 16 */   NfcAdapter() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static NfcAdapter getDefaultAdapter(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setBeamPushUris(android.net.Uri[] uris, Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setBeamPushUrisCallback(CreateBeamUrisCallback callback, Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setNdefPushMessage(NdefMessage message, Activity activity, Activity... activities) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setNdefPushMessageCallback(CreateNdefMessageCallback callback, Activity activity, Activity... activities) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback callback, Activity activity, Activity... activities) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void enableForegroundDispatch(Activity activity, android.app.PendingIntent intent, android.content.IntentFilter[] filters, String[][] techLists) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void disableForegroundDispatch(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 27 */ public void enableForegroundNdefPush(Activity activity, NdefMessage message) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public void disableForegroundNdefPush(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean isNdefPushEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface CreateBeamUrisCallback
/*    */ {
        /*    */
        public abstract android.net.Uri[] createBeamUris(NfcEvent paramNfcEvent);
/*    */
    }

    /*    */
/*    */   public static abstract interface CreateNdefMessageCallback
/*    */ {
        /*    */
        public abstract NdefMessage createNdefMessage(NfcEvent paramNfcEvent);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnNdefPushCompleteCallback
/*    */ {
        /*    */
        public abstract void onNdefPushComplete(NfcEvent paramNfcEvent);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/NfcAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */