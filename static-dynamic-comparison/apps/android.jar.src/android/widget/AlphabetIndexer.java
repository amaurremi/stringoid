/*    */
package android.widget;
/*    */ 
/*    */

import android.database.Cursor;

/*    */
/*    */ public class AlphabetIndexer extends android.database.DataSetObserver implements SectionIndexer {
    /*  6 */
    public AlphabetIndexer(Cursor cursor, int sortedColumnIndex, CharSequence alphabet) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public Object[] getSections() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setCursor(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    protected int compare(String word, String letter) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getPositionForSection(int sectionIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getSectionForPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onInvalidated() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   protected Cursor mDataCursor;
    /*    */   protected int mColumnIndex;
    /*    */   protected CharSequence mAlphabet;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AlphabetIndexer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */