/*    */
package android.telephony.gsm;
/*    */

import android.app.PendingIntent;

/*    */
/*    */
@Deprecated
/*  5 */ public final class SmsManager {
    SmsManager() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  7 */ public static final SmsManager getDefault() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  9 */ public final void sendTextMessage(String destinationAddress, String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 11 */ public final java.util.ArrayList<String> divideMessage(String text) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 13 */ public final void sendMultipartTextMessage(String destinationAddress, String scAddress, java.util.ArrayList<String> parts, java.util.ArrayList<PendingIntent> sentIntents, java.util.ArrayList<PendingIntent> deliveryIntents) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 15 */ public final void sendDataMessage(String destinationAddress, String scAddress, short destinationPort, byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static final int STATUS_ON_SIM_FREE = 0;
    /*    */
    @Deprecated
/*    */ public static final int STATUS_ON_SIM_READ = 1;
    /*    */
    @Deprecated
/*    */ public static final int STATUS_ON_SIM_UNREAD = 3;
    /*    */
    @Deprecated
/*    */ public static final int STATUS_ON_SIM_SENT = 5;
    /*    */
    @Deprecated
/*    */ public static final int STATUS_ON_SIM_UNSENT = 7;
    /*    */
    @Deprecated
/*    */ public static final int RESULT_ERROR_GENERIC_FAILURE = 1;
    /*    */
    @Deprecated
/*    */ public static final int RESULT_ERROR_RADIO_OFF = 2;
    /*    */
    @Deprecated
/*    */ public static final int RESULT_ERROR_NULL_PDU = 3;
    /*    */
    @Deprecated
/*    */ public static final int RESULT_ERROR_NO_SERVICE = 4;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/telephony/gsm/SmsManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */