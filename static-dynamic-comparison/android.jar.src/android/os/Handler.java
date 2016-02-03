/*    */
package android.os;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*    */ 
/*    */ public class Handler
/*    */ {
    /*  8 */
    public Handler() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Handler(Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Handler(Looper looper) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public Handler(Looper looper, Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void handleMessage(Message msg) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void dispatchMessage(Message msg) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String getMessageName(Message message) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final Message obtainMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public final Message obtainMessage(int what) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public final Message obtainMessage(int what, Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public final Message obtainMessage(int what, int arg1, int arg2) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public final boolean post(Runnable r) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final boolean postDelayed(Runnable r, long delayMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final boolean postAtFrontOfQueue(Runnable r) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final void removeCallbacks(Runnable r) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public final void removeCallbacks(Runnable r, Object token) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public final boolean sendMessage(Message msg) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public final boolean sendEmptyMessage(int what) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public final boolean sendMessageAtFrontOfQueue(Message msg) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public final void removeMessages(int what) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public final void removeMessages(int what, Object object) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public final void removeCallbacksAndMessages(Object token) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public final boolean hasMessages(int what) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public final boolean hasMessages(int what, Object object) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public final Looper getLooper() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public final void dump(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface Callback
/*    */ {
        /*    */
        public abstract boolean handleMessage(Message paramMessage);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Handler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */