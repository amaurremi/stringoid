/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ 
/*    */ public abstract class ContentProvider
/*    */ implements ComponentCallbacks2
/*    */ {
    /*  9 */
    public ContentProvider() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected final void setReadPermission(String permission) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public final String getReadPermission() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected final void setWritePermission(String permission) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final String getWritePermission() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected final void setPathPermissions(android.content.pm.PathPermission[] permissions) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public final android.content.pm.PathPermission[] getPathPermissions() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract boolean onCreate();

    /* 18 */
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void onLowMemory() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void onTrimMemory(int level) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract android.database.Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);

    /* 22 */
    public android.database.Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, android.os.CancellationSignal cancellationSignal) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract String getType(Uri paramUri);

    /*    */
    public abstract Uri insert(Uri paramUri, ContentValues paramContentValues);

    /* 25 */
    public int bulkInsert(Uri uri, ContentValues[] values) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract int delete(Uri paramUri, String paramString, String[] paramArrayOfString);

    /*    */
    public abstract int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);

    /* 28 */
    public android.os.ParcelFileDescriptor openFile(Uri uri, String mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public android.content.res.AssetFileDescriptor openAssetFile(Uri uri, String mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    protected final android.os.ParcelFileDescriptor openFileHelper(Uri uri, String mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public android.content.res.AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, android.os.Bundle opts) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public <T> android.os.ParcelFileDescriptor openPipeHelper(Uri uri, String mimeType, android.os.Bundle opts, T args, PipeDataWriter<T> func) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    protected boolean isTemporary() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void attachInfo(Context context, android.content.pm.ProviderInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public ContentProviderResult[] applyBatch(java.util.ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public android.os.Bundle call(String method, String arg, android.os.Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface PipeDataWriter<T>
/*    */ {
        /*    */
        public abstract void writeDataToPipe(android.os.ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri, String paramString, android.os.Bundle paramBundle, T paramT);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ContentProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */