/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.graphics.Canvas;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.MotionEvent;
/*    */ import android.view.View;
/*    */ import android.view.ViewGroup;
/*    */ import android.view.accessibility.AccessibilityNodeInfo;

/*    */
/*    */ public class SlidingDrawer extends ViewGroup
/*    */ {
    /*    */   public static final int ORIENTATION_HORIZONTAL = 0;
    /*    */   public static final int ORIENTATION_VERTICAL = 1;

    /*    */
/*    */
    public SlidingDrawer(Context context, AttributeSet attrs)
/*    */ {
/* 18 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public SlidingDrawer(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void onFinishInflate() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected void dispatchDraw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean onInterceptTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean onTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void toggle() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void animateToggle() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void open() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void animateClose() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void animateOpen() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setOnDrawerOpenListener(OnDrawerOpenListener onDrawerOpenListener) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void setOnDrawerCloseListener(OnDrawerCloseListener onDrawerCloseListener) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setOnDrawerScrollListener(OnDrawerScrollListener onDrawerScrollListener) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public View getHandle() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public View getContent() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void unlock() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void lock() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean isOpened() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean isMoving() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnDrawerScrollListener
/*    */ {
        /*    */
        public abstract void onScrollStarted();

        /*    */
/*    */
        public abstract void onScrollEnded();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnDrawerCloseListener
/*    */ {
        /*    */
        public abstract void onDrawerClosed();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnDrawerOpenListener
/*    */ {
        /*    */
        public abstract void onDrawerOpened();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/SlidingDrawer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */