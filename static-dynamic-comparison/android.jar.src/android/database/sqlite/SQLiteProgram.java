/*    */
package android.database.sqlite;

/*    */
/*    */ public abstract class SQLiteProgram
/*    */ extends SQLiteClosable {
    /*  5 */   SQLiteProgram() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  7 */ public final int getUniqueId() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void bindNull(int index) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void bindLong(int index, long value) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void bindDouble(int index, double value) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void bindString(int index, String value) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void bindBlob(int index, byte[] value) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void clearBindings() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void bindAllArgsAsStrings(String[] bindArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected void onAllReferencesReleased() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/sqlite/SQLiteProgram.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */