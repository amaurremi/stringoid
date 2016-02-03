/*    */
package android.database.sqlite;
/*    */ 
/*    */

import java.io.Closeable;

/*    */
/*  5 */ public abstract class SQLiteClosable implements Closeable {
    public SQLiteClosable() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    protected abstract void onAllReferencesReleased();

    /*    */
    @Deprecated
/*  8 */ protected void onAllReferencesReleasedFromContainer() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void acquireReference() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void releaseReference() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 12 */ public void releaseReferenceFromContainer() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void close() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/sqlite/SQLiteClosable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */