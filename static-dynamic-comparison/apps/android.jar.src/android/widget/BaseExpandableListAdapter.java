/*    */
package android.widget;
/*    */ 
/*    */

import android.database.DataSetObserver;

/*    */
/*  5 */ public abstract class BaseExpandableListAdapter implements ExpandableListAdapter, HeterogeneousExpandableList {
    public BaseExpandableListAdapter() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void registerDataSetObserver(DataSetObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void unregisterDataSetObserver(DataSetObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void notifyDataSetInvalidated() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void notifyDataSetChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean areAllItemsEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onGroupCollapsed(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onGroupExpanded(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public long getCombinedChildId(long groupId, long childId) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public long getCombinedGroupId(long groupId) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean isEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getChildType(int groupPosition, int childPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getChildTypeCount() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getGroupType(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getGroupTypeCount() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/BaseExpandableListAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */