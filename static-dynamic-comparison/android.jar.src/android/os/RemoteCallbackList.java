/*    */
package android.os;

/*    */
/*    */ public class RemoteCallbackList<E extends IInterface> {
    /*  4 */
    public RemoteCallbackList() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public boolean register(E callback) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public boolean register(E callback, Object cookie) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean unregister(E callback) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void kill() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void onCallbackDied(E callback) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onCallbackDied(E callback, Object cookie) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int beginBroadcast() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public E getBroadcastItem(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Object getBroadcastCookie(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void finishBroadcast() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/RemoteCallbackList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */