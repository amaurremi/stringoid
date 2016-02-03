/*    */
package android.telephony.gsm;

/*    */
/*    */
@Deprecated
/*    */ public class SmsMessage {
    @Deprecated
/*    */ public static final int ENCODING_UNKNOWN = 0;

    /*    */
/*    */
    @Deprecated
/*  8 */ public static enum MessageClass {
        CLASS_0,
        /*  9 */     CLASS_1,
        /* 10 */     CLASS_2,
        /* 11 */     CLASS_3,
        /* 12 */     UNKNOWN;

        /*    */
/*    */
        private MessageClass() {
        }
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static class SubmitPdu {
        @Deprecated
/* 18 */ public SubmitPdu() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 20 */ public String toString() {
            throw new RuntimeException("Stub!");
        }

        @Deprecated
/* 21 */ public byte[] encodedScAddress = null;
        /*    */
        @Deprecated
/* 23 */ public byte[] encodedMessage = null;
/*    */
    }

    /*    */
/*    */
    @Deprecated
/* 27 */ public SmsMessage() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public static SmsMessage createFromPdu(byte[] pdu) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 31 */ public static int getTPLayerLengthForPDU(String pdu) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public static int[] calculateLength(CharSequence messageBody, boolean use7bitOnly) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 35 */ public static int[] calculateLength(String messageBody, boolean use7bitOnly) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 37 */ public static SubmitPdu getSubmitPdu(String scAddress, String destinationAddress, String message, boolean statusReportRequested) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 39 */ public static SubmitPdu getSubmitPdu(String scAddress, String destinationAddress, short destinationPort, byte[] data, boolean statusReportRequested) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 41 */ public String getServiceCenterAddress() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 43 */ public String getOriginatingAddress() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 45 */ public String getDisplayOriginatingAddress() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 47 */ public String getMessageBody() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 49 */ public MessageClass getMessageClass() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 51 */ public String getDisplayMessageBody() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 53 */ public String getPseudoSubject() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 55 */ public long getTimestampMillis() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 57 */ public boolean isEmail() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 59 */ public String getEmailBody() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 61 */ public String getEmailFrom() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 63 */ public int getProtocolIdentifier() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 65 */ public boolean isReplace() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 67 */ public boolean isCphsMwiMessage() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 69 */ public boolean isMWIClearMessage() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 71 */ public boolean isMWISetMessage() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 73 */ public boolean isMwiDontStore() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 75 */ public byte[] getUserData() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 77 */ public byte[] getPdu() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 79 */ public int getStatusOnSim() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 81 */ public int getIndexOnSim() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 83 */ public int getStatus() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 85 */ public boolean isStatusReportMessage() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 87 */ public boolean isReplyPathPresent() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static final int ENCODING_7BIT = 1;
    /*    */
    @Deprecated
/*    */ public static final int ENCODING_8BIT = 2;
    /*    */
    @Deprecated
/*    */ public static final int ENCODING_16BIT = 3;
    /*    */
    @Deprecated
/*    */ public static final int MAX_USER_DATA_BYTES = 140;
    /*    */
    @Deprecated
/*    */ public static final int MAX_USER_DATA_SEPTETS = 160;
    /*    */
    @Deprecated
/*    */ public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/telephony/gsm/SmsMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */