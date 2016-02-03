/*    */
package android.database.sqlite;
/*    */

import java.util.Set;

/*    */
/*  4 */ public class SQLiteQueryBuilder {
    public SQLiteQueryBuilder() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public void setDistinct(boolean distinct) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getTables() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setTables(String inTables) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void appendWhere(CharSequence inWhere) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void appendWhereEscapeString(String inWhere) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setProjectionMap(java.util.Map<String, String> columnMap) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setCursorFactory(SQLiteDatabase.CursorFactory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setStrict(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static String buildQueryString(boolean distinct, String tables, String[] columns, String where, String groupBy, String having, String orderBy, String limit) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static void appendColumns(StringBuilder s, String[] columns) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public android.database.Cursor query(SQLiteDatabase db, String[] projectionIn, String selection, String[] selectionArgs, String groupBy, String having, String sortOrder) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.database.Cursor query(SQLiteDatabase db, String[] projectionIn, String selection, String[] selectionArgs, String groupBy, String having, String sortOrder, String limit) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public android.database.Cursor query(SQLiteDatabase db, String[] projectionIn, String selection, String[] selectionArgs, String groupBy, String having, String sortOrder, String limit, android.os.CancellationSignal cancellationSignal) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public String buildQuery(String[] projectionIn, String selection, String groupBy, String having, String sortOrder, String limit) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 20 */ public String buildQuery(String[] projectionIn, String selection, String[] selectionArgs, String groupBy, String having, String sortOrder, String limit) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public String buildUnionSubQuery(String typeDiscriminatorColumn, String[] unionColumns, Set<String> columnsPresentInTable, int computedColumnsOffset, String typeDiscriminatorValue, String selection, String groupBy, String having) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 23 */ public String buildUnionSubQuery(String typeDiscriminatorColumn, String[] unionColumns, Set<String> columnsPresentInTable, int computedColumnsOffset, String typeDiscriminatorValue, String selection, String[] selectionArgs, String groupBy, String having) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public String buildUnionQuery(String[] subQueries, String sortOrder, String limit) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/sqlite/SQLiteQueryBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */