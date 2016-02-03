/*    */
package android.os;
/*    */

import java.io.PrintWriter;

/*    */
/*  4 */ public abstract class TokenWatcher {
    public TokenWatcher(Handler h, String tag) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void acquired();

    /*    */
    public abstract void released();

    /*  7 */
    public void acquire(IBinder token, String tag) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void cleanup(IBinder token, boolean unlink) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void release(IBinder token) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isAcquired() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void dump() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void dump(PrintWriter pw) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/TokenWatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */