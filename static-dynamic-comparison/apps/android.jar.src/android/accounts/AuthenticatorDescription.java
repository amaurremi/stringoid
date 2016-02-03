/*    */
package android.accounts;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class AuthenticatorDescription implements android.os.Parcelable {
    public AuthenticatorDescription(String type, String packageName, int labelId, int iconId, int smallIconId, int prefId, boolean customTokens) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public AuthenticatorDescription(String type, String packageName, int labelId, int iconId, int smallIconId, int prefId) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static AuthenticatorDescription newKey(String type) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public final String type;
    /*    */   public final int labelId;
    /*    */   public final int iconId;
    /*    */   public final int smallIconId;
    /*    */   public final int accountPreferencesId;
    /*    */   public final String packageName;
    /*    */   public final boolean customTokens;
    /* 21 */   public static final android.os.Parcelable.Creator<AuthenticatorDescription> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/accounts/AuthenticatorDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */