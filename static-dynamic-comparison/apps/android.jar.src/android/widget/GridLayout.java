/*    */
package android.widget;
/*    */ 
/*    */

import android.view.ViewGroup.LayoutParams;

/*    */
/*    */
@RemoteViews.RemoteView
/*    */ public class GridLayout extends android.view.ViewGroup {
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public GridLayout.Spec rowSpec;
        /*    */     public GridLayout.Spec columnSpec;

        /*    */
/*  9 */
        public LayoutParams(GridLayout.Spec rowSpec, GridLayout.Spec columnSpec) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public LayoutParams() {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public LayoutParams(ViewGroup.LayoutParams params) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public LayoutParams(android.view.ViewGroup.MarginLayoutParams params) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public LayoutParams(LayoutParams that) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public LayoutParams(android.content.Context context, android.util.AttributeSet attrs) {
            super();
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public void setGravity(int gravity) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        protected void setBaseAttributes(android.content.res.TypedArray attributes, int widthAttr, int heightAttr) {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public boolean equals(Object o) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public int hashCode() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */ 
/*    */   public static class Spec
/*    */ {
        /* 24 */     Spec() {
            throw new RuntimeException("Stub!");
        }

        /* 25 */
        public boolean equals(Object that) {
            throw new RuntimeException("Stub!");
        }

        /* 26 */
        public int hashCode() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static abstract class Alignment {
        /* 30 */     Alignment() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 32 */
    public GridLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public GridLayout(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public GridLayout(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int getOrientation() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setOrientation(int orientation) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public int getRowCount() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setRowCount(int rowCount) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public int getColumnCount() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setColumnCount(int columnCount) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean getUseDefaultMargins() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setUseDefaultMargins(boolean useDefaultMargins) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public int getAlignmentMode() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setAlignmentMode(int alignmentMode) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public boolean isRowOrderPreserved() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setRowOrderPreserved(boolean rowOrderPreserved) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public boolean isColumnOrderPreserved() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void setColumnOrderPreserved(boolean columnOrderPreserved) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    protected LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    protected void onMeasure(int widthSpec, int heightSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public static Spec spec(int start, int size, Alignment alignment) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public static Spec spec(int start, Alignment alignment) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public static Spec spec(int start, int size) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public static Spec spec(int start) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 76 */   public static final Alignment FILL = null;
    public static final Alignment BASELINE = null;
    public static final Alignment CENTER = null;
    public static final Alignment RIGHT = null;
    public static final Alignment LEFT = null;
    public static final Alignment END = null;
    public static final Alignment START = null;
    public static final Alignment BOTTOM = null;
    public static final Alignment TOP = null;
    /*    */   public static final int ALIGN_MARGINS = 1;
    /*    */   public static final int ALIGN_BOUNDS = 0;
    /*    */   public static final int UNDEFINED = Integer.MIN_VALUE;
    /*    */   public static final int VERTICAL = 1;
    /*    */   public static final int HORIZONTAL = 0;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/GridLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */