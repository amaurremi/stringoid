/*    */
package android.widget;
/*    */ 
/*    */

import java.util.List;

/*    */
/*  5 */ public class SimpleExpandableListAdapter extends BaseExpandableListAdapter {
    public SimpleExpandableListAdapter(android.content.Context context, List<? extends java.util.Map<String, ?>> groupData, int groupLayout, String[] groupFrom, int[] groupTo, List<? extends List<? extends java.util.Map<String, ?>>> childData, int childLayout, String[] childFrom, int[] childTo) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public SimpleExpandableListAdapter(android.content.Context context, List<? extends java.util.Map<String, ?>> groupData, int expandedGroupLayout, int collapsedGroupLayout, String[] groupFrom, int[] groupTo, List<? extends List<? extends java.util.Map<String, ?>>> childData, int childLayout, String[] childFrom, int[] childTo) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public SimpleExpandableListAdapter(android.content.Context context, List<? extends java.util.Map<String, ?>> groupData, int expandedGroupLayout, int collapsedGroupLayout, String[] groupFrom, int[] groupTo, List<? extends List<? extends java.util.Map<String, ?>>> childData, int childLayout, int lastChildLayout, String[] childFrom, int[] childTo) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public Object getChild(int groupPosition, int childPosition) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public long getChildId(int groupPosition, int childPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public android.view.View getChildView(int groupPosition, int childPosition, boolean isLastChild, android.view.View convertView, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.view.View newChildView(boolean isLastChild, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getChildrenCount(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Object getGroup(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getGroupCount() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public long getGroupId(int groupPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.view.View getGroupView(int groupPosition, boolean isExpanded, android.view.View convertView, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public android.view.View newGroupView(boolean isExpanded, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean hasStableIds() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/SimpleExpandableListAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */