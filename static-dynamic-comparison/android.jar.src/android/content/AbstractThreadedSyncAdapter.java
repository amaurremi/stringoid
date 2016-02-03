/*    */
package android.content;
/*    */

import android.os.Bundle;

/*    */
/*  4 */ public abstract class AbstractThreadedSyncAdapter {
    public AbstractThreadedSyncAdapter(Context context, boolean autoInitialize) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public AbstractThreadedSyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public final android.os.IBinder getSyncAdapterBinder() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void onPerformSync(android.accounts.Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult);

    /*  9 */
    public void onSyncCanceled() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onSyncCanceled(Thread thread) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static final int LOG_SYNC_DETAILS = 2743;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/AbstractThreadedSyncAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */