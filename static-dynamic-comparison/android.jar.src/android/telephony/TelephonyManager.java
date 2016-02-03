/*    */
package android.telephony;
/*    */

import java.util.List;

/*    */
/*  4 */ public class TelephonyManager {
    TelephonyManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public String getDeviceSoftwareVersion() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getDeviceId() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public CellLocation getCellLocation() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getPhoneType() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String getNetworkOperatorName() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String getNetworkOperator() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean isNetworkRoaming() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String getNetworkCountryIso() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getNetworkType() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean hasIccCard() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getSimState() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public String getSimOperator() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public String getSimOperatorName() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public String getSimCountryIso() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public String getSimSerialNumber() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public String getSubscriberId() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public String getLine1Number() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public String getVoiceMailNumber() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public String getVoiceMailAlphaTag() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getCallState() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getDataActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int getDataState() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void listen(PhoneStateListener listener, int events) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public static final int DATA_SUSPENDED = 3;
    /*    */
/*    */   public static final int DATA_CONNECTED = 2;
    /*    */
/*    */   public static final int DATA_CONNECTING = 1;
    /*    */
/*    */   public static final int DATA_DISCONNECTED = 0;
    /*    */   public static final int DATA_ACTIVITY_DORMANT = 4;
    /*    */   public static final int DATA_ACTIVITY_INOUT = 3;
    /*    */   public static final int DATA_ACTIVITY_OUT = 2;
    /*    */   public static final int DATA_ACTIVITY_IN = 1;
    /*    */   public static final int DATA_ACTIVITY_NONE = 0;
    /*    */   public static final int CALL_STATE_OFFHOOK = 2;
    /*    */   public static final int CALL_STATE_RINGING = 1;
    /*    */   public static final int CALL_STATE_IDLE = 0;
    /*    */   public static final int SIM_STATE_READY = 5;
    /*    */   public static final int SIM_STATE_NETWORK_LOCKED = 4;
    /*    */   public static final int SIM_STATE_PUK_REQUIRED = 3;
    /*    */   public static final int SIM_STATE_PIN_REQUIRED = 2;
    /*    */   public static final int SIM_STATE_ABSENT = 1;
    /*    */   public static final int SIM_STATE_UNKNOWN = 0;
    /*    */   public static final int NETWORK_TYPE_HSPAP = 15;
    /*    */   public static final int NETWORK_TYPE_EHRPD = 14;
    /*    */   public static final int NETWORK_TYPE_LTE = 13;
    /*    */   public static final int NETWORK_TYPE_EVDO_B = 12;
    /*    */   public static final int NETWORK_TYPE_IDEN = 11;
    /*    */   public static final int NETWORK_TYPE_HSPA = 10;
    /*    */   public static final int NETWORK_TYPE_HSUPA = 9;
    /*    */   public static final int NETWORK_TYPE_HSDPA = 8;
    /*    */   public static final int NETWORK_TYPE_1xRTT = 7;
    /*    */   public static final int NETWORK_TYPE_EVDO_A = 6;
    /*    */   public static final int NETWORK_TYPE_EVDO_0 = 5;
    /*    */   public static final int NETWORK_TYPE_CDMA = 4;
    /*    */   public static final int NETWORK_TYPE_UMTS = 3;
    /*    */   public static final int NETWORK_TYPE_EDGE = 2;
    /*    */   public static final int NETWORK_TYPE_GPRS = 1;
    /*    */   public static final int NETWORK_TYPE_UNKNOWN = 0;
    /*    */   public static final int PHONE_TYPE_SIP = 3;
    /*    */   public static final int PHONE_TYPE_CDMA = 2;
    /*    */   public static final int PHONE_TYPE_GSM = 1;
    /*    */   public static final int PHONE_TYPE_NONE = 0;
    /*    */   public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    /* 73 */   public static final String EXTRA_STATE_OFFHOOK = null;
    public static final String EXTRA_STATE_RINGING = null;
    public static final String EXTRA_STATE_IDLE = null;
    /*    */   public static final String EXTRA_STATE = "state";
    /*    */   public static final String ACTION_PHONE_STATE_CHANGED = "android.intent.action.PHONE_STATE";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/telephony/TelephonyManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */