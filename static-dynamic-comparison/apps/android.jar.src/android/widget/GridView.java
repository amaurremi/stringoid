/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */
@RemoteViews.RemoteView
/*  6 */ public class GridView extends AbsListView {
    public GridView(Context context) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public GridView(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public GridView(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public ListAdapter getAdapter() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setRemoteViewsAdapter(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setAdapter(ListAdapter adapter) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void smoothScrollToPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void smoothScrollByOffset(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected void attachLayoutAnimationParameters(android.view.View child, android.view.ViewGroup.LayoutParams params, int index, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void layoutChildren() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setSelection(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getGravity() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setHorizontalSpacing(int horizontalSpacing) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getHorizontalSpacing() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getRequestedHorizontalSpacing() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setVerticalSpacing(int verticalSpacing) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public int getVerticalSpacing() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setStretchMode(int stretchMode) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getStretchMode() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setColumnWidth(int columnWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int getColumnWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int getRequestedColumnWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setNumColumns(int numColumns) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @android.view.ViewDebug.ExportedProperty
/* 36 */ public int getNumColumns() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    protected int computeVerticalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected int computeVerticalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    protected int computeVerticalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int NO_STRETCH = 0;
    /*    */   public static final int STRETCH_SPACING = 1;
    /*    */   public static final int STRETCH_COLUMN_WIDTH = 2;
    /*    */   public static final int STRETCH_SPACING_UNIFORM = 3;
    /*    */   public static final int AUTO_FIT = -1;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/GridView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */