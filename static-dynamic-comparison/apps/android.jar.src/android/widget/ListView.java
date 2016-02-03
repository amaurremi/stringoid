/*    */
package android.widget;
/*    */ 
/*    */

import android.view.View;

/*    */
/*    */
@RemoteViews.RemoteView
/*    */ public class ListView extends AbsListView {
    public class FixedViewInfo {
        public View view;

        /*    */
/*  8 */
        public FixedViewInfo() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public Object data;
        /*    */     public boolean isSelectable;
    }

    /*    */
/* 13 */
    public ListView(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public ListView(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public ListView(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getMaxScrollAmount() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void addHeaderView(View v, Object data, boolean isSelectable) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void addHeaderView(View v) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getHeaderViewsCount() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean removeHeaderView(View v) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void addFooterView(View v, Object data, boolean isSelectable) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void addFooterView(View v) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getFooterViewsCount() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean removeFooterView(View v) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public ListAdapter getAdapter() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setRemoteViewsAdapter(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setAdapter(ListAdapter adapter) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean requestChildRectangleOnScreen(View child, android.graphics.Rect rect, boolean immediate) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void smoothScrollToPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void smoothScrollByOffset(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    protected void layoutChildren() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    protected boolean canAnimate() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void setSelection(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setSelectionFromTop(int position, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setSelectionAfterHeaderView() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setItemsCanFocus(boolean itemsCanFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean getItemsCanFocus() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean isOpaque() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void setCacheColorHint(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    protected boolean drawChild(android.graphics.Canvas canvas, View child, long drawingTime) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public android.graphics.drawable.Drawable getDivider() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void setDivider(android.graphics.drawable.Drawable divider) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public int getDividerHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void setDividerHeight(int height) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void setHeaderDividersEnabled(boolean headerDividersEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void setFooterDividersEnabled(boolean footerDividersEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void setOverscrollHeader(android.graphics.drawable.Drawable header) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public android.graphics.drawable.Drawable getOverscrollHeader() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void setOverscrollFooter(android.graphics.drawable.Drawable footer) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public android.graphics.drawable.Drawable getOverscrollFooter() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    protected void onFinishInflate() {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    protected View findViewTraversal(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    protected View findViewWithTagTraversal(Object tag) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 63 */ public long[] getCheckItemIds() {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ListView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */