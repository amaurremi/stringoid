/*   */
package android.telephony;
/*   */

import android.app.PendingIntent;

/*   */
/* 4 */ public final class SmsManager {
    SmsManager() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void sendTextMessage(String destinationAddress, String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public java.util.ArrayList<String> divideMessage(String text) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void sendMultipartTextMessage(String destinationAddress, String scAddress, java.util.ArrayList<String> parts, java.util.ArrayList<PendingIntent> sentIntents, java.util.ArrayList<PendingIntent> deliveryIntents) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void sendDataMessage(String destinationAddress, String scAddress, short destinationPort, byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public static SmsManager getDefault() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int STATUS_ON_ICC_FREE = 0;
    /*   */   public static final int STATUS_ON_ICC_READ = 1;
    /*   */   public static final int STATUS_ON_ICC_UNREAD = 3;
    /*   */   public static final int STATUS_ON_ICC_SENT = 5;
    /*   */   public static final int STATUS_ON_ICC_UNSENT = 7;
    /*   */   public static final int RESULT_ERROR_GENERIC_FAILURE = 1;
    /*   */   public static final int RESULT_ERROR_RADIO_OFF = 2;
    /*   */   public static final int RESULT_ERROR_NULL_PDU = 3;
    /*   */   public static final int RESULT_ERROR_NO_SERVICE = 4;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/telephony/SmsManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */