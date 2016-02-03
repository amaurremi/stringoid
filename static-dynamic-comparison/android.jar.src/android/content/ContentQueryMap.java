/*    */
package android.content;
/*    */ 
/*    */

import android.os.Handler;

/*    */
/*  5 */ public class ContentQueryMap extends java.util.Observable {
    public ContentQueryMap(android.database.Cursor cursor, String columnNameOfKey, boolean keepUpdated, Handler handlerForUpdateNotifications) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setKeepUpdated(boolean keepUpdated) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public synchronized ContentValues getValues(String rowName) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void requery() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public synchronized java.util.Map<String, ContentValues> getRows() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public synchronized void close() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ContentQueryMap.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */