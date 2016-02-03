/*    */
package android.content;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class SyncStats implements android.os.Parcelable {
    public SyncStats() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public SyncStats(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void clear() {
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
/*    */   public long numAuthExceptions;
    /*    */   public long numIoExceptions;
    /*    */   public long numParseExceptions;
    /*    */   public long numConflictDetectedExceptions;
    /*    */   public long numInserts;
    /*    */   public long numUpdates;
    /*    */   public long numDeletes;
    /*    */   public long numEntries;
    /*    */   public long numSkippedEntries;
    /* 21 */   public static final android.os.Parcelable.Creator<SyncStats> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/SyncStats.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */