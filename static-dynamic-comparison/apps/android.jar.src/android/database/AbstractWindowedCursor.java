/*    */
package android.database;

/*    */
/*    */ public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    /*    */
/*  5 */
    public AbstractWindowedCursor() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public byte[] getBlob(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getString(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public short getShort(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getInt(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public long getLong(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public float getFloat(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public double getDouble(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean isNull(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 16 */ public boolean isBlob(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 18 */ public boolean isString(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 20 */ public boolean isLong(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 22 */ public boolean isFloat(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getType(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected void checkPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public CursorWindow getWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setWindow(CursorWindow window) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean hasWindow() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/AbstractWindowedCursor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */