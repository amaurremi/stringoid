/*   */
package android.content;
/*   */ 
/*   */

import android.os.Parcel;

/*   */
/* 5 */ public class SyncInfo implements android.os.Parcelable {
    SyncInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public final android.accounts.Account account;
    /*   */   public final String authority;
    /*   */   public final long startTime;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/SyncInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */