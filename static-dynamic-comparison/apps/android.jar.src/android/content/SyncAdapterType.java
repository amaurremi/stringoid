/*    */
package android.content;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class SyncAdapterType implements android.os.Parcelable {
    public SyncAdapterType(String authority, String accountType, boolean userVisible, boolean supportsUploading) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public SyncAdapterType(Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean supportsUploading() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean isUserVisible() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean allowParallelSyncs() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isAlwaysSyncable() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String getSettingsActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static SyncAdapterType newKey(String authority, String accountType) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public final String authority;
    /*    */   public final String accountType;
    /*    */   public final boolean isKey;
    /* 22 */   public static final android.os.Parcelable.Creator<SyncAdapterType> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/SyncAdapterType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */