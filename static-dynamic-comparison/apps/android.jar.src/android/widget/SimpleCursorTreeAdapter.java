/*    */
package android.widget;
/*    */ 
/*    */

import android.database.Cursor;

/*    */
/*    */ public abstract class SimpleCursorTreeAdapter extends ResourceCursorTreeAdapter
/*    */ {
    /*    */
    public SimpleCursorTreeAdapter(android.content.Context context, Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, String[] groupFrom, int[] groupTo, int childLayout, int lastChildLayout, String[] childFrom, int[] childTo)
/*    */ {
/*  9 */
        super((android.content.Context) null, (Cursor) null, 0, 0);
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public SimpleCursorTreeAdapter(android.content.Context context, Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, String[] groupFrom, int[] groupTo, int childLayout, String[] childFrom, int[] childTo) {
        super((android.content.Context) null, (Cursor) null, 0, 0);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public SimpleCursorTreeAdapter(android.content.Context context, Cursor cursor, int groupLayout, String[] groupFrom, int[] groupTo, int childLayout, String[] childFrom, int[] childTo) {
        super((android.content.Context) null, (Cursor) null, 0, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public ViewBinder getViewBinder() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setViewBinder(ViewBinder viewBinder) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    protected void bindChildView(android.view.View view, android.content.Context context, Cursor cursor, boolean isLastChild) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected void bindGroupView(android.view.View view, android.content.Context context, Cursor cursor, boolean isExpanded) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void setViewImage(ImageView v, String value) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setViewText(TextView v, String text) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface ViewBinder
/*    */ {
        /*    */
        public abstract boolean setViewValue(android.view.View paramView, Cursor paramCursor, int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/SimpleCursorTreeAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */