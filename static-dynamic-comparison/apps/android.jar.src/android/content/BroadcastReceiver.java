/*    */
package android.content;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*    */ public abstract class BroadcastReceiver {
    /*  6 */   public static class PendingResult {
        PendingResult() {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public final void setResultCode(int code) {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public final int getResultCode() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public final void setResultData(String data) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public final String getResultData() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public final void setResultExtras(Bundle extras) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public final Bundle getResultExtras(boolean makeMap) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public final void setResult(int code, String data, Bundle extras) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public final boolean getAbortBroadcast() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public final void abortBroadcast() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public final void clearAbortBroadcast() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public final void finish() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 19 */
    public BroadcastReceiver() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void onReceive(Context paramContext, Intent paramIntent);

    /* 21 */
    public final PendingResult goAsync() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public android.os.IBinder peekService(Context myContext, Intent service) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final void setResultCode(int code) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final int getResultCode() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final void setResultData(String data) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public final String getResultData() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public final void setResultExtras(Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public final Bundle getResultExtras(boolean makeMap) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public final void setResult(int code, String data, Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public final boolean getAbortBroadcast() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public final void abortBroadcast() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public final void clearAbortBroadcast() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public final boolean isOrderedBroadcast() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public final boolean isInitialStickyBroadcast() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public final void setOrderedHint(boolean isOrdered) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public final void setDebugUnregister(boolean debug) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public final boolean getDebugUnregister() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/BroadcastReceiver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */