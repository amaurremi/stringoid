/*    */
package android.database;
/*    */ 
/*    */

import android.content.ContentValues;

/*    */
/*    */ public class DatabaseUtils {
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;

        /*  6 */
        public InsertHelper(android.database.sqlite.SQLiteDatabase db, String tableName) {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public int getColumnIndex(String key) {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public void bind(int index, double value) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public void bind(int index, float value) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public void bind(int index, long value) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public void bind(int index, int value) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public void bind(int index, boolean value) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public void bindNull(int index) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public void bind(int index, byte[] value) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public void bind(int index, String value) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public long insert(ContentValues values) {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public long execute() {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public void prepareForInsert() {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public void prepareForReplace() {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public long replace(ContentValues values) {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public void close() {
            throw new RuntimeException("Stub!");
        }
/*    */     
/*    */
    }

    /* 24 */
    public DatabaseUtils() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static final void writeExceptionToParcel(android.os.Parcel reply, Exception e) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public static final void readExceptionFromParcel(android.os.Parcel reply) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public static void readExceptionWithFileNotFoundExceptionFromParcel(android.os.Parcel reply) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public static void readExceptionWithOperationApplicationExceptionFromParcel(android.os.Parcel reply) throws android.content.OperationApplicationException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public static void bindObjectToProgram(android.database.sqlite.SQLiteProgram prog, int index, Object value) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public static void appendEscapedSQLString(StringBuilder sb, String sqlString) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static String sqlEscapeString(String value) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static final void appendValueToSql(StringBuilder sql, Object value) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public static String concatenateWhere(String a, String b) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public static String getCollationKey(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public static String getHexCollationKey(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public static void dumpCursor(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public static void dumpCursor(Cursor cursor, java.io.PrintStream stream) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public static String dumpCursorToString(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public static void dumpCurrentRow(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public static void dumpCurrentRow(Cursor cursor, java.io.PrintStream stream) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public static String dumpCurrentRowToString(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public static void cursorStringToContentValues(Cursor cursor, String field, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public static void cursorStringToInsertHelper(Cursor cursor, String field, InsertHelper inserter, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public static void cursorStringToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public static void cursorDoubleToCursorValues(Cursor cursor, String field, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public static void cursorDoubleToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public static void cursorRowToContentValues(Cursor cursor, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public static long queryNumEntries(android.database.sqlite.SQLiteDatabase db, String table) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public static long queryNumEntries(android.database.sqlite.SQLiteDatabase db, String table, String selection) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public static long queryNumEntries(android.database.sqlite.SQLiteDatabase db, String table, String selection, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public static long longForQuery(android.database.sqlite.SQLiteDatabase db, String query, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public static long longForQuery(android.database.sqlite.SQLiteStatement prog, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public static String stringForQuery(android.database.sqlite.SQLiteDatabase db, String query, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public static String stringForQuery(android.database.sqlite.SQLiteStatement prog, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public static android.os.ParcelFileDescriptor blobFileDescriptorForQuery(android.database.sqlite.SQLiteDatabase db, String query, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public static android.os.ParcelFileDescriptor blobFileDescriptorForQuery(android.database.sqlite.SQLiteStatement prog, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues values, String column) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public static void createDbFromSqlStatements(android.content.Context context, String dbName, int dbVersion, String sqlStatements) {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public static int getSqlStatementType(String sql) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public static String[] appendSelectionArgs(String[] originalValues, String[] newValues) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int STATEMENT_SELECT = 1;
    /*    */   public static final int STATEMENT_UPDATE = 2;
    /*    */   public static final int STATEMENT_ATTACH = 3;
    /*    */   public static final int STATEMENT_BEGIN = 4;
    /*    */   public static final int STATEMENT_COMMIT = 5;
    /*    */   public static final int STATEMENT_ABORT = 6;
    /*    */   public static final int STATEMENT_PRAGMA = 7;
    /*    */   public static final int STATEMENT_DDL = 8;
    /*    */   public static final int STATEMENT_UNPREPARED = 9;
    /*    */   public static final int STATEMENT_OTHER = 99;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/DatabaseUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */