/*    */
package android.content;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class SyncResult implements android.os.Parcelable {
    public SyncResult() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public boolean hasHardError() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean hasSoftError() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean hasError() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean madeSomeProgress() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void clear() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String toDebugString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public static final android.os.Parcelable.Creator<SyncResult> CREATOR = null;
    public static final SyncResult ALREADY_IN_PROGRESS = null;
    /*    */   public final SyncStats stats;
    /*    */   public long delayUntil;
    /*    */   public boolean moreRecordsToGet;
    /*    */   public boolean partialSyncUnavailable;
    /*    */   public boolean fullSyncRequested;
    /*    */   public boolean databaseError;
    /*    */   public boolean tooManyRetries;
    /*    */   public boolean tooManyDeletions;
    /*    */   public final boolean syncAlreadyInProgress;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/SyncResult.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */