/*    */
package android.os;

/*    */
/*    */ public class ResultReceiver
/*    */ implements Parcelable {
    /*  5 */
    public ResultReceiver(Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void send(int resultCode, Bundle resultData) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 11 */   public static final Parcelable.Creator<ResultReceiver> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/ResultReceiver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */