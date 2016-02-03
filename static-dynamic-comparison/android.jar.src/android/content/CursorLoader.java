/*    */
package android.content;
/*    */ 
/*    */

import android.database.Cursor;

/*    */
/*  5 */ public class CursorLoader extends AsyncTaskLoader<Cursor> {
    public CursorLoader(Context context) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public CursorLoader(Context context, android.net.Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public Cursor loadInBackground() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void cancelLoadInBackground() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void deliverResult(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected void onStartLoading() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void onStopLoading() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onCanceled(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected void onReset() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.net.Uri getUri() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setUri(android.net.Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String[] getProjection() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setProjection(String[] projection) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public String getSelection() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setSelection(String selection) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public String[] getSelectionArgs() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setSelectionArgs(String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public String getSortOrder() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setSortOrder(String sortOrder) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void dump(String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/CursorLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */