/*   */
package android.database;

/*   */
/*   */ public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor
/*   */ {
    /*   */
    public CrossProcessCursorWrapper(Cursor cursor) {
/* 6 */
        super((Cursor) null);
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void fillWindow(int position, CursorWindow window) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public CursorWindow getWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public boolean onMove(int oldPosition, int newPosition) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/CrossProcessCursorWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */