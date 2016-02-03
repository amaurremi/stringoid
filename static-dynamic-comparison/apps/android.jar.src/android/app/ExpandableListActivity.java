/*    */
package android.app;
/*    */ 
/*    */

import android.view.View;

/*    */
/*    */ public class ExpandableListActivity extends Activity implements android.view.View.OnCreateContextMenuListener, android.widget.ExpandableListView.OnChildClickListener, android.widget.ExpandableListView.OnGroupCollapseListener, android.widget.ExpandableListView.OnGroupExpandListener {
    /*  6 */
    public ExpandableListActivity() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean onChildClick(android.widget.ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void onGroupCollapse(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onGroupExpand(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void onRestoreInstanceState(android.os.Bundle state) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onContentChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setListAdapter(android.widget.ExpandableListAdapter adapter) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.widget.ExpandableListView getExpandableListView() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public android.widget.ExpandableListAdapter getExpandableListAdapter() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public long getSelectedId() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public long getSelectedPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setSelectedGroup(int groupPosition) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/ExpandableListActivity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */