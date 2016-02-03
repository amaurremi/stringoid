/*   */
package android.database;
/*   */ 
/*   */

import android.database.sqlite.SQLiteDatabase;

/*   */
/* 5 */ public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    public DefaultDatabaseErrorHandler() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void onCorruption(SQLiteDatabase dbObj) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/DefaultDatabaseErrorHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */