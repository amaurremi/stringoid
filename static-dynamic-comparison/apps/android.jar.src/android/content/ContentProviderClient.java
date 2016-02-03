/*    */
package android.content;
/*    */

import android.net.Uri;

/*    */
/*  4 */ public class ContentProviderClient {
    ContentProviderClient() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public android.database.Cursor query(Uri url, String[] projection, String selection, String[] selectionArgs, String sortOrder) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public android.database.Cursor query(Uri url, String[] projection, String selection, String[] selectionArgs, String sortOrder, android.os.CancellationSignal cancellationSignal) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getType(Uri url) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Uri insert(Uri url, ContentValues initialValues) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int delete(Uri url, String selection, String[] selectionArgs) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int update(Uri url, ContentValues values, String selection, String[] selectionArgs) throws android.os.RemoteException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public android.os.ParcelFileDescriptor openFile(Uri url, String mode) throws android.os.RemoteException, java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.content.res.AssetFileDescriptor openAssetFile(Uri url, String mode) throws android.os.RemoteException, java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri, String mimeType, android.os.Bundle opts) throws android.os.RemoteException, java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public ContentProviderResult[] applyBatch(java.util.ArrayList<ContentProviderOperation> operations) throws android.os.RemoteException, OperationApplicationException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean release() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public ContentProvider getLocalContentProvider() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ContentProviderClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */