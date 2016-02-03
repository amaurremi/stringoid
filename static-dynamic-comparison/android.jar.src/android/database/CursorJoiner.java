/*    */
package android.database;
/*    */ 
/*    */

import java.util.Iterator;

/*    */
/*    */ public final class CursorJoiner implements Iterator<Result>, Iterable<Result> {
    /*    */   public static enum Result {
        /*  7 */     BOTH,
        /*  8 */     LEFT,
        /*  9 */     RIGHT;

        /*    */
        private Result() {
        }
    }

    /* 11 */
    public CursorJoiner(Cursor cursorLeft, String[] columnNamesLeft, Cursor cursorRight, String[] columnNamesRight) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Iterator<Result> iterator() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public Result next() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void remove() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/CursorJoiner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */