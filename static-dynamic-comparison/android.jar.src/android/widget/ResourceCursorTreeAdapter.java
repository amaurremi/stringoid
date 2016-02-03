/*   */
package android.widget;
/*   */ 
/*   */

import android.content.Context;

/*   */
/* 5 */ public abstract class ResourceCursorTreeAdapter extends CursorTreeAdapter {
    public ResourceCursorTreeAdapter(Context context, android.database.Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, int childLayout, int lastChildLayout) {
        super((android.database.Cursor) null, (Context) null, false);
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public ResourceCursorTreeAdapter(Context context, android.database.Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, int childLayout) {
        super((android.database.Cursor) null, (Context) null, false);
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public ResourceCursorTreeAdapter(Context context, android.database.Cursor cursor, int groupLayout, int childLayout) {
        super((android.database.Cursor) null, (Context) null, false);
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public android.view.View newChildView(Context context, android.database.Cursor cursor, boolean isLastChild, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public android.view.View newGroupView(Context context, android.database.Cursor cursor, boolean isExpanded, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ResourceCursorTreeAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */