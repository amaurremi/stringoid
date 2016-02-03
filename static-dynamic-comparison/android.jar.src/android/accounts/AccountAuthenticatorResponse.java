/*    */
package android.accounts;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class AccountAuthenticatorResponse implements android.os.Parcelable {
    public AccountAuthenticatorResponse(Parcel parcel) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void onResult(android.os.Bundle result) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void onRequestContinued() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void onError(int errorCode, String errorMessage) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 12 */   public static final android.os.Parcelable.Creator<AccountAuthenticatorResponse> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/accounts/AccountAuthenticatorResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */