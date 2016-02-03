/*    */
package android.widget;
/*    */ 
/*    */

import android.view.ViewGroup.LayoutParams;

/*    */
/*    */
@RemoteViews.RemoteView
/*    */ public class FrameLayout extends android.view.ViewGroup {
    /*    */   public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public int gravity;

        /*    */
/*  9 */
        public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public LayoutParams(int width, int height) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams(int width, int height, int gravity) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(ViewGroup.LayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
/*    */
        }
    }

    /*    */
/* 16 */
    public FrameLayout(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public FrameLayout(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public FrameLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getForegroundGravity() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setForegroundGravity(int foregroundGravity) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected boolean verifyDrawable(android.graphics.drawable.Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setForeground(android.graphics.drawable.Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public android.graphics.drawable.Drawable getForeground() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean gatherTransparentRegion(android.graphics.Region region) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setMeasureAllChildren(boolean measureAll) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 34 */ public boolean getConsiderGoneChildrenWhenMeasuring() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean getMeasureAllChildren() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean shouldDelayChildPressedState() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
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
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/FrameLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */