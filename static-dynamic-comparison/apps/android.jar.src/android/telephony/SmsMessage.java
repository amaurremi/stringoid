/*    */
package android.telephony;

/*    */
/*    */ public class SmsMessage {
    public static final int ENCODING_UNKNOWN = 0;
    /*    */   public static final int ENCODING_7BIT = 1;

    /*    */
/*  6 */   public static enum MessageClass {
        CLASS_0,
        /*  7 */     CLASS_1,
        /*  8 */     CLASS_2,
        /*  9 */     CLASS_3,
        /* 10 */     UNKNOWN;

        /*    */
/*    */
        private MessageClass() {
        }
    }

    /*    */
/* 14 */   public static class SubmitPdu {
        SubmitPdu() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */     public byte[] encodedScAddress = null;
        /* 17 */     public byte[] encodedMessage = null;
    }

    /*    */
/* 19 */   SmsMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static SmsMessage createFromPdu(byte[] pdu) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static int getTPLayerLengthForPDU(String pdu) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static int[] calculateLength(CharSequence msgBody, boolean use7bitOnly) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static int[] calculateLength(String messageBody, boolean use7bitOnly) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public static SubmitPdu getSubmitPdu(String scAddress, String destinationAddress, String message, boolean statusReportRequested) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static SubmitPdu getSubmitPdu(String scAddress, String destinationAddress, short destinationPort, byte[] data, boolean statusReportRequested) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public String getServiceCenterAddress() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public String getOriginatingAddress() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public String getDisplayOriginatingAddress() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public String getMessageBody() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public MessageClass getMessageClass() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public String getDisplayMessageBody() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public String getPseudoSubject() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public long getTimestampMillis() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public boolean isEmail() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public String getEmailBody() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public String getEmailFrom() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public int getProtocolIdentifier() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean isReplace() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean isCphsMwiMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public boolean isMWIClearMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean isMWISetMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean isMwiDontStore() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public byte[] getUserData() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public byte[] getPdu() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 46 */ public int getStatusOnSim() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public int getStatusOnIcc() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 49 */ public int getIndexOnSim() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public int getIndexOnIcc() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public int getStatus() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public boolean isStatusReportMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public boolean isReplyPathPresent() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ENCODING_8BIT = 2;
    /*    */   public static final int ENCODING_16BIT = 3;
    /*    */   public static final int MAX_USER_DATA_BYTES = 140;
    /*    */   public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    /*    */   public static final int MAX_USER_DATA_SEPTETS = 160;
    /*    */   public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/telephony/SmsMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */