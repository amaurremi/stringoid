/*    */
package android.widget;
/*    */ 
/*    */

import android.view.MotionEvent;

/*    */
/*    */
@Deprecated
/*    */ public class Gallery extends AbsSpinner implements android.view.GestureDetector.OnGestureListener
/*    */ {
    /*    */   public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        /*    */
        public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
/* 10 */
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams(int w, int h) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 14 */
    public Gallery(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public Gallery(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public Gallery(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setCallbackDuringFling(boolean shouldCallback) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setAnimationDuration(int animationDurationMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setSpacing(int spacing) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setUnselectedAlpha(float unselectedAlpha) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected boolean getChildStaticTransformation(android.view.View child, android.view.animation.Transformation t) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected int computeHorizontalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected int computeHorizontalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected int computeHorizontalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean onTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean onSingleTapUp(MotionEvent e) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public boolean onDown(MotionEvent e) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void onLongPress(MotionEvent e) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void onShowPress(MotionEvent e) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void dispatchSetSelected(boolean selected) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected void dispatchSetPressed(boolean pressed) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public boolean showContextMenuForChild(android.view.View originalView) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean showContextMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    protected int getChildDrawingOrder(int childCount, int i) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public boolean performAccessibilityAction(int action, android.os.Bundle arguments) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/Gallery.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */