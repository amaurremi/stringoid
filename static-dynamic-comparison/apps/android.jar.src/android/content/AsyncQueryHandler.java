/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ public abstract class AsyncQueryHandler extends android.os.Handler {
    protected static final class WorkerArgs {
        public Uri uri;

        /*    */
/*  7 */
        protected WorkerArgs() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public android.os.Handler handler;
        /* 10 */     public String[] projection = null;
        /*    */     public String selection;
        /* 12 */     public String[] selectionArgs = null;
        /*    */     public String orderBy;
        /*    */     public Object result;
        /*    */     public Object cookie;
        /*    */     public ContentValues values;
/*    */
    }

    /*    */
/*    */   protected class WorkerHandler
/*    */ extends android.os.Handler {
        /* 21 */
        public WorkerHandler(android.os.Looper looper) {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public void handleMessage(android.os.Message msg) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 24 */
    public AsyncQueryHandler(ContentResolver cr) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected android.os.Handler createHandler(android.os.Looper looper) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void startQuery(int token, Object cookie, Uri uri, String[] projection, String selection, String[] selectionArgs, String orderBy) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public final void cancelOperation(int token) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public final void startInsert(int token, Object cookie, Uri uri, ContentValues initialValues) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public final void startUpdate(int token, Object cookie, Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public final void startDelete(int token, Object cookie, Uri uri, String selection, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    protected void onQueryComplete(int token, Object cookie, android.database.Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected void onInsertComplete(int token, Object cookie, Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    protected void onUpdateComplete(int token, Object cookie, int result) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    protected void onDeleteComplete(int token, Object cookie, int result) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void handleMessage(android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/AsyncQueryHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */