/*    */
package android.net;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class NetworkInfo implements android.os.Parcelable {
    /*    */   public static enum State {
        /*  7 */     CONNECTED,
        /*  8 */     CONNECTING,
        /*  9 */     DISCONNECTED,
        /* 10 */     DISCONNECTING,
        /* 11 */     SUSPENDED,
        /* 12 */     UNKNOWN;

        /*    */
/*    */
        private State() {
        }
    }

    /*    */
/* 16 */   public static enum DetailedState {
        AUTHENTICATING,
        /* 17 */     BLOCKED,
        /* 18 */     CONNECTED,
        /* 19 */     CONNECTING,
        /* 20 */     DISCONNECTED,
        /* 21 */     DISCONNECTING,
        /* 22 */     FAILED,
        /* 23 */     IDLE,
        /* 24 */     OBTAINING_IPADDR,
        /* 25 */     SCANNING,
        /* 26 */     SUSPENDED,
        /* 27 */     VERIFYING_POOR_LINK;

        /*    */
        private DetailedState() {
        }
    }

    /* 29 */   NetworkInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getType() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public int getSubtype() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public String getTypeName() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public String getSubtypeName() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public boolean isConnectedOrConnecting() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean isConnected() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean isAvailable() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean isFailover() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean isRoaming() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public State getState() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public DetailedState getDetailedState() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public String getReason() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public String getExtraInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/NetworkInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */