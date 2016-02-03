/*    */
package android.os;

/*    */
/*    */ public final class Message implements Parcelable {
    public int what;

    /*    */
/*  5 */
    public Message() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static Message obtain() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static Message obtain(Message orig) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static Message obtain(Handler h) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static Message obtain(Handler h, Runnable callback) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static Message obtain(Handler h, int what) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static Message obtain(Handler h, int what, Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static Message obtain(Handler h, int what, int arg1, int arg2) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static Message obtain(Handler h, int what, int arg1, int arg2, Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void recycle() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void copyFrom(Message o) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public long getWhen() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setTarget(Handler target) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public Handler getTarget() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public Runnable getCallback() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public Bundle getData() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public Bundle peekData() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setData(Bundle data) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void sendToTarget() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public int arg1;
    /*    */   public int arg2;
    /*    */   public Object obj;
    /*    */   public Messenger replyTo;
    /* 33 */   public static final Parcelable.Creator<Message> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Message.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */