/*    */
package android.content;
/*    */

import android.net.Uri;

/*    */
/*  4 */ public abstract class ContentResolver {
    public ContentResolver(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public final String getType(Uri url) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public final android.database.Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public final android.database.Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, android.os.CancellationSignal cancellationSignal) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public final java.io.InputStream openInputStream(Uri uri) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final java.io.OutputStream openOutputStream(Uri uri) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final java.io.OutputStream openOutputStream(Uri uri, String mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public final android.os.ParcelFileDescriptor openFileDescriptor(Uri uri, String mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public final android.content.res.AssetFileDescriptor openAssetFileDescriptor(Uri uri, String mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri, String mimeType, android.os.Bundle opts) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final Uri insert(Uri url, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public ContentProviderResult[] applyBatch(String authority, java.util.ArrayList<ContentProviderOperation> operations) throws android.os.RemoteException, OperationApplicationException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public final int bulkInsert(Uri url, ContentValues[] values) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public final int delete(Uri url, String where, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public final int update(Uri uri, ContentValues values, String where, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public final android.os.Bundle call(Uri uri, String method, String arg, android.os.Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public final ContentProviderClient acquireContentProviderClient(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final ContentProviderClient acquireUnstableContentProviderClient(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final ContentProviderClient acquireUnstableContentProviderClient(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final void registerContentObserver(Uri uri, boolean notifyForDescendents, android.database.ContentObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public final void unregisterContentObserver(android.database.ContentObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void notifyChange(Uri uri, android.database.ContentObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void notifyChange(Uri uri, android.database.ContentObserver observer, boolean syncToNetwork) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 30 */ public void startSync(Uri uri, android.os.Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static void requestSync(android.accounts.Account account, String authority, android.os.Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static void validateSyncExtrasBundle(android.os.Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 34 */ public void cancelSync(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public static void cancelSync(android.accounts.Account account, String authority) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public static SyncAdapterType[] getSyncAdapterTypes() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public static boolean getSyncAutomatically(android.accounts.Account account, String authority) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public static void setSyncAutomatically(android.accounts.Account account, String authority, boolean sync) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public static void addPeriodicSync(android.accounts.Account account, String authority, android.os.Bundle extras, long pollFrequency) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public static void removePeriodicSync(android.accounts.Account account, String authority, android.os.Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public static java.util.List<PeriodicSync> getPeriodicSyncs(android.accounts.Account account, String authority) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public static int getIsSyncable(android.accounts.Account account, String authority) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public static void setIsSyncable(android.accounts.Account account, String authority, int syncable) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public static boolean getMasterSyncAutomatically() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public static void setMasterSyncAutomatically(boolean sync) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public static boolean isSyncActive(android.accounts.Account account, String authority) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 48 */ public static SyncInfo getCurrentSync() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public static java.util.List<SyncInfo> getCurrentSyncs() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public static boolean isSyncPending(android.accounts.Account account, String authority) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public static Object addStatusChangeListener(int mask, SyncStatusObserver callback) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public static void removeStatusChangeListener(Object handle) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static final String SYNC_EXTRAS_ACCOUNT = "account";
    /*    */   public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    /*    */
    @Deprecated
/*    */ public static final String SYNC_EXTRAS_FORCE = "force";
    /*    */   public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    /*    */   public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    /*    */   public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    /*    */   public static final String SYNC_EXTRAS_MANUAL = "force";
    /*    */   public static final String SYNC_EXTRAS_UPLOAD = "upload";
    /*    */   public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    /*    */   public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    /*    */   public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    /*    */   public static final String SCHEME_CONTENT = "content";
    /*    */   public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    /*    */   public static final String SCHEME_FILE = "file";
    /*    */   public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    /*    */   public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    /*    */   public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1;
    /*    */   public static final int SYNC_OBSERVER_TYPE_PENDING = 2;
    /*    */   public static final int SYNC_OBSERVER_TYPE_ACTIVE = 4;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ContentResolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */