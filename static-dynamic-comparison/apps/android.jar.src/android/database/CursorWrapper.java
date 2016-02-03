/*    */
package android.database;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*  5 */ public class CursorWrapper implements Cursor {
    public CursorWrapper(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Cursor getWrappedCursor() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean isClosed() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getCount() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void deactivate() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean moveToFirst() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getColumnCount() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getColumnIndex(String columnName) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String getColumnName(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String[] getColumnNames() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public double getDouble(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public Bundle getExtras() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public float getFloat(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getInt(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public long getLong(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public short getShort(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public String getString(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public byte[] getBlob(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean getWantsAllOnMoveCalls() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean isAfterLast() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean isBeforeFirst() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean isFirst() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean isLast() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public int getType(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean isNull(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean moveToLast() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public boolean move(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean moveToPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean moveToNext() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public int getPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean moveToPrevious() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void registerContentObserver(ContentObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void registerDataSetObserver(DataSetObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean requery() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public Bundle respond(Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void setNotificationUri(android.content.ContentResolver cr, android.net.Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void unregisterContentObserver(ContentObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void unregisterDataSetObserver(DataSetObserver observer) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/CursorWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */