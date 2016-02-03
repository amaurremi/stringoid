/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.os.IBinder;

/*    */
/*  5 */ public final class InputBinding implements android.os.Parcelable {
    public InputBinding(InputConnection conn, IBinder connToken, int uid, int pid) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public InputBinding(InputConnection conn, InputBinding binding) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public InputConnection getConnection() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public IBinder getConnectionToken() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getUid() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getPid() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 15 */   public static final android.os.Parcelable.Creator<InputBinding> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/InputBinding.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */