/*   */
package android.database.sqlite;
/*   */ 
/*   */

import android.database.SQLException;

/*   */
/* 5 */ public class SQLiteException extends SQLException {
    public SQLiteException() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public SQLiteException(String error) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public SQLiteException(String error, Throwable cause) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/sqlite/SQLiteException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */