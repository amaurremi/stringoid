/*    */
package android.accounts;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class Account implements android.os.Parcelable {
    public Account(String name, String type) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Account(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int hashCode() {
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

    /* 11 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public final String name;
    /*    */   public final String type;
    /* 15 */   public static final android.os.Parcelable.Creator<Account> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/accounts/Account.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */