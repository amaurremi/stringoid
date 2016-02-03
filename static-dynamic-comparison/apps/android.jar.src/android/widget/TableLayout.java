/*    */
package android.widget;
/*    */ 
/*    */

import android.view.ViewGroup.LayoutParams;

/*    */
/*    */ public class TableLayout extends LinearLayout
/*    */ {
    /*    */   public static class LayoutParams extends LinearLayout.LayoutParams {
        /*    */
        public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
/*  9 */
            super();
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public LayoutParams(int w, int h) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams(int w, int h, float initWeight) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams() {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public LayoutParams(ViewGroup.LayoutParams p) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 17 */
    public TableLayout(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public TableLayout(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean isShrinkAllColumns() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setShrinkAllColumns(boolean shrinkAllColumns) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean isStretchAllColumns() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setStretchAllColumns(boolean stretchAllColumns) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setColumnCollapsed(int columnIndex, boolean isCollapsed) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isColumnCollapsed(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setColumnStretchable(int columnIndex, boolean isStretchable) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean isColumnStretchable(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setColumnShrinkable(int columnIndex, boolean isShrinkable) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean isColumnShrinkable(int columnIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void addView(android.view.View child) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void addView(android.view.View child, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void addView(android.view.View child, ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void addView(android.view.View child, int index, ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/TableLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */