/*    */
package android.content;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*  5 */ public class PeriodicSync implements android.os.Parcelable {
    public PeriodicSync(android.accounts.Account account, String authority, Bundle extras, long period) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public final android.accounts.Account account;
    /*    */   public final String authority;
    /*    */   public final Bundle extras;
    /*    */   public final long period;
    /* 14 */   public static final android.os.Parcelable.Creator<PeriodicSync> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/PeriodicSync.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */