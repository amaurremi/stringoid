/*    */
package android.net.wifi;
/*    */ 
/*    */

import java.util.BitSet;

/*    */
/*    */ public class WifiConfiguration implements android.os.Parcelable {
    public int networkId;

    /*    */   public static class KeyMgmt {
        public static final int NONE = 0;
        public static final int WPA_PSK = 1;
        public static final int WPA_EAP = 2;

        /*  7 */     KeyMgmt() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */     public static final int IEEE8021X = 3;
        /*    */
/*    */     public static final String varName = "key_mgmt";
        /* 13 */     public static final String[] strings = null;
    }

    /*    */
/*    */   public static class Protocol {
        public static final int WPA = 0;

        /*    */
/* 17 */     Protocol() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int RSN = 1;
        /*    */     public static final String varName = "proto";
        /* 21 */     public static final String[] strings = null;
    }

    /*    */
/*    */   public static class AuthAlgorithm {
        public static final int OPEN = 0;

        /*    */
/* 25 */     AuthAlgorithm() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int SHARED = 1;
        /*    */     public static final int LEAP = 2;
        /*    */     public static final String varName = "auth_alg";
        /* 30 */     public static final String[] strings = null;
    }

    /*    */
/*    */   public static class PairwiseCipher {
        public static final int NONE = 0;

        /*    */
/* 34 */     PairwiseCipher() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int TKIP = 1;
        /*    */     public static final int CCMP = 2;
        /*    */     public static final String varName = "pairwise";
        /* 39 */     public static final String[] strings = null;
    }

    /*    */
/*    */   public static class GroupCipher {
        public static final int WEP40 = 0;

        /*    */
/* 43 */     GroupCipher() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int WEP104 = 1;
        /*    */     public static final int TKIP = 2;
        /*    */     public static final int CCMP = 3;
        /*    */     public static final String varName = "group";
        /* 49 */     public static final String[] strings = null;
    }

    /*    */
/*    */   public static class Status {
        public static final int CURRENT = 0;

        /*    */
/* 53 */     Status() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int DISABLED = 1;
        /*    */     public static final int ENABLED = 2;
        /* 57 */     public static final String[] strings = null;
    }

    /*    */
/* 59 */
    public WifiConfiguration() {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public int status;
    /*    */   public String SSID;
    /*    */   public String BSSID;
    /*    */   public String preSharedKey;
    /* 68 */   public String[] wepKeys = null;
    /*    */   public int wepTxKeyIndex;
    /*    */   public int priority;
    /*    */   public boolean hiddenSSID;
    /*    */   public BitSet allowedKeyManagement;
    /*    */   public BitSet allowedProtocols;
    /*    */   public BitSet allowedAuthAlgorithms;
    /*    */   public BitSet allowedPairwiseCiphers;
    /*    */   public BitSet allowedGroupCiphers;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/wifi/WifiConfiguration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */