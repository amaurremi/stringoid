/*    */
package android.database;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class CursorWindow extends android.database.sqlite.SQLiteClosable implements android.os.Parcelable {
    /*  6 */
    public CursorWindow(String name) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  8 */ public CursorWindow(boolean localWindow) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void clear() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getStartPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setStartPosition(int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getNumRows() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean setNumColumns(int columnNum) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean allocRow() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void freeLastRow() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 18 */ public boolean isNull(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 20 */ public boolean isBlob(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 22 */ public boolean isLong(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 24 */ public boolean isFloat(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 26 */ public boolean isString(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int getType(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public byte[] getBlob(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public String getString(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void copyStringToBuffer(int row, int column, CharArrayBuffer buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public long getLong(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public double getDouble(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public short getShort(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int getInt(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public float getFloat(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean putBlob(byte[] value, int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean putString(String value, int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean putLong(long value, int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean putDouble(double value, int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public boolean putNull(int row, int column) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public static CursorWindow newFromParcel(Parcel p) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    protected void onAllReferencesReleased() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 47 */   public static final android.os.Parcelable.Creator<CursorWindow> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/CursorWindow.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */