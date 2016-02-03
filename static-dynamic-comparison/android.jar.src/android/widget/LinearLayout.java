/*    */
package android.widget;
/*    */ 
/*    */

import android.view.ViewGroup.LayoutParams;

/*    */
/*    */
@RemoteViews.RemoteView
/*    */ public class LinearLayout extends android.view.ViewGroup {
    public static final int HORIZONTAL = 0;

    /*    */   public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        @android.view.ViewDebug.ExportedProperty(category = "layout")
/*    */ public float weight;

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
        public LayoutParams(int width, int height, float weight) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(ViewGroup.LayoutParams p) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public String debug(String output) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */
        @android.view.ViewDebug.ExportedProperty(category = "layout", mapping = {@android.view.ViewDebug.IntToString(from = -1, to = "NONE"), @android.view.ViewDebug.IntToString(from = 0, to = "NONE"), @android.view.ViewDebug.IntToString(from = 48, to = "TOP"), @android.view.ViewDebug.IntToString(from = 80, to = "BOTTOM"), @android.view.ViewDebug.IntToString(from = 3, to = "LEFT"), @android.view.ViewDebug.IntToString(from = 5, to = "RIGHT"), @android.view.ViewDebug.IntToString(from = 8388611, to = "START"), @android.view.ViewDebug.IntToString(from = 8388613, to = "END"), @android.view.ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @android.view.ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @android.view.ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @android.view.ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @android.view.ViewDebug.IntToString(from = 17, to = "CENTER"), @android.view.ViewDebug.IntToString(from = 119, to = "FILL")})
/*    */ public int gravity;
/*    */
    }

    /*    */
/* 20 */
    public LinearLayout(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public LinearLayout(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public LinearLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setShowDividers(int showDividers) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean shouldDelayChildPressedState() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getShowDividers() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public android.graphics.drawable.Drawable getDividerDrawable() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setDividerDrawable(android.graphics.drawable.Drawable divider) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setDividerPadding(int padding) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getDividerPadding() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    protected void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean isBaselineAligned() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setBaselineAligned(boolean baselineAligned) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean isMeasureWithLargestChildEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public int getBaselineAlignedChildIndex() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setBaselineAlignedChildIndex(int i) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public float getWeightSum() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setWeightSum(float weightSum) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setOrientation(int orientation) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public int getOrientation() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void setHorizontalGravity(int horizontalGravity) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setVerticalGravity(int verticalGravity) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    protected LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int VERTICAL = 1;
    /*    */   public static final int SHOW_DIVIDER_NONE = 0;
    /*    */   public static final int SHOW_DIVIDER_BEGINNING = 1;
    /*    */   public static final int SHOW_DIVIDER_MIDDLE = 2;
    /*    */   public static final int SHOW_DIVIDER_END = 4;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/LinearLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */