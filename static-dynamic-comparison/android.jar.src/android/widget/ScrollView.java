/*    */
package android.widget;
/*    */ 
/*    */

import android.view.View;

/*    */
/*  5 */ public class ScrollView extends FrameLayout {
    public ScrollView(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ScrollView(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ScrollView(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean shouldDelayChildPressedState() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    protected float getTopFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected float getBottomFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getMaxScrollAmount() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void addView(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void addView(View child, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean isFillViewport() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setFillViewport(boolean fillViewport) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean isSmoothScrollingEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean executeKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean onInterceptTouchEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean onTouchEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean onGenericMotionEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean performAccessibilityAction(int action, android.os.Bundle arguments) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean pageScroll(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean fullScroll(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean arrowScroll(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public final void smoothScrollBy(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public final void smoothScrollTo(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    protected int computeVerticalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    protected int computeVerticalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void computeScroll() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    protected int computeScrollDeltaToGetChildRectOnScreen(android.graphics.Rect rect) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void requestChildFocus(View child, View focused) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    protected boolean onRequestFocusInDescendants(int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean requestChildRectangleOnScreen(View child, android.graphics.Rect rectangle, boolean immediate) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void fling(int velocityY) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void scrollTo(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void setOverScrollMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ScrollView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */