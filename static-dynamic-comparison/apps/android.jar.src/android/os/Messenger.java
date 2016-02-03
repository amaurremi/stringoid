/*    */
package android.os;

/*    */
/*    */ public final class Messenger
/*    */ implements Parcelable {
    /*  5 */
    public Messenger(Handler target) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Messenger(IBinder target) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void send(Message message) throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public IBinder getBinder() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean equals(Object otherObj) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static void writeMessengerOrNullToParcel(Messenger messenger, Parcel out) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static Messenger readMessengerOrNullFromParcel(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 16 */   public static final Parcelable.Creator<Messenger> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Messenger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */