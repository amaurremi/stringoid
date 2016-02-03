/*    */
package android.widget;
/*    */ 
/*    */

import android.view.ViewGroup.MarginLayoutParams;

/*    */
/*    */ public class TableRow extends LinearLayout {
    public static class LayoutParams extends LinearLayout.LayoutParams {
        @android.view.ViewDebug.ExportedProperty(category = "layout")
/*    */ public int column;

        /*    */
/*  8 */
        public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public LayoutParams(int w, int h) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public LayoutParams(int w, int h, float initWeight) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams() {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(int column) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public LayoutParams(android.view.ViewGroup.LayoutParams p) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */
        @android.view.ViewDebug.ExportedProperty(category = "layout")
/*    */ public int span;
/*    */
    }

    /*    */
/* 21 */
    public TableRow(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public TableRow(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public android.view.View getVirtualChildAt(int i) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int getVirtualChildCount() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    protected LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/TableRow.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */