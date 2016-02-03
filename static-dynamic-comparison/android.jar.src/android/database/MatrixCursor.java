/*    */
package android.database;

/*    */
/*    */ public class MatrixCursor
/*    */ extends AbstractCursor
/*    */ {
    /*    */   public class RowBuilder {
        /*  7 */     RowBuilder() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public RowBuilder add(Object columnValue) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 10 */
    public MatrixCursor(String[] columnNames, int initialCapacity) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public MatrixCursor(String[] columnNames) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public RowBuilder newRow() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void addRow(Object[] columnValues) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void addRow(Iterable<?> columnValues) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getCount() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String[] getColumnNames() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public String getString(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public short getShort(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getInt(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public long getLong(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public float getFloat(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public double getDouble(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public byte[] getBlob(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getType(int column) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isNull(int column) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/MatrixCursor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */