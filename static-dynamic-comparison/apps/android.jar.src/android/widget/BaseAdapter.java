/*    */
package android.widget;
/*    */ 
/*    */

import android.database.DataSetObserver;

/*    */
/*  5 */ public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
    public BaseAdapter() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public boolean hasStableIds() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void registerDataSetObserver(DataSetObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void unregisterDataSetObserver(DataSetObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void notifyDataSetChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void notifyDataSetInvalidated() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean areAllItemsEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean isEnabled(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public android.view.View getDropDownView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getItemViewType(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getViewTypeCount() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean isEmpty() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/BaseAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */